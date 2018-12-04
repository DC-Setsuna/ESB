package com.admin.adminsystem.controller;

import com.admin.adminsystem.entity.ReferenceEntity;
import com.admin.adminsystem.jpa.ReferenceJPA;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Reference controller.
 */
@RestController
public class ReferenceController {

    /**
     * The Reference.
     */
    @Autowired
    ReferenceJPA reference;

    /**
     * Select all json object.
     *
     * Select all Message about the reference
     *
     * @return the json object
     */
    @ResponseBody
    @RequestMapping(value = "api/reference/select")
    public JSONObject selectall() {
        JSONObject list = new JSONObject();
        List<ReferenceEntity> referencelist;
        try{
            // Select all in Reference
            referencelist = reference.findAll();
        }catch(Exception e) {
            // Encapsulated as JSONObject data and returned to the front end
            list.put("code","200");
            list.put("message","ok");
            list.put("data", "");
            return list;
        }
        // If select fail ,return custom status 201、message and Exeption messages
        list.put("code","201");
        list.put("message","fail");
        list.put("data", referencelist);
        return list;
    }
}
