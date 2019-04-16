package portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


 //A quiz is an action item with a quiz name, a description, and a number of questions
 
@Entity(name = "quizs")
public class Quiz {

	
	//a unique identifier for the quiz
	 
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	@Column(nullable=false)
	private String quizName;
	private String description;
	private int priority = 0;

	private boolean important;


	/**
	 * Creates a new Quiz with the task and description
	 * 
	 * @param quizName       the name of the quiz
	 * @param description the description of the task
	 */
	public Quiz(String quizName, String description) {
		this.quizName = quizName;
		this.description = description;
	}

	
	//default constructor
	 
	public Quiz() {
	}

	public String getquizName() {
		return quizName;
	}

	public void setquizName(String quizName) {
		this.quizName = quizName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int newPrio) {
		if (priority <= newPrio) {
			this.priority = newPrio;
		} else {
			throw new RuntimeException("Cannot reduce priority!");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}


}