package com.admin.adminsystem.jpa;

import com.admin.adminsystem.entity.Msgflow_LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * The interface Msgflow log jpa.
 */
@Transactional
public interface Msgflow_LogJPA extends JpaRepository<Msgflow_LogEntity,String>, JpaSpecificationExecutor {

}
