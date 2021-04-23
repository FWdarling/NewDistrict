package com.example.demo.dbstatus.dao;

import com.example.demo.dbstatus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * description: UserRepo
 * date: 4/23/21 5:14 PM
 * author: fourwood
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findById(long id);
}
