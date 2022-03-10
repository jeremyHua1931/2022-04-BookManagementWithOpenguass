package com.example.demo1.controller;

import com.huawei.shade.com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo1.model.users;
import com.example.demo1.service.*;

import java.sql.SQLException;

@Controller
public class registerController {
    parseToSQL temp = new parseToSQL();

    public registerController() throws SQLException {
    }

    @RequestMapping(path="/register",method = RequestMethod.GET)
    public String register_html(){

        return "forward:register.html";
    }



    @RequestMapping(path = "/register",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(@RequestBody(required=false) JSONObject user) throws SQLException {
        System.out.println("++++++++++++++++++++++"+user);
//        System.out.println(user.getUser_name());
        JSONObject json = new JSONObject();


        json.put("id","-2");
        json.put("user_id",user.getString("user_name"));
        json.put("pwd",user.getString("user_password"));
        json.put("stuID",user.getString("stuID"));
        System.out.println("0000000000000000         "+json);


        String ret = temp.parse(json);
        JSONObject result = new JSONObject();
        if(ret.equals("0")) {
            result.put("msg","0");
        }else{
            result.put("msg","1");
        }
        System.out.println(result);
        return result;
    }
}



