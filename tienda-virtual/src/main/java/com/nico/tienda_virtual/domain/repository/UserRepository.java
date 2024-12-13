package com.nico.tienda_virtual.domain.repository;

import com.nico.tienda_virtual.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll();
    Optional<User> getUser(int userId);
    Optional<User> save(User user);
    void delete(int userId);
}
