package tn.esprit.spring.Entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
    private long id;
	@Column(nullable = false)
    private String username;
	@Column(nullable = false)
    private String prenom;
	@Column(nullable = false)
    private String email;
	@Column(name="password")
    private String password;
	@Enumerated(EnumType.STRING)
	private Titre titre_poste;
	@Column(nullable = false)
    private long num_tel;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateEmbauche;
	
	@Enumerated(EnumType.STRING)
	private Priorite priorite;
	
	@OneToOne(cascade = { CascadeType.ALL})
	private Voiture voitures;
	
	
	@OneToOne
	private PlaceParking placeparkings;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return username;
	}


	public void setNom(String nom) {
		this.username = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Titre getTitre_poste() {
		return titre_poste;
	}


	public void setTitre_poste(Titre titre_poste) {
		this.titre_poste = titre_poste;
	}


	public long getNum_tel() {
		return num_tel;
	}


	public void setNum_tel(long num_tel) {
		this.num_tel = num_tel;
	}


	public Date getDateEmbauche() {
		return dateEmbauche;
	}


	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}


	public Priorite getPriorite() {
		return priorite;
	}


	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}


	public Voiture getVoitures() {
		return voitures;
	}


	public void setVoitures(Voiture voitures) {
		this.voitures = voitures;
	}


	public PlaceParking getPlaceparkings() {
		return placeparkings;
	}


	public void setPlaceparkings(PlaceParking placeparkings) {
		this.placeparkings = placeparkings;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	

	
	}
