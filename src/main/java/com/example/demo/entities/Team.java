/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author KUCA
 */

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String foundationYear;
    
    @OneToMany(mappedBy = "team")
    @JsonIgnoreProperties("team")
    private List<Player> players;
}
