package portal.repository;

import org.springframework.data.repository.CrudRepository;

import portal.domain.OrganizerUser;

public interface UserRepository extends CrudRepository<OrganizerUser, Integer> {
	OrganizerUser findById(int id);
    OrganizerUser findByLogin(String login);
}