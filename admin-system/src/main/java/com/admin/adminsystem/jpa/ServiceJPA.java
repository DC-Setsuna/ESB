package com.admin.adminsystem.jpa;

import com.admin.adminsystem.entity.Route_configEntity;
import com.admin.adminsystem.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DC on 2018/3/5.
 */
@Transactional
public interface ServiceJPA extends JpaRepository<ServiceEntity, String> {
    /**
     * Find service by condition list.
     *
     * @param key the key
     * @return the list
     */
    @Query(value = "select * from SERVICE t where t.SERVICE_CODE = ?1 or t.OWNER_ORG = ?1 or t.OWNER = ?1",nativeQuery=true)
    List<ServiceEntity> findServiceByCondition(String key);
}
