package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.Entity.PlaceParking;

public interface PlaceParkingService {
	List<PlaceParking> retrieveAllPlaceParkings();
	PlaceParking addPlaceParking (long id,PlaceParking pp);
	void deletePlaceParking (Long id);
	PlaceParking updatePlaceParking(long id,PlaceParking placeparking);
	Optional<PlaceParking> retrievePlaceParking(Long id);
}
