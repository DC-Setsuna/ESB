package com.admin.adminsystem.controller;

import com.admin.adminsystem.dao.SystemUserDao;
import com.admin.adminsystem.entity.Msgflow_LogEntity;
import com.admin.adminsystem.jpa.Msgflow_LogJPA;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.*;

/**
 * The type Msgflow log controller.
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@RestController
public class Msgflow_LogController {

    /**
     * The Msgflow.
     */
    @Autowired
    Msgflow_LogJPA msgflow;

    @Resource
    SystemUserDao dao;

    /**
     * Select by condition json object.
     *
     * @param info the info
     * @return the json object
     */
    @RequestMapping(value = "/api/msgflow/selectmsg", method = RequestMethod.POST)
    public JSONObject selectByCondition (@RequestBody String info) {//

        JSONObject list=new JSONObject();
        List<Msgflow_LogEntity> resultListTemp;
        List<Msgflow_LogEntity> resultList= new LinkedList<>();
        //String info = "{\"mindate\":\"\",\"maxdate\":\"\",\"sender_org\":\"ADXP\",\"sender\":\"\",\"receiver_org\":\"\",\"receiver\":\"\",\"type\":\"true\",\"page\":\"1\"}";

        Specification querySpecifi = new Specification<Msgflow_LogEntity>() {
            @Override
            public Predicate toPredicate(Root<Msgflow_LogEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                // Choose filter
                // Determines if there is a mindate variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("mindate").toString() && !JSON.parseObject(info).get("mindate").toString().equals("")){
                    String min = JSON.parseObject(info).get("mindate").toString();
                    predicates.add(criteriaBuilder.greaterThan(root.get("LOGTIMESTAMP"), Timestamp.valueOf(min)));
                }
                // Determines if there is a maxdate variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("maxdate").toString() && !JSON.parseObject(info).get("maxdate").toString().equals("")){

                    String max = JSON.parseObject(info).get("maxdate").toString();
                    predicates.add(criteriaBuilder.lessThan(root.get("LOGTIMESTAMP"), Timestamp.valueOf(max)));
                }

                if(null != JSON.parseObject(info).get("service_code").toString() && !JSON.parseObject(info).get("service_code").toString().equals("")){
                    predicates.add(criteriaBuilder.equal(root.get("SERVICE_CODE"), JSON.parseObject(info).get("service_code").toString()));
                }

                // Determines if there is a sender_org variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("sender_org").toString() && !JSON.parseObject(info).get("sender_org").toString().equals("")){
                    predicates.add(criteriaBuilder.equal(root.get("SENDER_ORG"), JSON.parseObject(info).get("sender_org").toString()));
                }
                // Determines if there is a sender variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("sender").toString() && !JSON.parseObject(info).get("sender").toString().equals("")){
                    predicates.add(criteriaBuilder.equal(root.get("SENDER"), JSON.parseObject(info).get("sender").toString()));
                }
                // Determines if there is a receiver variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("receiver").toString() && !JSON.parseObject(info).get("receiver").toString().equals("")){
                    predicates.add(criteriaBuilder.equal(root.get("RECEIVER"), JSON.parseObject(info).get("receiver").toString()));
                }
                // Determines if there is a receiver_org variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("receiver_org").toString() && !JSON.parseObject(info).get("receiver_org").toString().equals("")){
                    predicates.add(criteriaBuilder.equal(root.get("RECEIVER_ORG"), JSON.parseObject(info).get("receiver_org").toString()));
                }
                // Determines if there is a type variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("type").toString() && !JSON.parseObject(info).get("type").toString().equals("false")) {
                    predicates.add(criteriaBuilder.or(criteriaBuilder.equal(root.get("MSG_TYPE"), "1"),criteriaBuilder.equal(root.get("MSG_TYPE"), "3")));
                }
                // Determines if there is a type variable in the request, and if so, this field is added as a condition to the SQL statement
                if(null != JSON.parseObject(info).get("type").toString() && !JSON.parseObject(info).get("type").toString().equals("true")) {
                    predicates.add(criteriaBuilder.equal(root.get("MSG_TYPE"), "1"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        long number = 0;
        try {
            // Database display in reverse order
            Sort sort = new Sort(Sort.Direction.DESC, "LOGTIMESTAMP");
            // Paging display
            PageRequest pageRequest = new PageRequest(Integer.valueOf(JSON.parseObject(info).get("page").toString())-1, 10,sort);
            // Query data in the database that meets the above requirements
            Page<Msgflow_LogEntity> msg= msgflow.findAll(querySpecifi,pageRequest);
            number = msgflow.count(querySpecifi);
            resultListTemp = msg.getContent();
            resultList.addAll(resultListTemp);
            if(resultList != null)
            Collections.sort(resultList, resultList.get(0));
        } catch(Exception e){
            list.put("code","400");
            list.put("message",e.toString());
            list.put("data","");//.getContent()
            return list;
        }
        // Encapsulated as JSONObject data and returned to the front end
        list.put("code","200");
        list.put("message","ok");
        list.put("number",number);
        list.put("data",resultList);//.getContent()

        return list;
    }

    /**
     * Select by serial number json object.
     *
     * @param info the info
     * @return the json object
     */
    @RequestMapping(value = "/api/msgflow/selectmsgbynumber", method = RequestMethod.POST)
    public JSONObject selectBySerialNumber (@RequestBody String info) {

        JSONObject list=new JSONObject();
        List<Msgflow_LogEntity> resultList;

        // Get the request parameter serial_number
        String serial_number = JSON.parseObject(info).get("serial_number").toString();

        //Choose filter
        Specification querySpecifi = new Specification<Msgflow_LogEntity>() {
            @Override
            public Predicate toPredicate(Root<Msgflow_LogEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(null != serial_number && !serial_number.equals("")){
                    predicates.add(criteriaBuilder.equal(root.get("SERIAL_NUMBER"), serial_number));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        try{
            resultList = msgflow.findAll(querySpecifi);
        } catch(Exception e){
            list.put("code",400);
            list.put("message",e.toString());
            list.put("data","");
            return list;
        }
        // Returns custom status, response information, and return data in json format
        list.put("code",200);
        list.put("message","ok");
        list.put("data",resultList);
        return list;
    }

    @RequestMapping(value = "/api/msgflow/systemuser", method = RequestMethod.GET)
    public HashMap<String, ArrayList> systemuser() {
        List<HashMap<String, String>> results = dao.selectSystemuser();

        HashMap<String, ArrayList> response = new HashMap<>();

        for(HashMap result : results) {
            if(response.keySet().contains(result.get("SYSTEMUSER_ORG"))) {
                response.get(result.get("SYSTEMUSER_ORG")).add(result.get("SYSTEMUSER_CODE"));
            } else {
                response.put((String) result.get("SYSTEMUSER_ORG"), new ArrayList());
                response.get(result.get("SYSTEMUSER_ORG")).add(result.get("SYSTEMUSER_CODE"));
            }
        }

        return response;
    }
}
