package com.dainiak.servlets;

import com.dainiak.servlets.utils.CalcOperations;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Alex Dainiak on 14-05-2015.
 */
public class FirstServlet extends HttpServlet {
    private static final Logger LOG = getLogger(FirstServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to index2");

        request.getRequestDispatcher("/index2.jsp").forward(request, response);
        //response.sendRedirect("index2.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double i = null;
        char ch='a';
        Double one = Double.valueOf(request.getParameter("one"));
        Double two = Double.valueOf(request.getParameter("two"));
        String operation = request.getParameter("operation");
        CalcOperations calcOperations = new CalcOperations();
        if (operation.equals("add")) {
            i = calcOperations.add(one, two);
            ch = '+';
        }
        if (operation.equals("subtract")) {
            i = calcOperations.subtract(one, two);
            ch = '-';
        }
        if (operation.equals("multiply")) {
            i = calcOperations.multiply(one, two);
            ch = '*';
        }
        if (operation.equals("divide")) {
            i = calcOperations.divide(one, two);
            ch = '/';
        }
        LOG.debug("log computing....");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /*try {
            *//* TODO output your page here. You may use following sample code. *//*
            out.println("<html>"
                    + "<head>"
                    + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
                    + "<title>Вычисления</title>"
                    + "</head>"
                    + "<body>"
                    + "<h3>" + System.out.print(one + ch + two + " = " + i) + "</h3>"
                    + "</body>"
                    + "</html>");
        } finally {
            out.close();
        }*/
       /* Enumeration e = request.getParameterNames();

        while (e.hasMoreElements()){
            String param = e.nextElement().toString();
            out.println("<h1> Param  "+ param +" = "+ request.getParameter(param)+"</h1>");
        }*/

        //request.getRequestDispatcher("/index2.jsp").forward(request, response);
        // response.sendRedirect("index2.jsp");
    }
}
