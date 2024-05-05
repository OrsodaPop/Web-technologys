package com.it.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.it.pojo.Emp;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcUtils {

    public JdbcUtils(){}
    public static DataSource createDruidDataSource() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/lrt";
        String user = "root";
        String password = "1234";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5); // 初始化连接数
        dataSource.setMaxActive(20);  // 最大连接数
        dataSource.setMinIdle(5);    // 最小空闲连接数
        dataSource.setMaxWait(30000);
        return dataSource;
    }
    public List<Emp> getEmpDataByQuery(ResultSet rs) throws SQLException {
        List<Emp> list = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            Date birthday = rs.getDate("birthday");
            String education = rs.getString("education");
            String job = rs.getString("job");
            String phoneNumber = rs.getString("phoneNumber");
            String address = rs.getString("address");
            Emp emp = new Emp(id, name, gender, birthday, education, job, phoneNumber, address);
            list.add(emp);
        }
        return list;
    }
}
