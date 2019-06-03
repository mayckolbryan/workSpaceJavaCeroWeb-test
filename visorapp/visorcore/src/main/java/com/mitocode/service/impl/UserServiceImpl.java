package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import com.mitocode.model.entity.User;
import com.mitocode.model.repository.IUserRepository;
import com.mitocode.service.IUserService;

@Named
public class UserServiceImpl implements IUserService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserRepository userRepository;

	@Transactional
	@Override
	public Integer insert(User t) throws Exception {
		return userRepository.insert(t);
	}

	@Transactional
	@Override
	public Integer update(User t) throws Exception {
		return userRepository.update(t);
	}

	@Transactional
	@Override
	public Integer delete(User t) throws Exception {
		return userRepository.delete(t);
	}

	@Override
	public List<User> findAll() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public User findById(User t) throws Exception {
		return userRepository.findById(t);
	}

	@Override
	public Optional<User> authentication(User user) throws Exception {
	
		String password = user.getPassword();

		String passwordHashed = userRepository.getPassworHashedByUserName(user.getUsername());

		if (BCrypt.checkpw(password, passwordHashed)) {
			user.setPassword(passwordHashed);
			return userRepository.findByUsername(user);
		}

		return Optional.of(new User());
	}

}
