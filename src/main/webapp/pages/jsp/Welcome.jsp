<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My e-Diary</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/Welcome.css">
</head>
<body>
    <header>
        <div class="logo">My e-Diary</div>
        <div class="logout">
            <a href="/signout">Log Out</a>
        </div>
    </header>
    <main>
        <h1>Welcome to My e-Diary</h1>
        <p>What would you like to do today?</p>
        <div class="content">
            <div class="image">
                <img src="<%= request.getContextPath() %>/images/mydiary.jpg" alt="Diary Image">
            </div>
            <div class="options">
                <a href="/addentry" class="option">Add Entry</a>
                <a href="/viewentry" class="option">View Entry</a>
                <a href="/updatesearch" class="option">Update Entry</a>
                <a href="/deletesearch" class="option">Delete Entry</a>
            </div>
        </div>
    </main>
</body>
</html>
