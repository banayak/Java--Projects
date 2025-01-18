package com.servelet.example;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericServletOldStyle extends GenericServlet {

    private  int counter =0;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Before increment counter :"+counter);
        counter = 5;
        System.out.println("After increment counter :"+counter);
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        counter ++;
        System.out.println("Am Here");
        out.println("<html>");
        out.println("<head><title>My first Servlet</title></head>");
        out.println("<body>");
        out.println("<h2>Welcome To Servlet World!</h2>");
        out.println("<h2> How many time servlet Hit : "+counter+"</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
