package com.admin.adminsystem.jpa;

import com.admin.adminsystem.entity.SystemuserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DC on 2018/8/24.
 */

@Transactional
public interface SystemuserJPA extends JpaRepository<SystemuserEntity, String>{

//    @Query(value = "INSERT INTO ESB.SYSTEMUSER_HIS \n" +
//            "(PK_SYSTEMUSER, SYSTEMUSER_ORG, SYSTEMUSER_CODE, SYSTEMUSER_DESC, INSERT_TIMESTAMP, LAST_UPDATE_TIMESTAMP, CREATOR, MODIFIER,BKUP_TIMESTAMP) \n" +
//            "SELECT \n" +
//            "PK_SYSTEMUSER, SYSTEMUSER_ORG, SYSTEMUSER_CODE, SYSTEMUSER_DESC, INSERT_TIMESTAMP, LAST_UPDATE_TIMESTAMP, CREATOR, MODIFIER,CURRENT_DATE \n" +
//            "FROM ESB.SYSTEMUSER", nativeQuery = true)

    @Query(value = "DELETE FROM SYSTEMUSER_HIS ", nativeQuery = true)
    int syncSystem();

}
