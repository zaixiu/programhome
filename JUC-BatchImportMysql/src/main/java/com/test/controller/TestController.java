package com.test.controller;


import com.test.entity.GeneralTable;
import com.test.entity.User;
import com.test.service.BatchOperateMysqlInf;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class TestController {

    @Value("${server.port}")
    public String port;

    @Resource
    User user;
    @Resource
    UserService service;

    @Resource
    BatchOperateMysqlInf batchOperateMysqlInf;




    @RequestMapping("/test")
    public String test() throws SQLException {

        return port ;
    }


    @RequestMapping("/getmysql")
    public List<User> getmysql()
    {

        List<User> user = service.getUser();
        return user;
    }


    @RequestMapping("/insert")
    public Boolean insert() {
        GeneralTable gt = new GeneralTable();
        Random rand = new Random();
        List<GeneralTable> list = new ArrayList<GeneralTable>();
        for (int i = 0; i < 1000000; i++) {
            gt.setColAttr("列属性" + rand.nextInt(9) * 1000);
            gt.setColFrom("表属性" + rand.nextInt(9) * 1000);
            gt.setColValue("列值" + rand.nextInt(9) * 1000);
            gt.setColType("列类型" + rand.nextInt(9) * 1000);
            gt.setRowKey((long) rand.nextInt(1000));
            list.add(gt);
        }
        boolean a = batchOperateMysqlInf.insert(list);
        return a;
    }



}
