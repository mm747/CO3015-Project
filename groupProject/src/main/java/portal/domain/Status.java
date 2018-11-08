package portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="status")
public class Status {

//	public static int lastId = 0;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="status_id", nullable=false)
    private int id = -1;
	@Column(name="status_name", nullable=false)
    private String name;
	@Column(name="status_description")
    private String description;    
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Status(){}
    
    public Status(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

    @Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

//	public void setId() {
//		this.id = lastId;
//		lastId++;
//	}

}
