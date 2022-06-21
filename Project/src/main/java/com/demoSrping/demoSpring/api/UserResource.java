package com.demoSrping.demoSpring.api;

import com.demoSrping.demoSpring.entity.auth.Role;
import com.demoSrping.demoSpring.entity.auth.UserAuth;
import com.demoSrping.demoSpring.service.UserAuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {

    private final UserAuthService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserAuth>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/{username}")
    private ResponseEntity<UserAuth> getUser(@PathVariable("username") String username)
    {
        UserAuth user = userService.getUserAuth(username);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/user/save")
    private ResponseEntity<UserAuth> saveUser(@RequestBody UserAuth user)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUserAuth(user));
    }

    @PostMapping("/role/save")
    private ResponseEntity<Role> saveRole(@RequestBody Role role)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    private ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserFrom form)
    {
        userService.addRoleToUser(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserFrom{
    private String username;
    private String rolename;
}
