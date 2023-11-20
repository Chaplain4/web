package main.org.example.servlets;

import main.org.example.jdbc.impl.EmployeeDAOImpl;
import main.org.example.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees")
public class EmployeesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDAOImpl edi = new EmployeeDAOImpl();
        if (req.getParameter("action") != null) {
            if (req.getParameter("action").equals("D")) {
                edi.deleteById(Integer.parseInt(req.getParameter("id")));
            }
        }
        req.setAttribute("empls", edi.all());
        ServletUtils.openJSP(req, resp, "employees");
    }
}
