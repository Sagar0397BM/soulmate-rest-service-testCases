package com.stackroute.soulMateDemo.repository;

import com.stackroute.soulMateDemo.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("FROM User WHERE gender=:Usergender")
    List<User> getAllUsersByGender(@Param("Usergender") String gender);

    @Query("FROM User WHERE name=:Username")
    List<User> getAllUsersByName(@Param("Username") String gender);

    @Query("FROM User WHERE age=:Userage")
    List<User> getAllUsersByAge(@Param("Userage") int age);
}
