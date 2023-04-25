package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.User;

public interface UserRepository  extends CrudRepository<User, Long >{

	//User findUserByEmail(String email);
	//User findUserByPassword(String password);
	User findUserById(String username,String password);
}