package com.raghul.expensetracker.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghul.expensetracker.model.UserPhone;

public interface UserPhoneRepository extends JpaRepository<UserPhone, UUID> {
	
	List<UserPhone> findByUserId(UUID userId);

}
