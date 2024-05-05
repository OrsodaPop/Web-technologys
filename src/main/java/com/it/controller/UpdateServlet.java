package com.it.controller;

import com.it.pojo.Emp;
import com.it.service.EmpService;
import com.it.service.impl.EmpServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/update/*")
public class UpdateServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        empService.updateDate(Emp emp);
        try {
            String id = request.getParameter("id");
            System.out.println("id-------"+id);
            String name = request.getParameter("name");
            System.out.println("name-"+name);
            String gender = request.getParameter("gender");
            System.out.println("gender-"+gender);
            String birthday = request.getParameter("birthday");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(birthday);
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            String education = request.getParameter("education");
            System.out.println("education"+education);
            String job = request.getParameter("job");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            int i = Integer.parseInt(id)+1;
            Emp emp = new Emp(i,name,gender,date1,education,job,phoneNumber,address);
            empService.updateData(emp);
        /*try {
            empService.updateData(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
            System.out.println(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
