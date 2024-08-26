package com.maha.ecommerce.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maha.ecommerce.user_service.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
