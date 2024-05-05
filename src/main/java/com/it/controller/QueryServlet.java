package com.it.controller;

import com.alibaba.fastjson.JSON;
import com.it.pojo.Emp;
import com.it.service.EmpService;
import com.it.service.impl.EmpServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/query/*")
public class QueryServlet extends HttpServlet {
//    private EmpDao empDao = new EmpDaoImpl();
    private EmpService empService = new EmpServiceImpl();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Emp emp = new Emp(1,"张三",17);
        String empJSON = JSON.toJSONString(emp);
        System.out.println(empJSON);
        response.getWriter().println(empJSON);*/
        PrintWriter writer = response.getWriter();
        /*try {
            Emp emp = empService.getEmpById(1);
            String empJson = JSON.toJSONString(emp);
            writer.println(empJson);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try {
            /*Map<String, String[]> parameterMap = request.getParameterMap();
            String isHaveParam = "";
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()){
                StringBuffer sb = new StringBuffer();
                String[] values = entry.getValue();
                for (int i = 0; i < values.length; i++) {
                    sb.append(values[i]);
                }
                String value = sb.toString();
                isHaveParam+=value;
                System.out.println("Key = " + entry.getKey() + ", Value = " +value);
            }*/
            String id = request.getParameter("id");
            System.out.println("id"+id);
            String name = request.getParameter("name");
            System.out.println("name"+name);
            String education = request.getParameter("education");
            String job = request.getParameter("job");
            String idIsTrue = request.getParameter("idIsTrue");
            System.out.println(idIsTrue);

            boolean idIs = "true".equals(idIsTrue)?true:false;
            String dateIsTrue = request.getParameter("dateIsTrue");
            System.out.println(dateIsTrue);
            boolean dataIs = "false".equals(dateIsTrue)?false:true;
            String onIs = request.getParameter("onIs");
            System.out.println(onIs);
            int oi = 1;
            if (onIs!=null){
               oi = Integer.parseInt(onIs);
            }
            if(id.length()!=0){
                int i = Integer.parseInt(id);
                List<Emp> emp = empService.getEmpById(i);
                String listJson = JSON.toJSONString(emp);
                writer.println(listJson);
            } else if (name.length()!=0) {
                List<Emp> emp = empService.getEmpByName(name);
                String listJson = JSON.toJSONString(emp);
                writer.println(listJson);
            } else if (education.length()!=0) {
                if(oi>0){
                    List<Emp> emp = empService.getEmpByEducation(education,idIs);
                    String listJson = JSON.toJSONString(emp);
                    writer.println(listJson);
                }else {
                    List<Emp> emp = empService.getEmpByEducationDate(education,dataIs);
                    String listJson = JSON.toJSONString(emp);
                    writer.println(listJson);
                }
            }
            else if (job.length()!=0) {
                if(oi>0){
                    List<Emp> emp = empService.getEmpByJob(job,idIs);
                    String listJson = JSON.toJSONString(emp);
                    writer.println(listJson);
                }else {
                    List<Emp> emp = empService.getEmpByJobDate(job,dataIs);
                    String listJson = JSON.toJSONString(emp);
                    writer.println(listJson);
                }
            }else {
                if(oi>0){
                        List<Emp> list = empService.getAllEmp(idIs);
                        String listJson = JSON.toJSONString(list);
                        writer.println(listJson);
                }else {
                        List<Emp> list = empService.getAllEmpByDate(dataIs);
                        String listJson = JSON.toJSONString(list);
                        writer.println(listJson);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
