package com.mitocode.model.repository;

import java.util.Optional;

import com.mitocode.model.entity.User;

public interface IUserRepository extends JpaRepository<User> {

	String getPassworHashedByUserName(String username) throws Exception;

	Optional<User> findByUsername(User user) throws Exception;
}
