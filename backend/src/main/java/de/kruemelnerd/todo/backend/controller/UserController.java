package de.kruemelnerd.todo.backend.controller;

import de.kruemelnerd.todo.backend.model.User;
import de.kruemelnerd.todo.backend.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity getAllUser(){
        //FIXME: Write a nice Service for that
        return new ResponseEntity<List<User>>( userRepository.findAll(), HttpStatus.OK);
    }

}
