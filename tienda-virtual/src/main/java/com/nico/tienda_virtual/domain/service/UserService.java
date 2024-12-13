package com.nico.tienda_virtual.domain.service;

import com.nico.tienda_virtual.domain.dto.User;
import com.nico.tienda_virtual.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int userId) {
        return userRepository.getUser(userId);
    }

    public Optional<User> save(User user) {
        return userRepository.save(user);
    }

    public Boolean delete(int userId) {
        return userRepository.getUser(userId).map(user -> {
            userRepository.delete(userId);
            return true;
        }).orElse(false);
    }
}
