package com.shiv.springpostgres.repository;
import org.springframework.data.jpa.repository.JpaRepository; 

import org.springframework.stereotype.Repository;

import com.shiv.springpostgres.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
