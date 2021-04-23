package com.example.demo.climate.dao;

import com.example.demo.climate.entity.Test;
import org.springframework.data.repository.CrudRepository;

/**
 * description: TestRepo
 * date: 4/23/21 11:06 PM
 * author: fourwood
 */
public interface ClimateTestRepo extends CrudRepository<Test, Long> {

}
