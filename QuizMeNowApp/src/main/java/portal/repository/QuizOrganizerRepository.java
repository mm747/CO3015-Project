package portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import portal.domain.QuizOrganizer;
import portal.domain.QuizUser;

public interface QuizOrganizerRepository extends CrudRepository<QuizOrganizer, Integer> {
	List<QuizOrganizer> findByOwner(QuizUser o);
}