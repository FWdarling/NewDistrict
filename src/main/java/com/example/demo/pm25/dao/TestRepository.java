package com.example.demo.pm25.dao;

import com.example.demo.pm25.entity.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * description: TestRepo
 * date: 4/23/21 11:06 PM
 * author: fourwood
 */
@Repository
public interface TestRepository extends CrudRepository<Test, Long> {

}
