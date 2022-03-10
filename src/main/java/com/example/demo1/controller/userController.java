package com.example.demo1.controller;


import com.huawei.shade.com.alibaba.fastjson.JSONArray;
import com.huawei.shade.com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo1.service.*;
import java.sql.SQLException;

@Controller
public class userController {



//    @RequestMapping(path = "/user",method = RequestMethod.POST)
//    @ResponseBody
//    public JSONArray queryDB(@RequestBody(required=false) JSONObject json_search) throws SQLException {
//
//        JSONArray jsonArray = new JSONArray();
//        System.out.println("当前登录用户id========================>"+loginController.USERID1);
//        System.out.println(json_search);
////        parseToSQL temp = new parseToSQL();
////        jsonArray = temp.parse0(json_search);  //查阅所有书籍
////        System.out.println(jsonArray);
//
//        JSONObject json1=new JSONObject();
//        json1.put("book_id","222");
//        json1.put("book_name","333");
//        json1.put("author","4444");
//        json1.put("collection_number","5555");
//        json1.put("existing_number","6666");
//        json1.put("price","5555");
//        json1.put("publisher","66666");
//        json1.put("introduction","77777");
//        jsonArray.add(json1);
//
//        JSONObject json2=new JSONObject();
//        json2.put("book_id","0000222");
//        json2.put("book_name","0000333");
//        json2.put("author","00004444");
//        json2.put("collection_number","00005555");
//        json2.put("existing_number","00006666");
//        json2.put("price","0005555");
//        json2.put("publisher","00066666");
//        json2.put("introduction","0077777");
//
//        jsonArray.add(json2);
//
//        return jsonArray;
//
//    }

    @RequestMapping(path = "/userOp",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject userOp(@RequestBody(required=false) JSONObject jsonObject) throws SQLException {
        parseToSQL temp = new parseToSQL();
        String ret = temp.parse(jsonObject);
        JSONObject result = new JSONObject();
        System.out.println("444444444444444444444           "+ret);
        if(ret.length()>=2) {
            result.put("msg","0");
        }else{
            result.put("msg","1");
        }
        return result;
    }
}
