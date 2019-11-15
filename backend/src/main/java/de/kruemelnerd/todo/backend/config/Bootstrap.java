package de.kruemelnerd.todo.backend.config;

import de.kruemelnerd.todo.backend.model.User;
import de.kruemelnerd.todo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Bootstrap(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        if (this.userRepository.count() == 0) {
            final User user = new User();
            user.setUsername("test");
            user.setPassword(this.passwordEncoder.encode("test"));
            this.userRepository.save(user);
        }
    }

}