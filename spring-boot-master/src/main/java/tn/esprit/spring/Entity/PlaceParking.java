package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlaceParking implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="status")
    private String status;
   

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="parking_id")
    @JsonIgnore
    private Parking parking;

    public Parking getParking() {
		return parking;
	}


	public void setParking(Parking parking) {
		this.parking = parking;
	}

	
    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    

	
    
}
