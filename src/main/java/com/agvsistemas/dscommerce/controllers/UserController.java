package com.agvsistemas.dscommerce.controllers;


import com.agvsistemas.dscommerce.dto.UserDTO;
import com.agvsistemas.dscommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/me")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    public ResponseEntity<UserDTO> findMe() {
        UserDTO dto = userService.getLoggerInUser();
        return ResponseEntity.ok(dto);
    }

}
