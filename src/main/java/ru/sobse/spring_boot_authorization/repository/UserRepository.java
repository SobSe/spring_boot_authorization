package ru.sobse.spring_boot_authorization.repository;

import org.springframework.stereotype.Repository;
import ru.sobse.spring_boot_authorization.model.User;

import javax.naming.Name;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private static Map<User, List<Authorities>> usersAuthorities;

    public UserRepository() {
        usersAuthorities = new ConcurrentHashMap<>();
        usersAuthorities.put(new User("Sergey", "123")
                , Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        usersAuthorities.put(new User("Alexey", "1234")
                , Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return usersAuthorities.get(new User(user, password));
    }
}
