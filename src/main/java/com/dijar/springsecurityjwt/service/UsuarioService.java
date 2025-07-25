package com.dijar.springsecurityjwt.service;

import java.util.List;
import java.util.Optional;

import com.dijar.springsecurityjwt.entity.Usuario;


public interface UsuarioService {

    Usuario save(Usuario usuario);

    Usuario findByIdUsuario(Long idUsuario);

    Usuario update(Usuario usuario);

    void delete(Long idUsuario);

    List<Usuario> findAllUsuarios();

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);

}
