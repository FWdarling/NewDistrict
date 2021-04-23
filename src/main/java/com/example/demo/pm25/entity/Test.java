package com.example.demo.pm25.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * description: Test
 * date: 4/23/21 11:05 PM
 * author: fourwood
 */
@Entity
public class Test {
    public Test(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    private Long id;

    private String content;
}
