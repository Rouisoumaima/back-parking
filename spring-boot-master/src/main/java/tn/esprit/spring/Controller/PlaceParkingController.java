package tn.esprit.spring.Controller;

import java.util.ArrayList;
import java.util.List;


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

import tn.esprit.spring.Entity.PlaceParking;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.PlaceParkingRepository;
import tn.esprit.spring.Service.PlaceParkingService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/placeparkings")
public class PlaceParkingController {
	@Autowired
	PlaceParkingService placeparkingService;
	
	@Autowired
	PlaceParkingRepository placeParkingRepository;
	
	@PostMapping("/add-placeparking/{id}")
	@ResponseBody
	PlaceParking addPlaceParking(@RequestBody PlaceParking pp,@PathVariable long id){
		return placeparkingService.addPlaceParking(id,pp);
		
	}
	
	
	@GetMapping("/retrieve-AllPlaceParkings")
	@ResponseBody
	List<PlaceParking>  retrieveAllPlaceParkings()
	{
		return placeparkingService.retrieveAllPlaceParkings();
	}
	
	
	@PutMapping("/Modify-placeparking/{id}")
	@ResponseBody
	PlaceParking updatePlaceParking(@RequestBody PlaceParking pp,@PathVariable("id") long id)
	{
		return placeparkingService.updatePlaceParking(id,pp) ;
	}
	
	
	@GetMapping(path="/{id}")
	public PlaceParking getPlaceById(@PathVariable long id) {
		return placeParkingRepository.findById(id).get();
	}
	
	@DeleteMapping("delete-placeparking/{id}")
	void deletePlaceParking(@PathVariable(name="id")Long id)
	{
		placeparkingService.deletePlaceParking(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
