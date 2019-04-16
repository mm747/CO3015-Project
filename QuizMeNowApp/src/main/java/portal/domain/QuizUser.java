package portal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name = "users")
public class QuizUser {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	int id;
	
	@Column(unique = true, nullable = false)
	String login;
	
	@Column(unique = false, nullable = false)
	String fname;

	@Column(unique = false, nullable = false)
	String surname;


	@Column(unique = true, nullable = false)
	String password;

	@Transient
	String password2;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
	
	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL)
	private List<QuizOrganizer> organizers = new ArrayList<QuizOrganizer>();

	public List<QuizOrganizer> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<QuizOrganizer> organizers) {
		this.organizers = organizers;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
