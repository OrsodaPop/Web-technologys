package com.it.dao.Impl;

import com.it.dao.EmpDao;
import com.it.pojo.Emp;
import com.it.utils.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private JdbcUtils jdbcUtils = new JdbcUtils();
    private DataSource dataSource = JdbcUtils.createDruidDataSource();
    @Override
    public List<Emp> queryById(Integer id) throws SQLException {
        String sql = "select * from lrt_emp where id = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        List<Emp> empList = jdbcUtils.getEmpDataByQuery(rs);
        return empList;
    }

    @Override
    public List<Emp> queryAllEmp(boolean b) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql;
        if(b){
            sql = "select * from lrt_emp order by id desc ";
        }else {
            sql = "select * from lrt_emp order by id asc ";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Emp> empList = jdbcUtils.getEmpDataByQuery(rs);
        return empList;
    }

    @Override
    public List<Emp> queryByName(String name) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "select * from lrt_emp where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet rs = statement.executeQuery();
        List<Emp> empByName = jdbcUtils.getEmpDataByQuery(rs);
        return empByName;
    }

    @Override
    public List<Emp> queryByEducation(String education,boolean b) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql;
        if(b){
            sql = "select * from lrt_emp where education = ? order by id asc ";
        }else {
            sql = "select * from lrt_emp where education = ? order by id desc ";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,education);
        ResultSet resultSet = statement.executeQuery();
        List<Emp> empDataByEducation = jdbcUtils.getEmpDataByQuery(resultSet);
        return empDataByEducation;
    }

    @Override
    public List<Emp> queryByJob(String job,boolean b) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql;
        if(b){
            sql = "select * from lrt_emp where job = ? order by id asc ";
        }else {
            sql = "select * from lrt_emp where job = ? order by id desc ";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,job);
        ResultSet resultSet = statement.executeQuery();
        List<Emp> empDataByJob = jdbcUtils.getEmpDataByQuery(resultSet);
        return empDataByJob;
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "delete from lrt_emp where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.execute();
    }

    @Override
    public void updateDataById(Emp emp) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "update lrt_emp set name = ?,gender = ?,birthday = ?,education = ?,job = ?,phoneNumber = ?,address = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,emp.getName());
        statement.setString(2,emp.getGender());
        statement.setDate(3, emp.getBirthday());
        statement.setString(4,emp.getEducation());
        statement.setString(5,emp.getJob());
        statement.setString(6,emp.getPhoneNumber());
        statement.setString(7,emp.getAddress());
        statement.setInt(8,emp.getId());
        statement.execute();
    }

    @Override
    public void insertEmp(Emp emp) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "insert into lrt_emp (name,gender,birthday,education,job,phoneNumber,address) values (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,emp.getName());
        statement.setString(2,emp.getGender());
        statement.setDate(3, emp.getBirthday());
        statement.setString(4,emp.getEducation());
        statement.setString(5,emp.getJob());
        statement.setString(6,emp.getPhoneNumber());
        statement.setString(7,emp.getAddress());
        statement.execute();
    }

    @Override
    public List<Emp> queryAllEmpByDate(Boolean dataIs) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql;
        if(dataIs){
            sql = "select * from lrt_emp order by birthday asc ";
        }else {
            sql = "select * from lrt_emp order by birthday desc ";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Emp> empList = jdbcUtils.getEmpDataByQuery(rs);
        return empList;
    }

    @Override
    public List<Emp> queryEmpByEducationD(String education, boolean dataIs) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql;
        if(dataIs){
            sql = "select * from lrt_emp where education = ? order by birthday asc ";
        }else {
            sql = "select * from lrt_emp where education = ? order by birthday desc ";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,education);
        ResultSet rs = statement.executeQuery();
        List<Emp> empList = jdbcUtils.getEmpDataByQuery(rs);
        return empList;
    }

    @Override
    public List<Emp> queryByJobD(String job, boolean dataIs) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql;
        if(dataIs){
            sql = "select * from lrt_emp where job = ? order by birthday asc ";
        }else {
            sql = "select * from lrt_emp where job = ? order by birthday desc ";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,job);
        ResultSet rs = statement.executeQuery();
        List<Emp> empList = jdbcUtils.getEmpDataByQuery(rs);
        return empList;
    }
}
