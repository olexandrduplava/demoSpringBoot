package com.demoSrping.demoSpring.repository;

import com.demoSrping.demoSpring.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String role_name);

}