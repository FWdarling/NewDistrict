package com.example.demo.dbstatus.dao;

import com.example.demo.dbstatus.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * description: UserRepo
 * date: 4/23/21 5:14 PM
 * author: fourwood
 */
public interface UserRepo extends CrudRepository<User, Long> {
    User findByUserName(String userName);

    User findById(long id);
}
