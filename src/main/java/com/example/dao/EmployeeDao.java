package com.example.dao;

import com.example.model.Employee;
import com.example.util.Dbconnection;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {

    public boolean addEmployee(Employee emp) throws SQLException, ClassNotFoundException{

        Connection con = Dbconnection.getConnection();

        PreparedStatement pst = con.prepareStatement("INSERT INTO employee (name,email,salary) values (?,?,?)");
        pst.setString(1,emp.getName());
        pst.setString(2,emp.getEmail());
        pst.setInt(3,emp.getSalary());

        int result = pst.executeUpdate();

        con.close();

        return result > 0;
    }

    public ArrayList<Employee> getAllEmployee() throws SQLException,ClassNotFoundException {

        ArrayList<Employee> list = new ArrayList<>();
        Connection con = Dbconnection.getConnection();

        PreparedStatement ps = con.prepareStatement("Select * from employee;");

        ResultSet rs = ps.executeQuery();


        while(rs.next()){
            Employee emp = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getInt("salary"));
            list.add(emp);
        }

        con.close();

        return list;
    }

    public Employee getEmployee(int id) throws SQLException,ClassNotFoundException {

        Connection con = Dbconnection.getConnection();

        PreparedStatement ps = con.prepareStatement("Select * from employee where id = ?");
        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();

        Employee emp = null;

        if(rs.next()){
            emp = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getInt("salary"));
        }
        con.close();

        return emp;
    }

    public boolean updateEmployee(Employee emp) throws SQLException,ClassNotFoundException {

        Connection con = Dbconnection.getConnection();

        PreparedStatement pst = con.prepareStatement("Update employee set name = ?, email = ? , salary = ? where id = ?");

        pst.setString(1, emp.getName());
        pst.setString(2, emp.getEmail());
        pst.setInt(2, emp.getSalary());
        pst.setInt(2, emp.getId());

        int result = pst.executeUpdate();

        con.close();

        return result > 0;
    }

    public boolean deleteEmployee(int id) throws SQLException,ClassNotFoundException{

        Connection con = Dbconnection.getConnection();

        PreparedStatement pst = con.prepareStatement("delete from employee where id = ?");

        pst.setInt(1,id);

        int result = pst.executeUpdate();

        con.close();

        return result > 0;
    }
}
