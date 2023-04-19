package es.dario.bootcamp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dario.bootcamp.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	List<Users> findAll();
	
	public Users findById (int id);
	
	public Users save (Users user);
	
	public Users deleteById (int id);
}
