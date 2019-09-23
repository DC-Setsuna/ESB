package com.admin.adminsystem.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DC on 2018/8/25.
 */
@Repository
public interface SystemUserDao {
    void asd();

    void insertSystemuser(HashMap<String, String> map);

    void deleteSystem();

    List<HashMap<String, String>> selectSystemuser();
}
