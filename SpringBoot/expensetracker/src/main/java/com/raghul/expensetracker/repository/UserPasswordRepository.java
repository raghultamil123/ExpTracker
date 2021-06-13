package com.raghul.expensetracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.UserPassword;

public interface UserPasswordRepository extends JpaRepository<UserPassword, UUID>{

}
