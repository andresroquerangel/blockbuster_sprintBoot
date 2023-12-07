package com.example.modeladov1.security;

import com.example.modeladov1.model.Usuario;
import com.example.modeladov1.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByEmail(email)
                .orElseThrow(() -> {
                    logger.error("Unauthorized error "+email+" no existe: {}", UsernameNotFoundException.class.getName());
                    return new UsernameNotFoundException("El usuario con email "+email+" no existe.");
                });
        return new UserDetailsImpl(usuario);
    }

}