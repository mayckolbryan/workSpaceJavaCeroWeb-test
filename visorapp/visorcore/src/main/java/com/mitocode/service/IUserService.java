package com.mitocode.service;

import java.util.Optional;

import com.mitocode.model.entity.User;

public interface IUserService extends CrudService<User> {

	Optional<User> authentication(User user) throws Exception;
}