package com.dijar.springsecurityjwt.security.auth;

import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dijar.springsecurityjwt.entity.Usuario;
import com.dijar.springsecurityjwt.security.jwt.JwtService;
import com.dijar.springsecurityjwt.security.userdetails.UserDetailsImpl;
import com.dijar.springsecurityjwt.service.RoleService;
import com.dijar.springsecurityjwt.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;

    public AuthResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        var userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtService.generateToken(userDetails);
        System.out.println("HOLA");

        return new AuthResponse(token);
    }

    public AuthResponse register(RegisterRequest registerRequest) {

        if (usuarioService.existsByUsername(registerRequest.getUsername())) {
            throw new IllegalStateException("Username already exists");
        }

        var role = roleService.findByName("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("Role not found"));

        var user = Usuario.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .nombres(registerRequest.getNombres())
                .apellidos(registerRequest.getApellidos())
                .roles(Set.of(role))
                .build();

        var usuarioGuardado = usuarioService.save(user);
        UserDetails userDetails = new UserDetailsImpl(usuarioGuardado);

        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token);
    }

}

