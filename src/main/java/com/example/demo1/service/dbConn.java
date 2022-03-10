package com.example.demo1.service;

import com.huawei.shade.com.alibaba.fastjson.JSONArray;
import com.huawei.shade.com.alibaba.fastjson.JSONObject;

import java.sql.*;

/*
    数据库相关操作
 */
public class dbConn {

    private final String dbDrive = "org.opengauss.Driver";
    private final String dbUrl = "jdbc:opengauss://121.36.60.12:5432/remote_db";
    private final String dbUserName = "remote_user";
    private final String dbPassword = "huawei+123";
    public JSONArray queryResultReturned= new JSONArray();
    public Connection dbConnection = null;

    //通过构造方法加载数据库驱动
    public dbConn() {
        try {
            Class.forName(dbDrive);
            System.out.println("jdbc加载成功");
        } catch (ClassNotFoundException notfound) {
            notfound.printStackTrace();
        }
    }

    //创建数据库连接
    public void createConnection() {
        try {
            /* 创建数据库连接对象 */
            dbConnection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("数据库连接成功");
//            conn.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    //关闭数据库连接
    public void closeConnection() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改数据
    public int insertToDB(String SQLCmd) throws SQLException {
        try {
            Statement statement = dbConnection.createStatement(); // Statement对象
            int rows; // 影响行数
            ResultSet rs; // 结果集合
            System.out.println(SQLCmd);
            rows = statement.executeUpdate(SQLCmd);

            System.out.println("插入影响行数为：" + rows);
            return 0;
        } catch (SQLException e) {
            return 1;
        }

    }


    public String QueryDB(String SQLCmd, int kind) throws SQLException {
        //kind 0 books 1 papers 2 records
        Statement statement = dbConnection.createStatement(); // Statement对象
        ResultSet rs; // 结果集合
        System.out.println(SQLCmd);
        rs = statement.executeQuery(SQLCmd);
        Statement statement1 = dbConnection.createStatement();
        ResultSet rs1;
        rs1 = statement1.executeQuery(SQLCmd);
        String result = "";
        System.out.println("查询结果为：");
        if (kind == 0) {
            while (rs.next()) {
                String s = rs.getString("book_id") + "-" + rs.getString("book_name") + "-"
                        + rs.getString("author") + "-" + rs.getString("collection_number") + "-"
                        + rs.getString("existing_number") + "-" + rs.getString("price") + "-"
                        + rs.getString("publisher") + "-" + rs.getString("introduction")
                        + rs.getString("shelf") + "-"+ rs.getString("type");
                s = s.replace(" ", "");
                s = s.replace("-", ",");
                System.out.println(s);
                result = result + s + ";"+"\n";
                s = s+";";
            }
        }
//        ● 文献id objectID
//        ● 文献类别(0:图书,1:论文) kind
//        ● 插入还是删除 IOD (0:插入/1:删除)
//        ● 论文(名字,作者,时间,期刊会议名称,期号，卷号，页号，DOI)  分割号是逗号------合并成一个字符串 introduction
        else if(kind == 1){
            while (rs.next()) {
                String s = rs.getString("paper_id") + "-" + rs.getString("paper_title") + "-"
                        + rs.getString("author") + "-" + rs.getString("date") + "-"
                        + rs.getString("jc_name") + "-" + rs.getString("issue_number") + "-"
                        + rs.getString("volume_number") + "-" + rs.getString("page_number") + "-"
                        + rs.getString("doi");
                s = s.replace(" ", "");
                s = s.replace("-", ",");
                result = result + s + ";"+"\n";
                s = s+";";
                System.out.println(s);
            }
        }


        JSONArray queryResult = new JSONArray();
        System.out.println("Operation type is "+kind);
        if (kind == 0) {
            while (rs1.next()) {
                JSONObject temp = new JSONObject();
                temp.put("book_id", rs1.getString("book_id").trim() );
                temp.put("book_name",rs1.getString("book_name").trim());
                temp.put("author",rs1.getString("author").trim());
                temp.put("collection_number",rs1.getString("collection_number").trim());
                temp.put("existing_number",rs1.getString("existing_number").trim());
                temp.put("price",rs1.getString("price").trim());
                temp.put("publisher",rs1.getString("publisher").trim());
                temp.put("introduction",rs1.getString("introduction").trim());
                temp.put("shelf",rs1.getString("shelf").trim());
                temp.put("type",rs1.getString("type").trim());
                queryResult.add(temp);
            }
        }
        else if(kind == 1){
//        ● 文献id objectID
//        ● 文献类别(0:图书,1:论文) kind
//        ● 插入还是删除 IOD (0:插入/1:删除)
//        ● 论文(名字,作者,时间,期刊会议名称,期号，卷号，页号，DOI)  分割号是逗号------合并成一个字符串 introduction
        while (rs1.next()) {
            JSONObject temp = new JSONObject();
            temp.put("paper_id", rs1.getString("paper_id").trim() );
            temp.put("paper_title",rs1.getString("paper_title").trim());
            temp.put("author",rs1.getString("author").trim());
            temp.put("date",rs1.getString("date").trim());
            temp.put("jc_name",rs1.getString("jc_name").trim());
            temp.put("issue_number", rs1.getString("issue_number").trim());
            temp.put("volume_number",rs1.getString("volume_number").trim());
            temp.put("page_number",rs1.getString("page_number").trim());
            temp.put("doi",rs1.getString("doi").trim());
            queryResult.add(temp);
        }
    }
        else
        {
            while (rs1.next()) {
                JSONObject temp = new JSONObject();
                temp.put("user_id", rs1.getString("user_id").trim());
                temp.put("object_id", rs1.getString("object_id").trim());
                temp.put("number", rs1.getString("number").trim());
                temp.put("date", rs1.getDate("date"));
                temp.put("book_name", rs1.getString("book_name"));
                queryResult.add(temp);
            }

        }

        queryResultReturned = queryResult;
        return result;
    }

    public int UpdateDB(String SQLCmd) throws SQLException {
        try {
            Statement statement = dbConnection.createStatement(); // Statement对象
            int rows;
            rows = statement.executeUpdate(SQLCmd);
            System.out.println("更新影响行数为：" + rows);
            return 0;
        } catch (SQLException e) {
            return 1;
        }
    }

    public int deleteFromDB(String SQLCmd) throws SQLException {
        try {
            Statement statement = dbConnection.createStatement(); // Statement对象
            int rows;
            SQLCmd="DELETE FROM books WHERE book_id = '9';";
            System.out.println(SQLCmd);
            rows = statement.executeUpdate(SQLCmd);
            System.out.println("删除影响行数为：" + rows);
            return 0;
        } catch (SQLException e) {
            return 1;
        }
    }

    public int LoginDB(String SQLCmd, String pwd) throws SQLException {
        Statement statement = dbConnection.createStatement(); // Statement对象
        ResultSet rs; // 结果集合
        int result = 2;
        rs = statement.executeQuery(SQLCmd);
        while (rs.next()) {
            String id = rs.getString("user_name");
            id = id.trim();
            String pwd_query = rs.getString("user_password");
            pwd_query = pwd_query.trim();
            String if_admin = rs.getString("identify");
            System.out.println("登录请求,输入的密码为 " + pwd);
            System.out.println("查询到的信息：id = " + id + " pwd =" + pwd_query + " if_admin= " + if_admin);
            if (pwd.equals(pwd_query)) {
                if (if_admin.equals("0")) {
                    return 0;
                } else {
                    return 1;
                }
            } else return 2;
        }
        return 4;
    }
}