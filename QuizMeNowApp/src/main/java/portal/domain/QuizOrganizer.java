package portal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


 //An quiz organizer contains and manages a list of quizs.
 
@Entity(name="organizers")
public class QuizOrganizer {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<Quiz> quizs;
	
	@ManyToOne(optional=false,cascade=CascadeType.PERSIST)
	private QuizUser owner;
	
	public QuizOrganizer() {
		quizs = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public QuizUser getOwner() {
		return owner;
	}

	public void setOwner(QuizUser owner) {
		this.owner = owner;
	}

	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}

	/**
	 * retrieve all quizs
	 * 
	 * @return list of quizs
	 */
	public List<Quiz> getQuizs() {
		return quizs;
	}

	/**
	 * adds a quiz to the list
	 * 
	 * @param t
	 */
	public void addQuiz(Quiz t) {
		quizs.add(t);
	}



	/**
	 * Deletes a the quiz for a given id.
	 * 
	 * @param id
	 */
	public void deleteQuiz(int id) {
		quizs.removeIf(t -> t.getId() == id);
	}
}