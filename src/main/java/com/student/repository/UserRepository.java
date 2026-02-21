package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);

}