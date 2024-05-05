package com.it.controller;

import com.it.service.EmpService;
import com.it.service.impl.EmpServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete/*")
public class DeleteServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);
        try {
            empService.deleteEmpById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id);
    }
}
