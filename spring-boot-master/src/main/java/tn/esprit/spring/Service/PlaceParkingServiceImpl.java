package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.PlaceParking;
import tn.esprit.spring.Repository.ParkingRepository;
import tn.esprit.spring.Repository.PlaceParkingRepository;

@Service
public class PlaceParkingServiceImpl implements PlaceParkingService {
	@Autowired
	PlaceParkingRepository placeparkingRepository;
	@Autowired
	ParkingRepository parkingRepository;
	
	@Override
	public List<PlaceParking> retrieveAllPlaceParkings() {
		return (List<PlaceParking>) placeparkingRepository.findAll();
	}

	@Override
	public PlaceParking addPlaceParking(long id,PlaceParking pp) {
		parkingRepository.findById(id);
		pp.setParking(parkingRepository.findById(id).get());
		placeparkingRepository.save(pp);
		 return pp;
	}

	@Override
	public void deletePlaceParking(Long id) {
		placeparkingRepository.deleteById(id);
		
	}
	
	@Override
	public Optional<PlaceParking> retrievePlaceParking(Long id) {
		return placeparkingRepository.findById(id) ;

	}
	
	@Override
	public PlaceParking updatePlaceParking(long id,PlaceParking placeparking) {
		
		 //parkingRepository.findById(id);
		// placeparking.setParking(parkingRepository.findById(id).get());
		return placeparkingRepository.save(placeparking);
	}
	
	
	
	

}
