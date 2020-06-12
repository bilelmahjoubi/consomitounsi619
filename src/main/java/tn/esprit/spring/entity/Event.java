package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Event {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_E")
	private long id;

	@Temporal(TemporalType.DATE)
	private Date datee ;

	private int nbparticipant; 

	private int nbplace ;

	private String titre ;
	
	private String description;

	@JsonIgnore
	@OneToOne(mappedBy="event")
	private Publicite publicite_id ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public int getNbparticipant() {
		return nbparticipant;
	}

	public void setNbparticipant(int nbparticipant) {
		this.nbparticipant = nbparticipant;
	}

	public int getNbplace() {
		return nbplace;
	}

	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Publicite getPublicite_id() {
		return publicite_id;
	}

	public void setPublicite_id(Publicite publicite_id) {
		this.publicite_id = publicite_id;
	}

	public Event() {
		super();
	}

	public Event(int id, Date datee, int nbparticipant, int nbplace, String titre, String description,
			Publicite publicite_id) {
		super();
		this.id = id;
		this.datee = datee;
		this.nbparticipant = nbparticipant;
		this.nbplace = nbplace;
		this.titre = titre;
		this.description = description;
		this.publicite_id = publicite_id;
	}

	
	
	

}
