package com.example.servlet;
import java.util.ArrayList;
import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees")
public class employeeServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int salary = Integer.parseInt(request.getParameter("salary"));

        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setSalary(salary);

        EmployeeDao dao = new EmployeeDao();

        try{
            dao.addEmployee(emp);
            response.sendRedirect(request.getContextPath()+"/employees");
        }
        catch (Exception e){
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        Employee emp = new Employee();

        EmployeeDao dao = new EmployeeDao();

        try{
            ArrayList<Employee> employee = dao.getAllEmployee();

            request.setAttribute("employees",employee);

            request.getRequestDispatcher("/employees.jsp").forward(request,response);
        }
        catch (Exception e){
            throw new ServletException(e);
        }
    }
}
