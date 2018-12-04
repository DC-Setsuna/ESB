package com.admin.adminsystem.jpa;

import com.admin.adminsystem.entity.RouteEntity;
import com.admin.adminsystem.entity.Route_configEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Route jpa.
 */
@Transactional
public interface RouteJPA extends JpaRepository<RouteEntity, String> {

}