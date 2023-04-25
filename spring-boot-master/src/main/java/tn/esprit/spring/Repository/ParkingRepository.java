package tn.esprit.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Parking;

public interface ParkingRepository extends CrudRepository<Parking, Long> {

}
