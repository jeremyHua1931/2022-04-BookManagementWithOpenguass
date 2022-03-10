package com.example.demo1;

import com.example.demo1.service.dbConn;

/*
测试数据库是否导通，右键点击文件即可单独测试
 */
public class test {
    public static void main(String[] args) {
        dbConn test = new dbConn();
        test.createConnection();
        test.closeConnection();
    }
}