package com.demoSrping.demoSpring;

import com.demoSrping.demoSpring.entity.auth.Role;
import com.demoSrping.demoSpring.entity.auth.UserAuth;
import com.demoSrping.demoSpring.service.UserAuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserAuthService userAuthService){
		return args -> {
			userAuthService.saveRole(new Role(null, "ROLE_USER"));
			userAuthService.saveRole(new Role(null, "ROLE_MANAGER"));
			userAuthService.saveRole(new Role(null, "ROLE_ADMIN"));
			userAuthService.saveRole(new Role(null, "ROLE_USER_SUPER_ADMIN"));

			userAuthService.saveUserAuth(new UserAuth(null, "name1", "username1", "password1", new ArrayList<>()));
			userAuthService.saveUserAuth(new UserAuth(null, "name2", "username2", "password2", new ArrayList<>()));
			userAuthService.saveUserAuth(new UserAuth(null, "name3", "username3", "password3", new ArrayList<>()));
			userAuthService.saveUserAuth(new UserAuth(null, "name4", "username4", "password4", new ArrayList<>()));

			userAuthService.addRoleToUser("username1", "ROLE_USER");
			userAuthService.addRoleToUser("username2", "ROLE_MANAGER");
			userAuthService.addRoleToUser("username3", "ROLE_ADMIN");
			userAuthService.addRoleToUser("username4", "ROLE_USER_SUPER_ADMIN");

		};
	}

}
