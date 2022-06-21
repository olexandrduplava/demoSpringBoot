package com.demoSrping.demoSpring.repository;

import com.demoSrping.demoSpring.entity.auth.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {

    UserAuth findByUsername(String username);

}
