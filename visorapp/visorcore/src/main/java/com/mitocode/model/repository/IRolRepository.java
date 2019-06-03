package com.mitocode.model.repository;

import java.util.List;

import com.mitocode.model.entity.Rol;
import com.mitocode.model.entity.User;
import com.mitocode.model.entity.UserRol;

public interface IRolRepository extends JpaRepository<Rol> {

	Integer insertUserRole(List<UserRol> userRoles) throws Exception;
	
	List<UserRol> findRolesByUser(User user)throws Exception;

//	Integer deleteByUser(User t) throws Exception;
}
