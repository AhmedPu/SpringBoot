/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author KUCA
 */
@Entity
@Data
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int goals;
    private int age;

    @ManyToOne
    private Team team;

}
