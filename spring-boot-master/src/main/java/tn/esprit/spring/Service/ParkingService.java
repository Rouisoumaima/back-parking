package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.Parking;

public interface ParkingService {
	List<Parking> retrieveAllParkings();
	Parking addParking (Parking p);
	void deleteParking (Long id);
	Optional<Parking> retrieveParking (Long id);
	Parking updateParking(Parking parking);
}
