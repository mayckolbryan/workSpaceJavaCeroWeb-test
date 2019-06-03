package com.mitocode.model.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mitocode.model.entity.User;
import com.mitocode.model.repository.IUserRepository;

@Named
public class UserRepositoryImpl implements IUserRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "visorPU")
	private EntityManager em;

	@Override
	public Integer insert(User t) throws Exception {
		em.persist(t);
		return t.getDoctor().getId();
	}

	@Override
	public Integer update(User t) throws Exception {
		em.merge(t);
		return t.getDoctor().getId();
	}

	@Override
	public Integer delete(User t) throws Exception {
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		return null;
	}

	@Override
	public User findById(User t) throws Exception {

		return null;
	}

	@Override
	public String getPassworHashedByUserName(String username) throws Exception {
		User userFound = new User();

		try {

			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1", User.class);
			query.setParameter(1, username);

			List<User> users = query.getResultList();
			if (!users.isEmpty()) {
				userFound = users.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return userFound != null ? userFound.getPassword() : "";
	}

	@Override
	public Optional<User> findByUsername(User user) throws Exception {
		User userFound = new User();

		try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = ?1 and u.password=?2",
					User.class);
			query.setParameter(1, user.getUsername());
			query.setParameter(2, user.getPassword());

			List<User> users = query.getResultList();
			if (!users.isEmpty()) {
				userFound = users.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return Optional.of(userFound);
	}

}
