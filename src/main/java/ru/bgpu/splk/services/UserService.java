package ru.bgpu.splk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.splk.models.User;
import ru.bgpu.splk.repositories.UserRepository;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
    
    public List<User> listUsers() {
        return userRepository.findAll();
    }
    
    public User getByName (String name) {
    	return userRepository.findOneByName (name).get();
    }
}