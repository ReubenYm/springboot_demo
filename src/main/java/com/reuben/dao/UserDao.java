package com.reuben.dao;

import com.reuben.pojo.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface UserDao extends JpaRepository<User, Integer> {


    /**
     * @Description: 通过user_name查询
     * @Param: [name]
     * @return: java.util.List<com.reuben.pojo.User>
     */
    @Query(name = "findByUserName", nativeQuery = true, value = "select * from tb_user where user_name= :user_name")
    List<User> findByUserName(@Param("user_name") String name);

    /**
     * @Description: 逻辑删除
     * @Param: [userId]
     * @return: void
     */
    @Transactional
    @Modifying
    @Query(name = "deleteByUserId", nativeQuery = true, value = "update tb_user set isdel = '1' where id= :userId")
    void deleteByUserId(@Param("userId") Integer userId);
}