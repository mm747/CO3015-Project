package portal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name="users")
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	int id;
	
	@Column(unique=true, nullable=false)
	String username;
	@Column(unique=true, nullable=false)
	String password;
	@Transient
	String email;
	String status;
	String password2;
	String forenames;
	String lastnames;
	int age;
	@Transient
	String userType;
	@Column(nullable=false)
	private int enabled = 1;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="role", referencedColumnName="id")
	private Role role;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getForenames() {
		return forenames;
	}
	public void setForenames(String forenames) {
		this.forenames = forenames;
	}
	public String getLastnames() {
		return lastnames;
	}
	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int isEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
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
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", email=" + email + ",password=" + password + ", password2=" + password2 + ", forenames="
				+ forenames + ", lastnames=" + lastnames + ",age=" + age + ", userType=" + userType + ", role=" + role + "]";
	}	
	
}
