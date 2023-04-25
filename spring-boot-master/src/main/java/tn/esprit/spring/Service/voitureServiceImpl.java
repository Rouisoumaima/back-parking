package tn.esprit.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.Voiture;
import tn.esprit.spring.Repository.VoitureRepository;

@Service
public class voitureServiceImpl implements VoitureService{
	
	@Autowired
	VoitureRepository voitureRepository;

	@Override
	public List<Voiture> retrieveAllVoitures() {
		
		return (List<Voiture>) voitureRepository.findAll();
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		 voitureRepository.save(v);
		 return v;
	}

	@Override
	public void deleteVoiture(Long id_proprietaire) {
		
		voitureRepository.deleteById(id_proprietaire);
	}
	
	@Override
	public Optional<Voiture> retrieveVoiture(Long id_proprietaire) {
		
		return voitureRepository.findById(id_proprietaire) ;
	}

	@Override
	public Voiture updateVoiture(Voiture voiture) {
		return voitureRepository.save(voiture);
	}

	

}
