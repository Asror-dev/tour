package org.example.tour.loaders;


import lombok.RequiredArgsConstructor;

import org.example.tour.entity.Role;
import org.example.tour.entity.User;
import org.example.tour.repository.RoleRepo;
import org.example.tour.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Loader implements CommandLineRunner {

    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;


    @Override
    public void run(String... args) {
        List<Role> all = roleRepo.findAll();
        if (all.isEmpty()) {
            List<Role> roles = List.of(

                    Role.builder()
                            .name("ROLE_ADMIN")
                            .build(),
                    Role.builder()
                            .name("ROLE_USER")
                            .build()
            );
            roleRepo.saveAll(roles);
            Role roleAdmin = roleRepo.findByName("ROLE_ADMIN").orElseThrow();
            createUser(roleAdmin);

        }

    }

    private void createUser(Role role) {
        User user = new User();
        user.setPhone("998914449192");
        user.setFirstName("Asror");
        user.setLastName("Sattorov");
        user.setPassword(passwordEncoder.encode("0100"));
        user.setRoles(List.of(role));
        userRepo.save(user);
    }

}
