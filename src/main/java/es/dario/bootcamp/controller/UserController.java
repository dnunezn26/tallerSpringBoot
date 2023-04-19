package es.dario.bootcamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dario.bootcamp.model.Users;
import es.dario.bootcamp.repository.UserService;


@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

	@Autowired
	private UserService service;
	
	//Buscar todos los usuarios
	@GetMapping("/users")
	public ResponseEntity<List<Users>> findAll() {
		List<Users> listado = new ArrayList<Users>();
		listado = service.findAll();
		return new ResponseEntity<>(listado, HttpStatus.OK);
	}
	
	//Buscar Usuario por ID
	@GetMapping("/users/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable("id") int id){
		Users usuario = service.findById(id);
		return new ResponseEntity<Users>(usuario, HttpStatus.OK);	
	}
	
	//Modificar Usuario, indicando ID en el body
	@PutMapping(value = "/users/")
	public Users updateUser(@RequestBody Users user){
		return service.saveUser(user);
	}
	
	//Crear Usuario
	@PostMapping(value = "/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
		//Validación si no se indica nombre o la fecha de nacimiento
		 if (user.getName() == null && user.getBirthDate() == null){
	            throw new IllegalArgumentException("The user's name and date of birth must be entered.");
	        } else if (user.getName() == null) {
	            throw new IllegalArgumentException("The user name must be entered.");
	        }else if (user.getBirthDate() == null){
	            throw new IllegalArgumentException("The user's date of birth must be entered.");
	        }
    	return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
    }
	
	//Borrar Usuario indicando ID
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Integer id){
		service.delete(id);
	}
}
