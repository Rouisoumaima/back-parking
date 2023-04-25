package tn.esprit.spring.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.PlaceParking;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PlaceParkingService ppS;

	@Override
	public List<User> retrieveAllUsers() {

		return (List<User>) userRepository.findAll();
	}

	@Override
	public User addUser(User u) {
		userRepository.save(u);
		return u;
	}

	@Override
	public void deleteUser(Long id) {

		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}


	public void findUser(Long id) {
		userRepository.findUserById(null, null);
	}
	
	@Override
	public List<User> sortUsers(List<User> users) {

		// Tri des utilisateurs en fonction du titre du poste
		Collections.sort(users, Comparator.comparing(User::getTitre_poste));

		// Parcourir la liste des users pour déterminer leur priorité
		for (int i = 0; i < users.size() - 1; i++) {
			User current = users.get(i);
			User next = users.get(i + 1);

			// Si le poste actuel est Manager et le poste suivant est différent, le poste
			// actuel est prioritaire
			if (current.getTitre_poste().equals("Manager") && !current.getTitre_poste().equals(next.getTitre_poste())) {
				Collections.swap(users, i, 0);
			}
		}

		// Trier les users en fonction de la date d'embauche
		Collections.sort(users, Comparator.comparing(User::getDateEmbauche));

		return users;
	}

	public void assignUsersToPlaces(List<User> users, List<PlaceParking> placeparking) {
		if (users.size() > placeparking.size()) {
			throw new RuntimeException("Not enough places for all users");
		}
		
		System.out.println(users);
		System.out.println(placeparking);
		// Shuffle the list of users to assign them to random places
		Collections.shuffle(users);
	    
		// Assign each user to a place
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			PlaceParking place = placeparking.get(i);
			user.setPlaceparkings(place);
//			place.setUser(user);

			// Update the user and place in the database
			updateUser(user);
			ppS.updatePlaceParking(place.getId(), place);
		}
	}

	@Override
	public Optional<User> retrieveUser() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<User> retrieveUser(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
