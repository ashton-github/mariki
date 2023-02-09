package com.mariki.springjwt.controllers;


import com.mariki.springjwt.models.User;
import com.mariki.springjwt.payload.response.MessageResponse;
import com.mariki.springjwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.creatUser(user);
    }
    */

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUser() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getUserById (@PathVariable Long id) {
        User user;
        try {
            user = userService.getUserById(id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("id not found ...!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(user);

    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<?> modifyUsers(@PathVariable Long id, @RequestBody User user) {
        User modifiedUser;
        try {
             modifiedUser =  userService.modifyUser(id, user);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("id not found ...!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(modifiedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        String response;
        try {
            response = userService.deleteUser(id);
        }catch (RuntimeException e) {
            return new ResponseEntity<>("id not found ...!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(response);
    }

}
