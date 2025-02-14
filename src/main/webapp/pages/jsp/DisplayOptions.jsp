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
        <h1>Read e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="<%= request.getContextPath() %>/images/mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <h1>Display Entry</h1>
                <a href="/viewsearch" class="button">Display Entry</a>
                <a href="/viewallentry" class="button">Display All Entry</a>
            </div>
        </div>
    </main>
</body>
</html>
