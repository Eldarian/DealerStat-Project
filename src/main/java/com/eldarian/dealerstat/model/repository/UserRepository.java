package com.eldarian.dealerstat.model.repository;

import com.eldarian.dealerstat.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
