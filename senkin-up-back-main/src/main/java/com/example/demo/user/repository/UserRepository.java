package com.example.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByLogin (String Login);
    User findUserById (Integer id);
}
