package com.admin.adminsystem.controller;

import com.admin.adminsystem.entity.Service2Entity;
import com.admin.adminsystem.entity.ServiceEntity;
import com.admin.adminsystem.jpa.Service2JPA;
import com.admin.adminsystem.jpa.ServiceJPA;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * The type Service controller.
 */
@RestController
public class ServiceController {

    @Autowired
    private ServiceJPA service;
    @Autowired
    private Service2JPA service2;

    /**
     * Selectall json object.
     *
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "api/service/select-all")
    public JSONObject selectall(){//@RequestBody String info)

        List<Service2Entity> servicelist;
        JSONObject list=new JSONObject();

        try {
            servicelist = service2.findAll();//new PageRequest(Integer.valueOf(number.toString()),10)
        }catch(Exception e){
            // Returns custom status 400, response information, and return data in json format
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // Returns custom status 200, response information, and return data in json format
        list.put("code", 200);
        list.put("message","");
        list.put("data",servicelist);//.getContent()
        return list;
    }

    /**
     * Insert info json object.
     *
     * @param info the info
     * @return the json object
     */
    @RequestMapping(value = "api/service/add" , method = POST)
    public JSONObject insertInfo(@RequestBody String info){
        JSONObject list=new JSONObject();

        // Use ServiceEntity as the carrier
        ServiceEntity ser = JSON.parseObject(info,ServiceEntity.class);

        // get the current time ,format is yy-MM-dd hh:MM:ss
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd hh:MM:ss");
        Date date = new Date();ParsePosition pos = new ParsePosition(0);
        Date nowTime = dateFormat.parse(dateFormat.format(date), pos);

        ser.setLAST_UPDATE_TIMESTAMP(nowTime);

        try {
            // Add a data into Service table
            service.save(ser);
        }catch(Exception e){
            // Returns custom status 400, response information, and return data in json format
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // Returns custom status 200, response information, and return data in json format
        list.put("code", 200);
        list.put("message","添加成功");
        list.put("data","");
        return list;
    }

    /**
     * Update info json object.
     *
     * @param info the info
     * @return the json object
     */
    @RequestMapping(value = "api/service/update" ,method = POST)
    public JSONObject updateInfo(@RequestBody String info){
        JSONObject list=new JSONObject();

        ServiceEntity ser = JSON.parseObject(info,ServiceEntity.class);

        // get the current time, format is yyyy-MM-dd hh:MM:ss
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        Date date = new Date();
        String nowTime = dateFormat.format(date);

        ser.setINSERT_TIMESTAMP(service.findOne(ser.getPK_SERVICE()).getINSERT_TIMESTAMP());
        ser.setLAST_UPDATE_TIMESTAMP(Timestamp.valueOf(nowTime));

        try {
            // Modify this data by id
            service.saveAndFlush(ser);
        }catch(Exception e){
            // If the query fail, custom code 400,Exception message, and data are returned
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // If the query success, custom code 200,Exception message, and data are returned
        list.put("code", 200);
        list.put("message","修改成功");
        list.put("data","");
        return list;
    }

    /**
     * Delete info json object.
     *
     * @param info the info
     * @return the json object
     */
    @RequestMapping(value = "api/service/delete", method = DELETE)
    public JSONObject deleteInfo(@RequestBody String info){
        JSONObject list=new JSONObject();
        // Get the request parameter pk_SERVICE
        Object id = JSON.parseObject(info).get("pk_SERVICE");

        try {
            // Delete this data through pk_SERVICE
            service.delete(id.toString());
        }catch(Exception e){
            // If the query fail, custom code 400,Exception message, and data are returned
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // If the query success, custom code 200, message, and data are returned
        list.put("code", 200);
        list.put("message","删除成功");
        list.put("data","");
        return list;
    }

    /**
     * Select service page amount json object.
     *
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/service/selectpageamount", method = GET)
    public JSONObject selectServicePageAmount(){
        JSONObject json = new JSONObject();
        Page<ServiceEntity> routes;

        try {
            routes = service.findAll(new PageRequest(0, 10));
        } catch (Exception e){
            // If select success ,return custom status 400 and Exeption messages
            json.put("code", 400);
            json.put("message",e.toString());
            json.put("data","");
            return json;
        }
        // If select success ,return custom status 200 、message and data
        json.put("code", 200);
        json.put("message","ok");
        json.put("data",routes.getTotalElements());
        return json;
    }

    /**
     * List by condition json object.
     *
     * @param request the request
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/service/selectservicebycondition", method = GET)
    public JSONObject listByCondition(HttpServletRequest request) {
        JSONObject list=new JSONObject();
        // Get the request parameter key
        String key = request.getParameter("key");

        List<ServiceEntity> routes;
        try {
            // If the key is empty, all are queried
            if (key.equals("") || key == null){
                routes = service.findAll();
            } else {
                // If it is not empty, query by condition
                routes = service.findServiceByCondition(key);
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
        list.put("data",routes);//.getContent()
        return list;
    }
}
