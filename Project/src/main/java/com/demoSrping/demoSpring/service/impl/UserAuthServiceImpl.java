package com.demoSrping.demoSpring.service.impl;

import com.demoSrping.demoSpring.entity.auth.Role;
import com.demoSrping.demoSpring.entity.auth.UserAuth;
import com.demoSrping.demoSpring.repository.RoleRepo;
import com.demoSrping.demoSpring.repository.UserAuthRepo;
import com.demoSrping.demoSpring.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserAuthServiceImpl implements UserAuthService, UserDetailsService {

    private final UserAuthRepo userAuthRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAuth saveUserAuth(UserAuth userAuth) {
        log.info("Saving new user: {} to database", userAuth);
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        return userAuthRepo.save(userAuth);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role: {} to database", role);
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role:{} to User:{}", roleName, username);
        UserAuth user = userAuthRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserAuth getUserAuth(String username) {
        log.info("Get user from database");
        return userAuthRepo.findByUsername(username);
    }

    @Override
    public List<UserAuth> getUsers() {
        log.info("Get all from database");
        return userAuthRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth user = userAuthRepo.findByUsername(username);
        if(user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        else {
            log.info("User found in the database:{}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
