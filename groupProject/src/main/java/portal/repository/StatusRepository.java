package portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import portal.domain.Status;

public interface StatusRepository extends CrudRepository<Status, Integer> {
    Status findById(int id);
    List<Status> findByName(String code);
}