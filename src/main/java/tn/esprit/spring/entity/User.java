package tn.esprit.spring.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	@Temporal(TemporalType.DATE)
    private Date dateNaissance;
	
	@NotBlank
	@Size(max = 20)
	private String Adresse;
	
	
	private int NumTel;
	
	private Boolean EtatAcc=true;
	
	@Column(name = "enabled")
    private boolean enabled=false;
	
	private String img;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id")) 
	
	private Set<Role> roles = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="Iduser" ,cascade=CascadeType.ALL)
	private Set<ImageUser> Images;
	
	

	public User() {
		super();
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}
	

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Date dateNaissance, @NotBlank @Size(max = 20) String adresse,
			int numTel, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		Adresse = adresse;
		NumTel = numTel;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}
	
	

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Date dateNaissance, @NotBlank @Size(max = 20) String adresse,
			int numTel, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		Adresse = adresse;
		NumTel = numTel;
		this.roles = roles;
	}
	
	

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Date dateNaissance, @NotBlank @Size(max = 20) String adresse,
			int numTel, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		Adresse = adresse;
		NumTel = numTel;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}
	
	

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Date dateNaissance, @NotBlank @Size(max = 20) String adresse,
			int numTel) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		Adresse = adresse;
		NumTel = numTel;
	}
	
	

	
	

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Date dateNaissance, @NotBlank @Size(max = 20) String adresse,
			int numTel, Boolean etatAcc, boolean enabled, String img, Set<Role> roles, Set<ImageUser> images) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		Adresse = adresse;
		NumTel = numTel;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.img = img;
		this.roles = roles;
		Images = images;
	}
	
	

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Date dateNaissance, @NotBlank @Size(max = 20) String adresse,
			int numTel, String img, Set<Role> roles, Set<ImageUser> images) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		Adresse = adresse;
		NumTel = numTel;
		this.img = img;
		this.roles = roles;
		Images = images;
	}
	
	

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Date dateNaissance, @NotBlank @Size(max = 20) String adresse,
			int numTel, Boolean etatAcc, boolean enabled, String img, Set<Role> roles, Set<ImageUser> images) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		Adresse = adresse;
		NumTel = numTel;
		EtatAcc = etatAcc;
		this.enabled = enabled;
		this.img = img;
		this.roles = roles;
		Images = images;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", dateNaissance=" + dateNaissance + ", Adresse=" + Adresse + ", NumTel=" + NumTel + ", EtatAcc="
				+ EtatAcc + ", enabled=" + enabled + ", img=" + img + ", roles=" + roles + ", Images=" + Images + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Boolean getEtatAcc() {
		return EtatAcc;
	}

	public void setEtatAcc(Boolean etatAcc) {
		EtatAcc = etatAcc;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public int getNumTel() {
		return NumTel;
	}

	public void setNumTel(int numTel) {
		NumTel = numTel;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Set<ImageUser> getImages() {
		return Images;
	}

	public void setImages(Set<ImageUser> images) {
		Images = images;
	}
	
	

}
