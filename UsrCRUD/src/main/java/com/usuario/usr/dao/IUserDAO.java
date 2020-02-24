package com.usuario.usr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.usr.entity.Usuario;

/**
 * IUserDAO interface
 * @author dave
 *
 */
public interface IUserDAO extends JpaRepository<Usuario, Long> {
	
	/**
	 * findById method
	 * @param id
	 * @return
	 */
	Usuario findById(Integer id);
	
}
