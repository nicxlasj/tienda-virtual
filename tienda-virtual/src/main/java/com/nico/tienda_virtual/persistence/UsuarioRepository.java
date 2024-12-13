package com.nico.tienda_virtual.persistence;

import com.nico.tienda_virtual.domain.dto.User;
import com.nico.tienda_virtual.domain.repository.UserRepository;
import com.nico.tienda_virtual.persistence.crud.UsuarioCrudRepository;
import com.nico.tienda_virtual.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;
    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAll() {
        return mapper.toUsers(usuarioCrudRepository.findAll());
    }

    @Override
    public Optional<User> getUser(int idUsuario) {
        var user = usuarioCrudRepository.findById(idUsuario);
        var user2 = user.map(user3 -> mapper.toUser(user3));
        return user2;

    }

    @Override
    public Optional<User> save(User user) {
        var usuario = mapper.toUsuario(user);
        usuarioCrudRepository.save(usuario);
        return Optional.of(user);
    }
    @Override
    public void delete(int idUsuario) {
        usuarioCrudRepository.deleteById(idUsuario);
    }
}
