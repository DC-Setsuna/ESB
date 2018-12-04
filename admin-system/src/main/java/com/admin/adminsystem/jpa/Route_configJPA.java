package com.admin.adminsystem.jpa;

import com.admin.adminsystem.entity.Route_configEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Route config jpa.
 */
@Transactional
public interface Route_configJPA extends JpaRepository<Route_configEntity, String> {

    /**
     * Find by condition list.
     *
     * @param key the key
     * @return the list
     */
    @Query(value = "select * from ROUTE_CONFIG t where t.SENDER = ?1 or t.SENDER_ORG = ?1 or t.RECEIVER_ORG = ?1 or t.RECEIVER = ?1 or t.SERVICE_CODE = ?1",nativeQuery=true)
    List<Route_configEntity> findByCondition(String key);

}
