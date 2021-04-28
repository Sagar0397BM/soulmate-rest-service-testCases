package com.stackroute.soulMateDemo.repository;

import com.stackroute.soulMateDemo.Domain.User;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        User user= new User("John","Male",25);
        userRepository.save(user);
        User user1= userRepository.findById(user.getId()).get();
        assertNotNull(user1);
        assertEquals(user1.getName(),user1.getName());
    }

    @Test
    public  void listallTheUsers(){
        User user= new User("John","Male",25);
        User user1= new User("Lisa","Female",25);
        userRepository.save(user);
        userRepository.save(user1);
        List<User> getAll=userRepository.findAll();
        assertEquals("Lisa", getAll.get(1).getName());
    }

    @Test
    public void searchByName(){
        User user= new User("John","Male",25);
        User user1= new User("Lisa","Female",25);
        userRepository.save(user);
        userRepository.save(user1);
        String name="John";
        List<User> userList= userRepository.getAllUsersByName(name);
        assertEquals("John",userList.get(0).getName());
    }

    @Test
    public void searchByGender(){
        User user= new User("John","Male",25);
        User user1= new User("Lisa","Female",25);
        userRepository.save(user);
        userRepository.save(user1);
        String gender="Male";
        List<User> userList= userRepository.getAllUsersByGender(gender);
        assertEquals("Male",userList.get(0).getGender());
    }

    @Test
    @Rollback(value = false)
    public void delete(){
        User user= new User("John","Male",25);
        User user1= new User("Lisa","Female",25);
        userRepository.save(user);
        userRepository.save(user1);
       int id=2;
        userRepository.deleteById(id);
        Optional getUser=userRepository.findById(2);
        Assertions.assertThat(getUser.isEmpty());
    }

    @Test
    public void updateUser(){
        User user= new User("John","Male",25);
        User user1= new User("Lisa","Female",25);
        userRepository.save(user);
        userRepository.save(user1);
        int id=2;
        Optional<User> iuser=userRepository.findById(2);
        user1.setName("Sagar");
        assertEquals("Sagar",user1.getName());
    }

}