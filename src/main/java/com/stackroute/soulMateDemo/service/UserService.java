package com.stackroute.soulMateDemo.service;

import com.stackroute.soulMateDemo.Domain.User;

import com.stackroute.soulMateDemo.Exceptions.UserAlradyExistsException;
import com.stackroute.soulMateDemo.Exceptions.UserNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface UserService {

    User saveUser(User user) throws UserAlradyExistsException;
    List<User> getAllUser();
    String deleteUser(int id) throws NoSuchElementException;
    Optional<User> getUserById(int id)throws NoSuchElementException;;
    User updateUser(int id,User user)throws NoSuchElementException;;
    List<User> searchUserByGender(String gender);
    List<User> searchUserByName(String name);
    List<User> searchUserByAge(int age);





}
