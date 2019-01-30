package portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import portal.domain.Organizer;
import portal.domain.OrganizerUser;

public interface OrganizerRepository extends CrudRepository<Organizer, Integer> {
	List<Organizer> findByOwner(OrganizerUser o);
}