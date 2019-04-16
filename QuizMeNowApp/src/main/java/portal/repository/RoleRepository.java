package portal.repository;

import org.springframework.data.repository.CrudRepository;

import portal.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findById(int id);
	Role findByRole(String roleName);
}