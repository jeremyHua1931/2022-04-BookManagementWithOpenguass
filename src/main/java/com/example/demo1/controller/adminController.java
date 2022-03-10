package com.example.demo1.controller;

import com.example.demo1.service.parseToSQL;
import com.huawei.shade.com.alibaba.fastjson.JSONArray;
import com.huawei.shade.com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class adminController {


    //查询所有文献(图书或者论文)
    @RequestMapping(path = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray queryAll(@RequestBody(required = false) JSONObject json_search) throws SQLException {

        JSONArray jsonArray = new JSONArray();


        System.out.print("---------------="+json_search);
        JSONObject tempJSON = new JSONObject();
        tempJSON.put("kind", json_search.getString("KIND"));
        System.out.println("11111111111111111111111"+json_search.getString("KIND"));
        tempJSON.put("id", "0");

        parseToSQL temp = new parseToSQL();
        jsonArray = temp.parse0(tempJSON);
        System.out.println("全部查询"+jsonArray);

        return jsonArray;

    }


    @RequestMapping(path = "/queryRecords", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray queryRecords(@RequestBody(required = false) String str) throws SQLException {

        parseToSQL temp = new parseToSQL();
        //test
//        String json1 = "{\"id\":1,\"userID\":\"11\",\"objectID\":\"1212\",\"number\":\"+10\"}"; //测试用户借还操作
//        JSONObject jsonObj1 =  JSON.parseObject(json1);
//        temp.parse(jsonObj1);
        //test

        JSONArray jsonArray = new JSONArray();
        JSONObject tempJSON = new JSONObject();

        long id = Long.parseLong(parseToSQL.user_id);
        tempJSON.put("id", "5");
        if (id == 0) tempJSON.put("kind", "0");
        else tempJSON.put("kind", "1");
        jsonArray = temp.parse5(tempJSON);
        System.out.println(jsonArray);

        return jsonArray;

    }


//    @RequestMapping(path = "/br", method = RequestMethod.POST) //borrow and return
//    @ResponseBody
//    public String br(@RequestBody(required = false) JSONObject jsonObject) throws SQLException {
//
//        parseToSQL temp = new parseToSQL();
//        String jsonArray = temp.parse(jsonObject);
//        System.out.println(jsonArray);
//
//        return jsonArray;
//
//    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST) //borrow and return
    @ResponseBody
    public String delete(@RequestBody(required = false) JSONObject jsonObject) throws SQLException {
//● 操作id "id:3"
//● 文献id objectID
//● 文献类别(0:图书,1:论文) kind
//● 插入还是删除 IOD (0:插入/1:删除)
//● 文献的介绍 1.图书('id',''名字','作者','数量','数量','价格','出版社','介绍')  2-论文('id','名字','作者','时间','期刊会议名称','期号','卷号','页号','DOI')  分割号是逗号------合并成一个字符串 introduction 删除此项留空即可
        String book_id = jsonObject.getString("bookID");
        String[] temp = book_id.split(",");
        for (String temp1 : temp) {
            parseToSQL temp2 = new parseToSQL();
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("id", "3");
            jsonObject1.put("objectID", temp1);
            jsonObject1.put("IOD", 1);
            jsonObject1.put("kind", jsonObject.getString("kind"));
            System.out.println("11111111111111"+jsonObject.getString("kind"));
            temp2.parse(jsonObject1);
        }

        return "0";

    }


    @RequestMapping(path = "/modify", method = RequestMethod.POST) //borrow and return
    @ResponseBody
    public String modify(@RequestBody(required = false) JSONObject jsonObject) throws SQLException {
//● 操作id "id:3"
//● 文献id objectID
//● 文献类别(0:图书,1:论文) kind
//● 插入还是删除 IOD (0:插入/1:删除)
//● 文献的介绍 1.图书('id',''名字','作者','数量','数量','价格','出版社','介绍')  2-论文('id','名字','作者','时间','期刊会议名称','期号','卷号','页号','DOI')  分割号是逗号------合并成一个字符串 introduction 删除此项留空即可
//        let obj12={};
//        obj12.id          =4          ;
//        obj12.objectID          =book_id          ;
//        obj12.kind             = 0;
//        obj12.book_name        =book_name        ;
//        obj12.author           =author           ;
//        obj12.collection_number=collection_number;
//        obj12.existing_number  =existing_number  ;
//        obj12.price            =price            ;
//        obj12.publisher        =publisher        ;
//        obj12.introduction     =introduction     ;
//        ● 操作id "id:4"
//● 文献id objectID
//● 文献类别(0:图书,1:论文) kind
//● 文献的介绍 1.图书('id',''名字','作者','数量','数量','价格','出版社','介绍')  2-论文('id','名字','作者','时间','期刊会议名称','期号','卷号','页号','DOI')  分割号是逗号------合并成一个字符串 introduction 删除此项留空即可
        System.out.println("打印======================="+jsonObject);
        String book_id = jsonObject.getString("objectID");
        parseToSQL temp2 = new parseToSQL();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id", "4");
        jsonObject1.put("objectID", jsonObject.getString("objectID"));
        jsonObject1.put("kind", jsonObject.getString("kind"));
        System.out.println("===================================================="+jsonObject.getString("kind"));
        String intro = "";
        if(jsonObject.getString("kind").equals("0")){
            intro = "'"+jsonObject.getString("objectID")+
                    "','"+jsonObject.getString("book_name")+"','"+
                    jsonObject.getString("author")+"','"+
            jsonObject.getString("shelf") +"','"+
                    jsonObject.getString("type")+"','"+jsonObject.getString("collection_number")+
                "','"+
                    jsonObject.getString("collection_number")+"','"+
                    jsonObject.getString("price")+"','"+
                    jsonObject.getString("publisher")+"','"+
                    jsonObject.getString("introduction")
                    +"'";
            System.out.println("=+======="+intro);
        }else if(jsonObject.getString("kind").equals("1")){
            intro = "'"+jsonObject.getString("objectID")+
                    "','"+jsonObject.getString("paper_title")+"','"+
                    jsonObject.getString("author")+"','"+jsonObject.getString("date")+
                    "','"+
                    jsonObject.getString("jc_name")+"','"+jsonObject.getString("issue_number")+"','"+
                    jsonObject.getString("volume_number")+"','"+
                    jsonObject.getString("page_number")+"','"+
                    jsonObject.getString("doi")+"'";
            System.out.println("=+++++++++++++++++++++++++"+intro);
        }

        jsonObject1.put("introduction", intro);
        System.out.println(jsonObject1);
        temp2.parse(jsonObject1);


        return "0";

    }
}
