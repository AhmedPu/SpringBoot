/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entities.Player;
import com.example.demo.repository.PlayerRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KUCA
 */
@RestController
public class PlayerController {

    private PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    List<Player> all() {
        return repository.findAll();
    }

    @GetMapping("/players/{id}")
    Player get(@PathVariable long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Player not found"));
    }

    @PostMapping("/players")
    Player newPlayer(@RequestBody Player player) {
        return repository.save(player);
    }

    @PutMapping("/players/{id}")
    Player updatePlayer(@PathVariable Long id, @RequestBody Player newPlayer) throws Exception {
        return repository.findById(id)
                .map(player -> {
                    player.setName(newPlayer.getName());
                    player.setAge(newPlayer.getAge());
                    player.setGoals(newPlayer.getGoals());
                    return repository.save(player);
                })
                .orElseThrow(() -> new Exception("Player not found"));
    }

    @DeleteMapping("/players/{id}")
    void deletePlayer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
