package com.usuario.usr.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.usr.dao.IUserDAO;
import com.usuario.usr.entity.Usuario;
import com.usuario.usr.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	
	/**
	 * saveUser method
	 */
	@Override
	public List<Usuario> findAll() {
		return getUserDAO().findAll();
	}
	
	/**
	 * findById method
	 */
	@Override
	public Usuario findById(Integer id) {
		return getUserDAO().findById(id);
	}
	
	/**
	 * saveUser method
	 */
	@Override
	public Usuario saveUser(Usuario usuario) {
		return getUserDAO().save(usuario);
	}

	/**
	 * delete method
	 */
	@Override
	public void delete(Usuario usuario) {
		getUserDAO().delete(usuario);
	}
	
	/**
	 * saveOrUpdateMovie method
	 */
	public Usuario saveOrUpdateMovie(Usuario usuario) {
		return getUserDAO().save(usuario);
	}
	
	/**
	 * get userDAO
	 * @return
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * set userDAO
	 * @param userDAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	

}
