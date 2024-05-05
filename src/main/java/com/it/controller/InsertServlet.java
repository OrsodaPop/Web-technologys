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

@WebServlet("/insert/*")
public class InsertServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            System.out.println(birthday);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(birthday);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            System.out.println(date1);
            String education = request.getParameter("education");
            String job = request.getParameter("job");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            Emp emp = new Emp(null, name, gender, date1, education, job, phoneNumber, address);
        try {
            empService.insertEmp(emp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
