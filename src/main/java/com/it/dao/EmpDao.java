package com.it.dao;

import com.it.pojo.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
    List<Emp> queryById(Integer id) throws SQLException;

    List<Emp> queryAllEmp(boolean b) throws SQLException;

    List<Emp> queryByName(String name) throws SQLException;

    List<Emp> queryByEducation(String education ,boolean b) throws SQLException;

    List<Emp> queryByJob(String job,boolean b) throws SQLException;

    void deleteById(Integer id) throws SQLException;

    void updateDataById(Emp emp) throws SQLException;


    void insertEmp(Emp emp) throws SQLException;

    List<Emp> queryAllEmpByDate(Boolean dataIs) throws SQLException;

    List<Emp> queryEmpByEducationD(String education, boolean dataIs) throws SQLException;

    List<Emp> queryByJobD(String job, boolean dataIs) throws SQLException;
}
