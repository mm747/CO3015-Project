package portal.repository;

import org.springframework.data.repository.CrudRepository;

import portal.domain.QuizUser;

public interface UserRepository extends CrudRepository<QuizUser, Integer> {
	QuizUser findById(int id);
	QuizUser findByLogin(String login);
	QuizUser findByFname(String fname);
}