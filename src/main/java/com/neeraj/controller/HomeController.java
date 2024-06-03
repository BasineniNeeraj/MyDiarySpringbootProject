package com.neeraj.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neeraj.entity.Entry;
import com.neeraj.entity.User;
import com.neeraj.service.EntryService;
import com.neeraj.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    HttpSession session;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private EntryService entryService;
    
    // Registration page
    @GetMapping("/register")
    public String registrationpage() {
        return "Registration";
    }

    @PostMapping(value = "/saveuser")
    public String saveuser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
    
    // Login page
    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @PostMapping(value = "/authenticate")
    public String authenticateuser(@ModelAttribute("user") User user, Model model) {
        String viewname = "Login";
        User user1 = userService.findByUname(user.getUname());
        if (user1 != null && user.getPassword().equals(user1.getPassword())) {
            viewname = "Welcome";
            model.addAttribute("user", user1);
            session.setAttribute("user", user1);
        }
        return viewname;
    }
    
    // Forgot Password
    @GetMapping("/forgotsearch")
    public String forgotPassword() {
        return "ForgotSearch";
    }
    
    @GetMapping("/forgotpassword")
    public String forgotPassword(@RequestParam("phone") String phone, Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user1 != null) {
            return "redirect:/register";
        }
        
        User user = userService.findByPhone(phone);
        
        if (user == null) {
            model.addAttribute("msg", "User not found for the provided phone number.");
            return "ForgotSearch"; 
        }
        
        model.addAttribute("uname", user.getUname());
        model.addAttribute("password", user.getPassword());
        return "ForgotPassword"; 
    }

    
    // Home page
    @GetMapping("/homepage")
    public String userhomepage(Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null) {
            return "redirect:/login"; 
        }
        return "Welcome";
    }
    
    // Write Entry
    @GetMapping("/addentry")
    public String addentry() {
        return "AddEntry";
    }

    @PostMapping("/saveentry")
    public String saveentry(@ModelAttribute("entry") Entry entry, Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user1 != null) {
            entry.setUid(user1.getUid()); 
            
            Date sqlDate = new Date(entry.getDate().getTime());
            Entry existingEntry = entryService.findEntryByDate(user1.getUid(), sqlDate);
            if (existingEntry != null) {
                model.addAttribute("msg", "An entry already exists for the specified date.");
                return "AddEntry";
            }
            
            entryService.saveEntry(entry);
            return "AddSuccess";
        } else {
            return "redirect:/login"; 
        }
    }

    // View Entry
    @GetMapping("/viewentry")
    public String displayOptions() {
        return "DisplayOptions";
    }
    
    @GetMapping("/viewsearch")
    public String displaySearch() {
        return "DisplaySearch";
    }
    
    @GetMapping("/viewsingleentry")
    public String viewSingleEntry(@RequestParam("date") String date, Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null) {
            return "redirect:/login";
        }
        int uid = user1.getUid();
        LocalDate localDate = LocalDate.parse(date);
        Date sqlDate = Date.valueOf(localDate);
        
        Entry entry = entryService.findEntryByDate(uid, sqlDate);
        if (entry == null) {
        	model.addAttribute("msg", "Invalid date. Please try with another date.");
            return "DisplaySearch"; 
        }
        
        entry.setDate(sqlDate);
        model.addAttribute("entry", entry);
        
        return "DisplayEntry";
    }
    
    @GetMapping("/viewallentry")
    public String viewAllEntries(Model model, HttpSession session) {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null) {
            return "redirect:/login";
        }
        int uid = user1.getUid();
        
        List<Entry> entries = entryService.findByUid(uid);
        for (Entry entry : entries) {
            LocalDate localDate = LocalDate.parse(entry.getDate().toString().split(" ")[0]);
            Date sqlDate = Date.valueOf(localDate);
            entry.setDate(sqlDate);
        }
        
        Collections.sort(entries, Comparator.comparing(Entry::getDate));
        model.addAttribute("entrieslist", entries);
        
        return "DisplayAllEntry"; 
    }
    
    // Update Entry
    @GetMapping("/updatesearch")
    public String updateSearch() {
        return "UpdateSearch";
    }
    
    @GetMapping("/updateentry")
    public String updateEntry(@RequestParam("date") String date, Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null) {
            return "redirect:/login";
        }
        int uid = user1.getUid();
        LocalDate localDate = LocalDate.parse(date);
        Date sqlDate = Date.valueOf(localDate);
        
        Entry entry = entryService.findEntryByDate(uid, sqlDate);
        if (entry == null) {
            model.addAttribute("msg", "No entry found for the specified date. Please try with another date.");
            return "UpdateSearch";
        }

        model.addAttribute("Date", localDate.format(DateTimeFormatter.ISO_DATE));
        model.addAttribute("Description", entry.getDescription());
        
        return "UpdateEntry";
    }


    @PostMapping("/processupdateentry")
    public String processentryupdate(@RequestParam("date") String date, @RequestParam("description") String description, Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null) {
            return "redirect:/login";
        }
        int uid = user1.getUid();
        LocalDate localDate = LocalDate.parse(date);
        Date sqlDate = Date.valueOf(localDate);
        
        Entry entry = entryService.findEntryByDate(uid, sqlDate);
        if (entry == null) {
            model.addAttribute("msg", "No entry found for the specified date.");
            return "DisplaySearch";
        }
        
        entry.setDate(sqlDate);
        entry.setDescription(description);
        entryService.updateEntry(entry);
        
        model.addAttribute("msg", "Record Updated Successfully");
        model.addAttribute("updatedEntry", entry);
        model.addAttribute("uid", uid);
       
        return "SaveSuccess";
    }
    
    // Delete Entry
    @GetMapping("/deletesearch")
    public String deleteSearch() {
        return "DeleteSearch";
    }
    
    @GetMapping("/deleteentry")
    public String deleteEntry(@RequestParam("date") String date, Model model) {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null) {
            return "redirect:/login";
        }
        int uid = user1.getUid();
        LocalDate localDate = LocalDate.parse(date);
        Date sqlDate = Date.valueOf(localDate);
        
        Entry entry = entryService.findEntryByDate(uid, sqlDate);
        if (entry == null) {
            model.addAttribute("msg", "Entry not found for the specified date.");
            return "DeleteSearch"; 
        }
        
        entryService.deleteEntry(entry);
        
        model.addAttribute("msg", "Entry deleted successfully.");
        return "DeleteEntry"; 
    }

    
    // Log out
    @GetMapping("/signout")
    public String signout() {
        session.invalidate();
        return "Login";
    }

}