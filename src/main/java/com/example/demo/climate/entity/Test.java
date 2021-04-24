package com.example.demo.climate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * description: Test
 * date: 4/23/21 11:04 PM
 * author: fourwood
 */
@Entity
public class Test {
    public Test(Long id) {
        this.id = id;
    }

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Id
    @Column(name = "id")
    private Long id;

}
