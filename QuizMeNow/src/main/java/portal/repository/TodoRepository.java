package portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import portal.domain.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
    List<Todo> findByTask(String task);    
    List<Todo> findByDescription(String description);
    Todo findById(int id);
}