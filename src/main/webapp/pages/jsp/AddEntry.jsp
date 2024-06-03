<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My e-Diary</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/Entries.css">
</head>
<body>
    <header>
        <div class="logo">My e-Diary</div>
        <div class="logout">
            <a href="/signout">Log Out</a>
        </div>
    </header>
    <main>
        <h1>Write e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="<%= request.getContextPath() %>/images/mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <form action="./saveentry" method="post">
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input type="date" id="date" name="date" required/>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea id="description" name="description" required placeholder="Enter the description"></textarea>
                    </div>
                    <div class="form-group">
                        <a href="/homepage" class="button">Home</a>
                        <button type="submit">Submit</button>
                    </div>
                </form>
                <c:if test="${not empty message}">
                    <div class="error-message">
                        ${message}
                    </div>
                </c:if>
            </div>
        </div>
    </main>
</body>
</html>
