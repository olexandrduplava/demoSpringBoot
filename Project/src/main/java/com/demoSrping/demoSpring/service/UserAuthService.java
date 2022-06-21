package com.demoSrping.demoSpring.service;

import com.demoSrping.demoSpring.entity.auth.Role;
import com.demoSrping.demoSpring.entity.auth.UserAuth;

import java.util.List;

public interface UserAuthService {
    UserAuth saveUserAuth(UserAuth userAuth);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    UserAuth getUserAuth(String username);
    List<UserAuth> getUsers();
}
