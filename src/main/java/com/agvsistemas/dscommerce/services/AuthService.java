package com.agvsistemas.dscommerce.services;

import com.agvsistemas.dscommerce.entities.User;
import com.agvsistemas.dscommerce.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateIsMySelfOrAdmin(Long userId) {
        User mySelf = userService.authenticated();
        if (!mySelf.hasRole("ROLE_ADMIN") && !mySelf.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }
}
