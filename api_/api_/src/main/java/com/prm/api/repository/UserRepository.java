package com.prm.api.repository;

import com.prm.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}