/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entities.Player;
import com.example.demo.entities.Team;
import com.example.demo.repository.TeamRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KUCA
 */
@RestController
public class TeamController {

    private TeamRepository repository;

    TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/teams")
    List<Team> all() {
        return repository.findAll();
    }

    @GetMapping("/teams/{id}")
    Team get(@PathVariable long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Team not found"));
    }

    @PostMapping("/teams")
    Team newTeam(@RequestBody Team team) {
        return repository.save(team);
    }

    @GetMapping("/teams/{id}/players")
    List<Player> getPlayers(@PathVariable long id) throws Exception {
        Team t = repository.findById(id).orElseThrow(() -> new Exception("Team not found"));
        return t.getPlayers();
    }

}
