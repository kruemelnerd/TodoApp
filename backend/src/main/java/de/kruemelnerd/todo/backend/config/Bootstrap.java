package de.kruemelnerd.todo.backend.config;

import com.sun.tools.classfile.Opcode;
import de.kruemelnerd.todo.backend.model.ERole;
import de.kruemelnerd.todo.backend.model.Role;
import de.kruemelnerd.todo.backend.model.User;
import de.kruemelnerd.todo.backend.repository.RoleRepository;
import de.kruemelnerd.todo.backend.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RoleRepository roleRepository;

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
            Set<Role> roles = Stream.of(new Role(ERole.ROLE_USER)).collect(Collectors.toSet());
            user.setRoles(roles);
            this.userRepository.save(user);
        }

        if(this.roleRepository.count() == 0){
            final Role user_role = new Role(ERole.ROLE_USER);
            this.roleRepository.save(user_role);
            final Role admin_role = new Role(ERole.ROLE_ADMIN);
            this.roleRepository.save(admin_role);
            final Role mod_role = new Role(ERole.ROLE_MODERATOR);
            this.roleRepository.save(mod_role);
        }
    }

}