package com.raghul.expensetracker.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.UserEmail;

public interface UserEmailRepository extends JpaRepository<UserEmail,UUID>{
	
	List<UserEmail> findByUserId(UUID userId);

}
