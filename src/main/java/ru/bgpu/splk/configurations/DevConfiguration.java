package ru.bgpu.splk.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import ru.bgpu.splk.models.User;
import ru.bgpu.splk.services.UserService;

import java.util.Random;


@Configuration
public class DevConfiguration {

    @Autowired private UserService userService;

    private String[] names ={"John", "Alex", "Stepan", "Anton", "Ivan"};
    private String[] surnames ={"Johnson", "Alexson", "Stepson"};

    @Bean
    public CommandLineRunner init() {
        return (arg) -> {
            Random random = new Random();
            for(int i = 0; i < random.nextInt(10)+10; i++) {
                userService.save(new User(
                        names[random.nextInt(names.length)],
                        surnames[random.nextInt(surnames.length)]
                ));
            }

            User admin = new User();
            admin.setLogin("admin");
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            admin.setPassword(encoder.encode("admin"));

            userService.save(admin);
        };
    }
}
