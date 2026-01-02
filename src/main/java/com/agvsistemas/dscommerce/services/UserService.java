package com.agvsistemas.dscommerce.services;

import com.agvsistemas.dscommerce.entities.Role;
import com.agvsistemas.dscommerce.entities.User;
import com.agvsistemas.dscommerce.projections.UserDetailsProjection;
import com.agvsistemas.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var dataset = repository.searchUserWithRolesByEmail(username);
        if (dataset.isEmpty()) {
            throw new UsernameNotFoundException("User not found.");
        }
        User user = new User();
        user.setEmail(username);
        user.setPassword(dataset.getFirst().getPassword());

        for (UserDetailsProjection projection : dataset) {
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }
        return user;
    }

}
