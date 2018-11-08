package portal.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import portal.domain.UserInfo;

@Entity
@Table(name="role")
public class Role {
	@Id
	private int id;
	@Column(nullable=false)
	private String role;
	
	public Role() {} 
	
	public Role(int id,String role) {
		this.id=id;
		this.role=role;
	}
	
	@OneToMany(mappedBy="role")
	private Set<UserInfo> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}
	
	
}