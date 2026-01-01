package com.agvsistemas.dscommerce.repositories;

import com.agvsistemas.dscommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT obj FROM User obj JOIN FETCH obj.roles WHERE obj.email = :email")
    User searchUserWithRolesByEmail(String email);

}
