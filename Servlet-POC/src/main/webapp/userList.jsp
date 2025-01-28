<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.poc.curd.servlet.Employee" %>
<html>
<head>
  <title>Users List</title>
</head>
<body>
  <h1>Users</h1>
  <table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <%
    List<Employee> employees = (ArrayList)request.getSession().getAttribute("users");
    System.out.println(employees.size());
    
    %>
      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.employee_Id}</td>
          <td>${user.firstName}</td>
          <td>${user.email}</td>
          <td>
            <a href="UserServlet?action=edit&id=${user.employee_Id}">Edit</a>
            <a href="UserServlet?action=delete&id=${user.employee_Id}">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="addUser.jsp">Add New User</a>
</body>
</html>
