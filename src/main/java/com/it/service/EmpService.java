package com.it.service;

import com.it.pojo.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {
    List<Emp> getEmpById(Integer id) throws SQLException;


    List<Emp> getAllEmp(boolean b) throws SQLException;

    List<Emp> getEmpByName(String name) throws SQLException;

    List<Emp> getEmpByEducation(String education,boolean b) throws SQLException;

    List<Emp> getEmpByJob(String job,boolean b) throws SQLException;

    void deleteEmpById(Integer id) throws SQLException;

    void updateData(Emp emp) throws SQLException;

    void insertEmp(Emp emp) throws SQLException;

    List<Emp> getAllEmpByDate(boolean dataIs) throws SQLException;

    List<Emp> getEmpByEducationDate(String education, boolean dataIs) throws SQLException;

    List<Emp> getEmpByJobDate(String job, boolean dataIs) throws SQLException;
}
