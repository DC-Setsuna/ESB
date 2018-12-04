package com.admin.adminsystem.dao;


import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface ServiceDao {

    void insert(HashMap<String, String> map);

    void backup();

    void delete();
}
