package com.neeraj.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.entity.Entry;
import com.neeraj.repository.EntryRepository;
@Service
public class EntryServiceImpl implements EntryService {
	@Autowired 
	private EntryRepository entryRepository;
	@Override
	public Entry saveEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public Entry updateEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public void deleteEntry(Entry entry) {
		entryRepository.delete(entry);

	}

	@Override
	public Entry findEntry(Integer uid) {
		return entryRepository.findById(uid).get();
	}

	@Override
	public List<Entry> findAllEntries() {
		return entryRepository.findAll();
	}

	@Override
	public List<Entry> findByUid(int uid) {
		return entryRepository.findByUid(uid);
	}
	
	@Override
	public Entry findEntryByDate(int uid, Date date) {
	   	    return entryRepository.findByUidAndDate(uid, date);
	}


}
