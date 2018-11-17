package portal.repository;

import org.springframework.data.repository.CrudRepository;

import portal.domain.*;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	public Role findById(int id);
	public Role findByRole(String Role);
}
