package ru.dias.spring1boot.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.dias.spring1boot.entities.User;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
}
