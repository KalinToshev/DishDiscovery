package com.app.DishDiscovery.services.userDetails;

import com.app.DishDiscovery.models.entities.UserEntity;
import com.app.DishDiscovery.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userService.getUserEntityByUsername(username);

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRoles().stream()
                        .map(roleEntity -> new SimpleGrantedAuthority("ROLE_" + roleEntity.getRole().name()))
                        .collect(Collectors.toList())
        );
    }
}
