package ru.sobse.spring_boot_authorization.service;

import ru.sobse.spring_boot_authorization.exeption.InvalidCredentials;
import ru.sobse.spring_boot_authorization.exeption.UnauthorizedUser;
import org.springframework.stereotype.Service;
import ru.sobse.spring_boot_authorization.model.User;
import ru.sobse.spring_boot_authorization.repository.Authorities;
import ru.sobse.spring_boot_authorization.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
