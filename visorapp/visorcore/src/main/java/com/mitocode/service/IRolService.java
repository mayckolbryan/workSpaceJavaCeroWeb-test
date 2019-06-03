package com.mitocode.service;

import java.util.List;

import com.mitocode.model.entity.Rol;
import com.mitocode.model.entity.User;
import com.mitocode.model.entity.UserRol;


public interface IRolService extends CrudService<Rol> {
	Integer assignRolesToUser(User user, List<Rol> roles) throws Exception;
	
	List<UserRol> findRolesByUser(User user)throws Exception;

}