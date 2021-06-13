package com.raghul.expensetracker.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
