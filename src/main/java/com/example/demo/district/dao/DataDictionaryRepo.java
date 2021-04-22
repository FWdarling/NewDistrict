package com.example.demo.district.dao;

import com.example.demo.district.entity.DataDictionary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataDictionaryRepo extends CrudRepository<DataDictionary, Long> {
    List<DataDictionary> findAll();
}
