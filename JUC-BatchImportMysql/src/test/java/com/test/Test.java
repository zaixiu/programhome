package com.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@TestConfiguration
public class Test {

    @Autowired
    DataSource dataSource;


    @Value("${server.port}")
    public String port;

    @org.junit.Test
    public void test() throws SQLException {
        //Connection connection = dataSource.getConnection();
        //System.out.println(connection);
        System.out.println(port);
    }
}
