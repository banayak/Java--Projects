package com.servelet.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyservletOldFashion extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        System.out.printf("Am Here");
        out.println("<html>");
        out.println("<head><title>My first Servlet</title></head>");
        out.println("<body>");
        out.println("<h2>Welcome To Servlet World!</h2>");
        out.println("</body>");
        out.println("</html>");


        String employeeId = request.getQueryString();
        request.setAttribute("employee",employeeId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DemoServlet1");
        requestDispatcher.forward(request,response);
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        System.out.printf("Am Here");
        out.println("<html>");
        out.println("<head><title>My first Servlet</title></head>");
        out.println("<body>");
        out.println("<h2>Welcome To Servlet World!</h2>");
        out.println("</body>");
        out.println("</html>");


        String employeeId = request.getQueryString();
        request.setAttribute("employee",employeeId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DemoServlet1");
        requestDispatcher.forward(request,response);

        //response.sendRedirect("DemoServlet1");
        out.close();
    }
}
