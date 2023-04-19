package es.dario.bootcamp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dario.bootcamp.model.Users;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userImpl;
	
	//Buscar Usuario por ID
	public Users findById(int Id) {
		return userImpl.findById(Id);
	}
	
	//Buscar todos los usuarios
	public List<Users> findAll() {
		return userImpl.findAll();
	}
	
	//Guarda el usuario
	public Users saveUser(Users user){
		return userImpl.save(user);
	}
	
	//Borrar Usuario indicando ID
	@Transactional
	public void delete(int id){
	    userImpl.deleteById(id);
	}
}
