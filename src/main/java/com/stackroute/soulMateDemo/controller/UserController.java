package com.stackroute.soulMateDemo.controller;

import com.stackroute.soulMateDemo.Domain.User;
import com.stackroute.soulMateDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser= userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return  new ResponseEntity<List<User>>((List<User>) userService.getAllUser(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable int id){
        userService.deleteUser(id);
        return "User deleted successfully!!!";
    }
    @GetMapping("/users/{id}")
    public User userById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.get();
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateById(@PathVariable int id,@RequestBody User user) {
        userService.updateUser(id,user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/gender")
    public ResponseEntity<List<User>> UserByGender(@RequestParam(value = "genderType") String genderType){
        return  new ResponseEntity<List<User>>((List<User>) userService.searchUserByGender(genderType),HttpStatus.OK);
    }
    @GetMapping("/users/name")
    public ResponseEntity<List<User>> UserByName(@RequestParam(value = "name") String name){
        return  new ResponseEntity<List<User>>((List<User>) userService.searchUserByName(name),HttpStatus.OK);
    }
    @GetMapping("/users/search/{age}")
    public ResponseEntity<List<User>> UserByAge(@PathVariable int age){
        return  new ResponseEntity<List<User>>((List<User>) userService.searchUserByAge(age),HttpStatus.OK);
    }
}
