package tn.esprit.spring.Controller;


import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.Entity.LoginRequest;

import tn.esprit.spring.Entity.PlaceParking;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.PlaceParkingRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Service.PlaceParkingService;
import tn.esprit.spring.Service.UserService;

@CrossOrigin(origins = "http://localhost:8380")
@RestController
@RequestMapping("/users") 
public class UserController {
	
		@Autowired
		UserService userService;
	
		@Autowired
		private UserRepository userRepository;

	    @Autowired
	    private PlaceParkingRepository placeParkingRepository;
	    
	    @Autowired
	    private PlaceParkingService placeparkingService;
	   
	
	
	@PostMapping("/add-user")
	User addUser(@RequestBody User u){
		return userService.addUser(u);
	}
	
	@GetMapping("/retrieve-allUsers")
	@ResponseBody
	List<User> retrieveAllUsers()
	{
		return userService.retrieveAllUsers();
	}
	
	@PutMapping("/Modify-user")
	@ResponseBody
	User updateUser(@RequestBody User u)
	{
		return userService.updateUser(u) ;
	}
	
	@DeleteMapping("delete-user/{id}")
	
	void deleteUser(@PathVariable(name="id")Long id)
	{
		userService.deleteUser(id);
	}
	
	@PostMapping("/users/{userId}/placeparking/{parkingId}")
    public User assignParkingToUser(@PathVariable Long id, @PathVariable Long pparkingId) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        PlaceParking placeparking = placeParkingRepository.findById(pparkingId).orElseThrow(() -> new EntityNotFoundException("Parking not found"));

        user.setPlaceparkings(placeparking);
        //placeparking.setUser(user);

        userRepository.save(user);
        placeParkingRepository.save(placeparking);

        return user;
    }


    @GetMapping("/sorted")
    public List<User> getSortedUsers() {
        List<User> users = userService.retrieveAllUsers(); // récupère tous les utilisateurs à partir du service
        List<User> sortedUsers = userService.sortUsers(users); // trie les utilisateurs
        return sortedUsers;
    }
	
	
	@GetMapping("/assign-places")
	  public ResponseEntity<String> assignUsersToPlaces() {
	    List<User> users = userService.retrieveAllUsers();
	    List<PlaceParking> places = placeparkingService.retrieveAllPlaceParkings();
	    userService.assignUsersToPlaces(users, places);
	    return ResponseEntity.ok("Users assigned to places successfully");
	  }
	  
	  
	  
	
	  
	@PostMapping ("/login")
	public User login(@RequestBody LoginRequest loginRequest){
		
		 User user = userRepository.findUserById();
		 
		
		return userService.findUserById(user);
	}

	  
	  
	  
	  
	 
	
}
