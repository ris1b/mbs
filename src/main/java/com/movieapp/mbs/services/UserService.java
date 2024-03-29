package com.movieapp.mbs.services;

import com.movieapp.mbs.models.User;
import com.movieapp.mbs.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User createUser(String username, String password) {
        User user = new User(username, password);

        return userRepository.save(user);
    }
}
