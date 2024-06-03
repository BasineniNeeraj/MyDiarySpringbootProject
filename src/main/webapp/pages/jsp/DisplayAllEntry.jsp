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
            width: 100%;
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
    </style>
</head>
<body>
    <header>
        <div class="logo">My e-Diary</div>
        <div class="logout">
            <a href="Login.jsp">Log Out</a>
        </div>
    </header>
    <main>
        <h1>Read e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="<%= request.getContextPath() %>/images/mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <form action="DisplayAllEntry" method="get">
                    <div class="form-group">
                        <h2>All Entries</h2>
                        <div class="table-container">
                            <table>
                                <thead>
                                    <tr>
                                        <th>UID</th>
                                        <th>Date</th>
                                        <th>Description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="entry" items="${entrieslist}">
                                        <tr>
                                            <td>${entry.uid}</td>
                                            <td>${entry.date}</td>
                                            <td>${entry.description}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <a href="/homepage" class="button">Home</a>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
