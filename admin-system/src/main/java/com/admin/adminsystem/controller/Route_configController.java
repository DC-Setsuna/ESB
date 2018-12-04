package com.admin.adminsystem.controller;

import com.admin.adminsystem.entity.ReferenceEntity;
import com.admin.adminsystem.entity.RouteEntity;
import com.admin.adminsystem.entity.Route_configEntity;
import com.admin.adminsystem.jpa.ReferenceJPA;
import com.admin.adminsystem.jpa.RouteJPA;
import com.admin.adminsystem.jpa.Route_configJPA;
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
 * The type Route config controller.
 */
@RestController
public class Route_configController {

    @Autowired
    private Route_configJPA route_configJPA;
    @Autowired
    private RouteJPA routeJPA;
    @Autowired
    private ReferenceJPA referenceJPA;


    /**
     * Add json object.
     *
     * @param routeInfo the route info
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/route-config/add", method = POST)
    public JSONObject add(@RequestBody String routeInfo) {
        JSONObject list=new JSONObject();

        // Get the data in the request, using the entity class Route_configEntity as the carrier
        Route_configEntity route_configEntity = new Route_configEntity();
        route_configEntity = JSON.parseObject(routeInfo,Route_configEntity.class);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd hh:MM:ss");
        Date date = new Date();
        ParsePosition pos = new ParsePosition(0);
        // Get the current date， format yy-MM-dd hh:MM:ss
        Date nowTime = dateFormat.parse(dateFormat.format(date), pos);

        route_configEntity.setINSERT_TIMESTAMP(nowTime);
        route_configEntity.setLAST_UPDATE_TIMESTAMP(nowTime);

        try {
            // Add data to the Route_config database table
            route_configJPA.save(route_configEntity);
        }catch(Exception e){
            // // If add fail ,return custom status 400、message and Exeption messages
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // Encapsulated as JSONObject data and returned to the front end
        list.put("code", 200);
        list.put("message","添加成功");
        list.put("data","");
        return list;
    }

    /**
     * Delete json object.
     *
     * @param routeInfo the route info
     * @return the json object
     */
    @RequestMapping(value = "/api/route-config/delete", method = DELETE)
    public JSONObject delete(@RequestBody String routeInfo) {
        JSONObject list=new JSONObject();
        // Get the request parameter pk_ROUTE
        Object id = JSON.parseObject(routeInfo).get("pk_ROUTE");
        try {
            // Delete this data through pk_ROUTE
            route_configJPA.delete(id.toString());
        } catch(Exception e){
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
     * Update json object.
     *
     * @param route the route
     * @return the json object
     */
    @RequestMapping(value = "/api/route-config/update", method = POST)
    public JSONObject update(@RequestBody String route) {
        // Define the JsonObject type variable, which is then returned
        JSONObject list=new JSONObject();
        // Use Route_configEntity as the carrier
        Route_configEntity route_configEntity = JSON.parseObject(route,Route_configEntity.class);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        Date date = new Date();
        // Get the current time
        String nowTime = dateFormat.format(date);
//        ParsePosition pos = new ParsePosition(0);
//        Date nowTime = dateFormat.parse(dateFormat.format(date), pos);
//        route_configEntity.setLAST_UPDATE_TIMESTAMP(nowTime);

        route_configEntity.setINSERT_TIMESTAMP(route_configJPA.findOne(route_configEntity.getPK_ROUTE()).getINSERT_TIMESTAMP());
        route_configEntity.setLAST_UPDATE_TIMESTAMP(Timestamp.valueOf(nowTime));

        try {
            // Modify this data by id
            route_configJPA.saveAndFlush(route_configEntity);
        } catch(Exception e){
            // If the query fail, custom code 400,Exception message, and data are returned
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // If the query success, custom code 200, message, and data are returned
        list.put("code", 200);
        list.put("message","修改成功");
        list.put("data","");
        return list;
    }

    /**
     * List json object.
     *
     * @return the json object
     */
    @RequestMapping(value = "/api/route-config/select", method = GET)
    public JSONObject list() {//@RequestBody String info
        // Define the JsonObject type variable, which is then returned
        JSONObject list=new JSONObject();
        //Page<Route_configEntity> routes;
        // Object number = JSON.parseObject(info).get("nubmer");

        List<Route_configEntity> routes;
        try {
            // Query all unconditionally
            routes = route_configJPA.findAll();
        } catch (Exception e){
            // If the query fail, custom code 400,Exception message, and data are returned
            list.put("code", 400);
            list.put("message","ok");
            list.put("data","");
            return list;
        }
        // If the query success, custom code 200, message, and data are returned
        list.put("code", 200);
        list.put("message","ok");
        list.put("data",routes);//.getContent()
        return list;
    }


    /**
     * Alllist json object.
     *
     * @return the json object
     */
    @RequestMapping(value = "/api/route-config/select-all", method = GET)
    public JSONObject alllist(){
        // Define the JsonObject type variable, which is then returned
        List<RouteEntity> route = new ArrayList<>();
        try {
            route= routeJPA.findAll();
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
        list.put("data",route);

        return list;
    }

    /**
     * Select page amount json object.
     *
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/route-config/selectpageamount", method = GET)
    public JSONObject selectPageAmount(){
        // Define the JsonObject type variable, which is then returned
        JSONObject json = new JSONObject();
        Page<Route_configEntity> routes;

        try {
            routes = route_configJPA.findAll(new PageRequest(0, 10));
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
    @RequestMapping(value = "/api/route-config/selectbycondition", method = GET)
    public JSONObject listByCondition(HttpServletRequest request) {
        // Define the JsonObject type variable, which is then returned
        JSONObject list=new JSONObject();
        String key = request.getParameter("key");

        List<Route_configEntity> routes;
        try {
            if (key.equals("") || key == null){
                routes = route_configJPA.findAll();
            } else {
                routes = route_configJPA.findByCondition(key);
            }
        } catch (Exception e){
            // If the query fails, custom code 400,Exception message, and data are returned
            list.put("code", 400);
            list.put("message","ok");
            list.put("data","");
            return list;
        }
        // If the query success, custom code 200, message, and data are returned
        list.put("code", 200);
        list.put("message","ok");
        list.put("data",routes);//.getContent()
        return list;
    }

    /**
     * List of platform json object.
     *
     * @param request the request
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/route-config/selectplatform", method = GET)
    public JSONObject listOfPlatform(HttpServletRequest request) {
        JSONObject list = new JSONObject();
        List<ReferenceEntity> platform;

        try {
            platform = referenceJPA.findPlatForm("000");
        } catch (Exception e){
            // If the query fails, custom code 400,Exception message, and data are returned
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // If the query success, custom code 200, message, and data are returned
        list.put("code", 200);
        list.put("message","ok");
        list.put("data",platform);//.getContent()
        return list;
    }

    /**
     * Sys list of platform json object.
     *
     * @param request the request
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "/api/route-config/selectsys", method = GET)
    public JSONObject sysListOfPlatform(HttpServletRequest request) {
        JSONObject list = new JSONObject();
        // Get the request parameter key
        String key = request.getParameter("key");
        List<ReferenceEntity> system;

        try {
            system = referenceJPA.findSystem(key);
        } catch (Exception e){
            // If the query fails, custom code 400, message, and data are returned
            list.put("code", 400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        if(system.size() == 0) {
            // If the query is empty, custom code 300, message, and data are returned
            list.put("code", 300);
            list.put("message","empty");
            list.put("data","");//.getContent()
            return list;
        }
        //If the query success, custom code 200, message, and data are returned
        list.put("code", 200);
        list.put("message","ok");
        list.put("data",system);//.getContent()
        return list;
    }

    /**
     * Time stamp date date.
     *
     * @param seconds the seconds
     * @param format  the format
     * @return the date
     */
    public static Date timeStampDate(String seconds,String format) {
        //
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return null;
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(Long.valueOf(seconds));
        return date;
    }
}
