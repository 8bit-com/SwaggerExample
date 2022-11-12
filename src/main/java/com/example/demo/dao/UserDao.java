package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("Select u from User u WHERE u.name=:name")
    User findByUsername(@Param("name") String name);
}
