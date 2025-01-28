<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
<head>
  <title>Add User</title>
</head>
<body>
  <h1>Add New User</h1>
  <form action="UserServlet?action=add" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>
    <input type="submit" value="Add User">
  </form>
  <br>
  <a href="UserServlet?action=list">Back to User List</a>
</body>
</html>
