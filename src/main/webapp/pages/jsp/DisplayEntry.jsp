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
            width: calc(100% - 1em); 
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
            margin-left:210px;
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
        <h1>Read e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="<%= request.getContextPath() %>/images/mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <c:if test="${not empty entry}">
                    <div class="form-group">
                        <h2>Entry Details</h2>
                        <div class="table-container">
                            <table>
                                <thead>
                                    <tr>
                                        <td>UID</td>
                                        <td>${entry.uid}</td>
                                    </tr>
                                    <tr>
                                        <td>Date</td>
                                        <td>${entry.date}</td>
                                    </tr>
                                    <tr>
                                        <td>Description</td>
                                        <td>${entry.description}</td>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <div class="button-container">
                        <a href="/viewallentry" class="button">Display All Entry</a>
                        <a href="/homepage" class="button">Home</a>
                    </div>
                </c:if>
        	</div>
        </div>
    </main>
</body>
</html>
