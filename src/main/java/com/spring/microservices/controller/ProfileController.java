package com.spring.microservices.controller;

import java.util.UUID;

import com.spring.microservices.model.Profile;
import com.spring.microservices.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {
    @Autowired
    private ProfileRepository repo;

    @PostMapping("/profile")
    public Profile createProfile(@RequestBody Profile body) {
        Profile profile = new Profile(body.getName(), body.getDob(), body.getUserId());
        return repo.save(profile);
    }

    @GetMapping("/profile/{user_id}")
    public Profile getProfile(@PathVariable("user_id") UUID userId) {
        return repo.findByUserId(userId);
    }
}