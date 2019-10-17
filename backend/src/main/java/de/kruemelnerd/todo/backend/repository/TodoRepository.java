package de.kruemelnerd.todo.backend.repository;

import de.kruemelnerd.todo.backend.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
