package com.admin.adminsystem.controller;


import com.admin.adminsystem.entity.SystemuserEntity;
import com.admin.adminsystem.jpa.SystemuserJPA;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class System_userController {

    @Autowired
    private SystemuserJPA systemuserJPA;



    @RequestMapping(value = "/api/system/select-all", method = GET)
    public JSONObject alllist(){
        // Define the JsonObject type variable, which is then returned
        List<SystemuserEntity> systemuserEntities = new ArrayList<>();
        try {
            systemuserEntities= systemuserJPA.findAll();
        }
        catch (Exception e){
            JSONObject list=new JSONObject();
            // If the query fail, custom code 400,Exception message, and data are returned
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // If the query success, custom code 200, message, and data are returned
        JSONObject list=new JSONObject();
        list.put("code", 200);
        list.put("message","ok");
        list.put("data",systemuserEntities);

        return list;
    }

    /**
     * Select page amount json object.
     *
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/system/selectpageamount", method = GET)
    public JSONObject selectPageAmount(){
        // Define the JsonObject type variable, which is then returned
        JSONObject json = new JSONObject();
        Page<SystemuserEntity> system;

        try {
            system = systemuserJPA.findAll(new PageRequest(0, 10));
        } catch (Exception e){
            // If the query fail, custom code 400, message, and data are returned
            json.put("code", 400);
            json.put("message",e.toString());
            json.put("data","");
            return json;
        }
        // If the query success, custom code 200, message, and data are returned
        json.put("code", 200);
        json.put("message","ok");
        json.put("data",system.getTotalElements());
        return json;
    }

    /**
     * List by condition json object.
     *
     * @param request the request
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/system/selectbycondition", method = GET)
    public JSONObject listByCondition(HttpServletRequest request) {
        JSONObject list=new JSONObject();
        // Get the request parameter key
        String key = request.getParameter("key");

        List<SystemuserEntity> system;
        try {
            // If the key is empty, all are queried
            if (key.equals("") || key == null){
                system = systemuserJPA.findAll();
            } else {
                // If it is not empty, query by condition
                system = systemuserJPA.findSystemByCondition(key);
            }
        } catch (Exception e){
            // If select success ,return custom status 400 and Exeption messages
            list.put("code","400");
            list.put("message",e.getMessage().toString());
            list.put("data","");
            return list;
        }
        // If select success ,return custom status 200、message and date
        list.put("code","200");
        list.put("message","ok");
        list.put("data",system);//.getContent()
        return list;
    }
}
