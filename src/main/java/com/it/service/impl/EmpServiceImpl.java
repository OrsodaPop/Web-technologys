package com.it.service.impl;

import com.it.dao.EmpDao;
import com.it.dao.Impl.EmpDaoImpl;
import com.it.pojo.Emp;
import com.it.service.EmpService;

import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();


    @Override
    public List<Emp> getEmpById(Integer id) throws SQLException {
        List<Emp> list = empDao.queryById(id);
        return list;
    }

    @Override
    public List<Emp> getAllEmp(boolean b) throws SQLException {
        List<Emp> list = empDao.queryAllEmp(b);
        return list;
    }

    @Override
    public List<Emp> getEmpByName(String name) throws SQLException {
        List<Emp> list = empDao.queryByName(name);
        return list;
    }

    @Override
    public List<Emp> getEmpByEducation(String education,boolean b) throws SQLException {
        List<Emp> empList = empDao.queryByEducation(education,b);
        return empList;
    }

    @Override
    public List<Emp> getEmpByJob(String job,boolean b) throws SQLException {
        List<Emp> list = empDao.queryByJob(job,b);
        return list;
    }

    @Override
    public void deleteEmpById(Integer id) throws SQLException {
        empDao.deleteById(id);
    }

    @Override
    public void updateData(Emp emp) throws SQLException {
        empDao.updateDataById(emp);
    }

    @Override
    public void insertEmp(Emp emp) throws SQLException {
        empDao.insertEmp(emp);
    }

    @Override
    public List<Emp> getAllEmpByDate(boolean dataIs) throws SQLException {
        List<Emp> empList = empDao.queryAllEmpByDate(dataIs);
        return empList;
    }

    @Override
    public List<Emp> getEmpByEducationDate(String education, boolean dataIs) throws SQLException {
        List<Emp> empList = empDao.queryEmpByEducationD(education,dataIs);
        return empList;
    }

    @Override
    public List<Emp> getEmpByJobDate(String job, boolean dataIs) throws SQLException {
        List<Emp> empList = empDao.queryByJobD(job,dataIs);
        return empList;
    }
}
