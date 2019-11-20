package de.kruemelnerd.todo.backend.security.user;

import de.kruemelnerd.todo.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    Boolean existsByUsername(String username);
}
