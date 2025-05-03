package ru.bgpu.splk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bgpu.splk.repositories.UserRepository;

import java.util.logging.Logger;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    @Autowired private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername: " + username);
        return userRepository.findOneByLogin(username);
    }
}
