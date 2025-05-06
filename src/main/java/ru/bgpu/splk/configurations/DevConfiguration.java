package ru.bgpu.splk.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bgpu.splk.models.Group;
import ru.bgpu.splk.models.User;
import ru.bgpu.splk.services.GroupService;
import ru.bgpu.splk.services.UserService;

import java.util.Collections;
import java.util.Random;


@Configuration
public class DevConfiguration {

    @Autowired private UserService userService;
    @Autowired private GroupService groupService;

    private String[] names ={"John", "Alex", "Stepan", "Anton", "Ivan"};
    private String[] surnames ={"Johnson", "Alexson", "Stepson"};

    @Bean
    public CommandLineRunner init() {
        return (arg) -> {
            Random random = new Random();
            for(int i = 0; i < random.nextInt(10)+10; i++) {
                userService.save(new User(
                        names[random.nextInt(names.length)],
                        surnames[random.nextInt(surnames.length)],
                        "+7 800 555 3535"
                ));
            }

            // The Almighty
            Group adminGroup = new Group();
            adminGroup.setName("ADMIN");
            groupService.save(adminGroup);
            
            // The nerdy
            Group technicianGroup = new Group ();
            technicianGroup.setName("TECH");
            groupService.save (technicianGroup);

            User admin = new User("Anton", "Antonowicz", "+7 910 203 2911");
            admin.setGroups(Collections.singletonList(adminGroup));
            
            User tech  = new User("Sergiusz", "Morawecki", "+7 192 129 1974");
            tech.setGroups(Collections.singletonList(technicianGroup));

            userService.save(admin);
            userService.save(tech);
        };
    }
}