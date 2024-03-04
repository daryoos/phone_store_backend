package com.is.phonestore.repository;

import com.is.phonestore.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    @Query(value = "select usr from User usr where usr.userId = :userId ")
    User findUserByUserId(@Param("userId") Long userId);

    User findByEmailOrUsername(String email,String username);

    @Query(value = "select usr from User usr where usr.username = :username and usr.password = :password")
    User checkUserLoginCredentials(@Param(value = "username") String username,@Param(value = "password") String password);
}
