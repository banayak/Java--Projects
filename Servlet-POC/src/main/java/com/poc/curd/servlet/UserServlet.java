package com.poc.curd.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.poc.curd.util.DBUtil;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			action = "list";
		}

		switch (action) {
		case "list":
			listUsers(request, response);
			break;
		case "edit":
			editUser(request, response);
			break;
		case "delete":
			deleteUser(request, response);
			break;
		default:
			listUsers(request, response);
			break;
		}
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = "SELECT * FROM employees where EMPLOYEE_ID between 100 and 110";
		List<Employee> employees = new ArrayList();
		try {

			Connection connection = DBUtil.getConnection();

			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();	
			Employee employee = null;
			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				employees.add(employee);
			}

			// Convert ResultSet into a List or array
			request.getSession().setAttribute("users", employees);
			request.getRequestDispatcher("/userList.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void editUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		String query = "UPDATE users SET name = ?, email = ? WHERE id = ?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, id);

			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				response.sendRedirect("UserServlet?action=list");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		String query = "DELETE FROM users WHERE id = ?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, id);
			int rowsDeleted = ps.executeUpdate();
			if (rowsDeleted > 0) {
				response.sendRedirect("UserServlet?action=list");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Handle POST request for adding a new user
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {
			addUser(request, response);
		}
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		String query = "INSERT INTO users (name, email) VALUES (?, ?)";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, name);
			ps.setString(2, email);

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				// Redirect to the user list page after successful addition
				response.sendRedirect("UserServlet?action=list");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
