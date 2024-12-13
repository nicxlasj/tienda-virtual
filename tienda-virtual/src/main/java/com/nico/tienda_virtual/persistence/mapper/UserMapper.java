package com.nico.tienda_virtual.persistence.mapper;

import com.nico.tienda_virtual.domain.dto.User;
import com.nico.tienda_virtual.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombres", target = "names"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "apellidos", target = "lastnames"),
            @Mapping(source = "identificacion", target = "identification"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "password", target = "password")
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "fechaCreacion", ignore = true)
    })
    Usuario toUsuario(User user);
    List<Usuario> toUsuarios(List<User> users);
}
