package com.usuario.usr.dao.impl;

import org.springframework.stereotype.Repository;

import com.usuario.usr.dao.IUserDAO;
import com.usuario.usr.entity.Usuario;

/**
 * UserDAO class
 * @author dave
 *
 */
@Repository
public abstract class UserDAO implements IUserDAO {

	/**
	 * findById method
	 */
	public Usuario findById(Integer id) {
		return this.findById(id);
	}
	
}
