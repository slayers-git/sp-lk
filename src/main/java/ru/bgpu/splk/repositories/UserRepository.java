package ru.bgpu.splk.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.bgpu.splk.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findAll();

    public Optional<User> findOneByName(String name);

    @Query("select u from User u where u.name = ?1")
    public Optional<User> findOneByNameJPQL(String name);

    @Query(value = "select * from users where name = ?1", nativeQuery = true)
    public Optional<User> findOneByNameSQL(String name);

    User findOneByLogin(String login);
}
