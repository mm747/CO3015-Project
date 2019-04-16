package portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import portal.domain.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    List<Quiz> findByquizName(String quizName);    
    List<Quiz> findByDescription(String description);
    Quiz findById(int id);
}