<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My e-Diary</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/Entries.css">
    <style>
        .table-container {
            width: 85%;
            margin: auto;
            overflow-x: hidden; 
        }
        table {
            width: 100%;
            border-spacing: 0 3px;
        }
        th, td {
            padding: 3px; 
            border: 1px solid #ddd;
            text-align: left;
        }
        thead {
            background-color: #f2f2f2; 
            display: table;
            width: 100%; 
            table-layout: fixed;
        }
        tbody {
            display: block;
            max-height: 185px; 
            overflow-y: auto;
        }
        tbody tr {
            display: table;
            width: 100%;
            table-layout: fixed;
        }
        .button-container {
            margin-left:325px;
        }
    </style>
</head>
<body>
    <header>
        <div class="logo">My e-Diary</div>
        <div class="logout">
            <a href="/signout">Log Out</a>
        </div>
    </header>
    <main>
        <h1>Update e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="<%= request.getContextPath() %>/images/mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <h2 align="center">${msg}</h2>
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>Field</th>
                                <th>Details</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>UID</td>
                                <td>${uid}</td>
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td>${updatedEntry.date}</td>
                            </tr>
                            <tr>
                                <td>Description</td>
                                <td>${updatedEntry.description}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="button-container">
                    <a href="/homepage" class="button">Home</a>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
