package com.example.demo1.controller;

import com.huawei.shade.com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo1.model.users;
import com.example.demo1.service.*;

import java.sql.SQLException;

@Controller
public class loginController {

    parseToSQL temp = new parseToSQL();

    public loginController() throws SQLException {
    }

    @RequestMapping(path="/login",method = RequestMethod.GET)
    public String login_html(){

        return "forward:login.html";
    }

    //接收login_test页面的字符数组
//    @RequestMapping(path = "/login",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
//    @ResponseBody
//    public Object Receive(@RequestBody users user){  //Employee可以改为Object
////
////        System.out.println(user.getUser_name()+"\n"+user.getUser_password()+user.getIdentify()+user.getEmail());
//
//        System.out.println(user.getUser_name());
//        if(user.getUser_name().equals("jeremy")) {
//            return "{\"msg\":\"添加成功,恭喜你\"}";
//        }else
//        {
//            return "{\"msg\":\"添加失败,加油,再试一试\"}";
//        }
//
//    }
    public  static   String USERID1;

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody(required=false) users user) throws SQLException {
        System.out.println(user);
        System.out.println(user.getUser_name());
        JSONObject json = new JSONObject();

        USERID1=user.getUser_name();
        System.out.println("当前登录用户id========================>"+user.getUser_name());



        json.put("id","-1");
        json.put("user_id",user.getUser_name());
        json.put("pwd",user.getUser_password());

        String ret = temp.parse(json);
        JSONObject result = new JSONObject();
        result.put("msg",ret);
        System.out.println(result);
        return result;

    }
}



