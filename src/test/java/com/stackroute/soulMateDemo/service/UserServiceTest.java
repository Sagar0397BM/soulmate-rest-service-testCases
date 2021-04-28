package com.stackroute.soulMateDemo.service;

import com.stackroute.soulMateDemo.Domain.User;

import com.stackroute.soulMateDemo.Exceptions.UserAlradyExistsException;
import com.stackroute.soulMateDemo.repository.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void givenUserToSaveShouldReturnSavedUser() throws UserAlradyExistsException {
        User user= new User(1,"John","Male",25);
        when(userRepository.save(any())).thenReturn(user);
        userService.saveUser(user);
        verify(userRepository,times(1)).save(any());
    }

    @Test
    public  void listallTheUsers(){
        User user= new User(1,"John","Male",25);
        userRepository.save(user);
        List <User> userList = userService.getAllUser();
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(userList,userList);
        verify(userRepository,times(1)).save(user);
        verify(userRepository,times(1)).findAll();

    }
    @Test
    public  void UserbyName(){
        String name="John";
        when(userRepository.getAllUsersByName(name)).thenReturn(Stream.of(new
        User(1,"John","Male",25)).collect(Collectors.toList()));
        assertEquals(1,userService.searchUserByName(name).size());

    }
    @Test
    public  void UserbyGender(){
        String gender="Male";
        when(userRepository.getAllUsersByGender(gender)).thenReturn(Stream.of(new
                User(1,"John","Male",25)).collect(Collectors.toList()));
        assertEquals(1,userService.searchUserByGender(gender).size());

    }

    @Test
    public  void UserbyAge(){
        int age=25;
        when(userRepository.getAllUsersByAge(age)).thenReturn(Stream.of(new
                User(1,"John","Male",25)).collect(Collectors.toList()));
        assertEquals(1,userService.searchUserByAge(age).size());

    }
    @Test
    public  void deleteUser(){
        int id=2;
        User user= new User(1,"John","Male",25);
        userService.deleteUser(id);
        verify(userRepository,times(1)).deleteById(id);

    }
}