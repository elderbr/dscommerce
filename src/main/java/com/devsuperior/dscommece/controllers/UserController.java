package com.devsuperior.dscommece.controllers;

import com.devsuperior.dscommece.dto.UserDTO;
import com.devsuperior.dscommece.entities.User;
import com.devsuperior.dscommece.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody User user){
        return ResponseEntity.ok(service.insert(user));
    }

}
