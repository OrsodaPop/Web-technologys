package com.it;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.it.pojo.Emp;
import com.it.service.EmpService;
import com.it.service.impl.EmpServiceImpl;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTest {
    @Test
    public void test_01(){
        DruidDataSource dataSource = new DruidDataSource();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/itzhan";
        String user = "root";
        String password = "1234";
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(map );
    }
    private EmpService empService = new EmpServiceImpl();
    @Test
    public void test_02() throws SQLException {

    }
}
