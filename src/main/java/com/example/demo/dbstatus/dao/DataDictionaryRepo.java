package com.example.demo.dbstatus.dao;

import com.example.demo.dbstatus.entity.DataDictionary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataDictionaryRepo extends CrudRepository<DataDictionary, Long> {
    List<DataDictionary> findAll();
}
