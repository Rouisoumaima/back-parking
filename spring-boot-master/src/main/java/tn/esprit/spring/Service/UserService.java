package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.PlaceParking;
import tn.esprit.spring.Entity.User;

public interface UserService {
	List<User>retrieveAllUsers();
	User addUser (User u);
	void deleteUser (Long id);
	Optional<User> retrieveUser ();
	User updateUser(User client);
	public List<User> sortUsers(List<User> users);
	void assignUsersToPlaces(List<User> users, List<PlaceParking> places);
	Optional<User> retrieveUser(Long id);
	}
