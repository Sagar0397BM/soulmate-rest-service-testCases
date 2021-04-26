package com.stackroute.soulMateDemo.service;

import com.stackroute.soulMateDemo.Domain.User;
import com.stackroute.soulMateDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepo;
    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User saveUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return (List<User>) userRepo.findAll();
    }

    @Override
    public void deleteUser(int id) {

        userRepo.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        Optional<User> eachUser = userRepo.findById(id);
        user.setId(id);
        return userRepo.save(user);
    }

    @Override
    public List<User> searchUserByGender(String gender) {
        return userRepo.getAllUsersByGender(gender);
    }

    @Override
    public List<User> searchUserByName(String name) {
        return userRepo.getAllUsersByName(name);
    }

    @Override
    public List<User> searchUserByAge(int age) {
        return userRepo.getAllUsersByAge(age);
    }


}
