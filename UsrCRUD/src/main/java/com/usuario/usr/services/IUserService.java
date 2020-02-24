package com.usuario.usr.services;

import java.util.List;

import com.usuario.usr.entity.Usuario;

/**
 * IUserService interface
 * @author dave
 *
 */
public interface IUserService {

	/**
	 * findAll method
	 * @return
	 */
	public List<Usuario> findAll();
	
	/**
	 * saveUser method
	 * @param usuario
	 * @return
	 */
	public Usuario saveUser(Usuario usuario);
	
	/**
	 * findById method
	 * @param id
	 * @return
	 */
	public Usuario findById(Integer id);
	
	/**
	 * saveOrUpdateMovie method
	 * @param usuario
	 * @return
	 */
	public Usuario saveOrUpdateMovie(Usuario usuario);
	
	/**
	 * delete method
	 * @param usuario
	 */
	void delete(Usuario usuario);
	
}
