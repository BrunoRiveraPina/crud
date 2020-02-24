package com.usuario.usr.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usuario.usr.entity.Usuario;
import com.usuario.usr.services.IUserService;

/**
 * AppController class
 * @author dave
 *
 */
@Controller
@RequestMapping("/")
public class AppController implements ErrorController {
	
	@Autowired
	private IUserService srv;
	
	/**
	 * Redirect to login
	 * @return
	 */
	@SuppressWarnings("unused")
	@GetMapping({"/", "/login"})
    public String loginGet(
    		Model model) {
		System.out.println("/loginGet");
		
		List<Usuario> findAll = getSrv().findAll();
		model.addAttribute("usuarios", getSrv().findAll());
        return "dashboard";
    }
	
	/**
	 * Redirect to dashboard
	 * @return
	 */
	@PostMapping({"/dashboard"})
    public String dashboard(
    		Model model) {
		System.out.println("/dashboard");
		
		List<Usuario> findAll = getSrv().findAll();
		boolean empty = findAll.isEmpty();
		System.out.println("Empty=" + empty);
		model.addAttribute("usuarios", getSrv().findAll());
		
        return "dashboard";
    }
	
	/**
	 * Redirect to create user
	 * @return
	 */
	@PostMapping("/newUsuario")
	public String newUsuario(
			Model model) {
		System.out.println("/newUsuario");
		
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
        return "create";
	}

    /**
	 * Redirect to dashboard
	 * @return
	 */
	@SuppressWarnings("unused")
	@PostMapping("/createUsuario")
	public String createUsuario(
			Model model,
			@ModelAttribute("usuario") Usuario usuario) {
		System.out.println("/newUsuario");
		
		usuario.setFechaAlta(new Date());
		
		System.out.println("Id=" + usuario.getId());
		System.out.println("Nombre=" + usuario.getNombre());
		System.out.println("Edad=" + usuario.getEdad());
		System.out.println("FechaAlta=" + usuario.getFechaAlta());
		System.out.println("Estatus=" + usuario.getEstatus());
		
		usuario = getSrv().saveUser(usuario);
		
		List<Usuario> findAll = getSrv().findAll();
		model.addAttribute("usuarios", getSrv().findAll());
		return "dashboard";
	}
	
	/**
	 * Redirect to edit movie
	 * @return
	 */
	@PostMapping("/editUser")
	public String editMovie(
			Model model,
			@RequestParam("id") Integer id) {
		
		Usuario usuario = getSrv().findById(id);
		model.addAttribute("usuario", usuario);
		return "edit";
	}
	
	/**
	 * Redirect to dashboard
	 * @return
	 */
	@SuppressWarnings("unused")
	@PostMapping("/modUser")
	public String modPelicula(
			Model model,
			@ModelAttribute("usuario") Usuario usuario) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(usuario.getFechaAlta());
		Date parse = null;
		try {
			parse = sdf.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		usuario.setFechaAlta(parse);
		usuario = getSrv().saveOrUpdateMovie(usuario);
		
		List<Usuario> findAll = getSrv().findAll();
		model.addAttribute("usuarios", getSrv().findAll());
		return "dashboard";
	}
	
	/**
	 * Redirect to delete user
	 * @return
	 */
	@PostMapping("/deleteUser")
	public String deleteUsuario(
			Model model,
			@RequestParam("id") Integer id) {
		
		Usuario usuario = getSrv().findById(id);
		model.addAttribute("usuario", usuario);
		return "delete";
	}
	
	/**
	 * Redirect to dashboard
	 * @return
	 */
	@SuppressWarnings("unused")
	@PostMapping("/delUser")
	public String delPelicula(
			Model model,
			@ModelAttribute("usuario") Usuario usuario,
			@RequestParam("id") Integer id) {
		
		getSrv().delete(usuario);
		
		List<Usuario> findAll = getSrv().findAll();
		model.addAttribute("usuarios", getSrv().findAll());
		return "dashboard";
	}
	
	/**
	 * Redirect to error
	 * @return
	 */
	@PostMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    }
	    return "error";
	}
	
	/**
	 * getErrorPath method
	 */
	@Override
    public String getErrorPath() {
        return "/error";
    }

	public IUserService getSrv() {
		return srv;
	}

	public void setSrv(IUserService srv) {
		this.srv = srv;
	}
    
}
