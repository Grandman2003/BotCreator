package com.example.BotCreator.repositories;


import com.example.BotCreator.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    @NonNull
    Optional<User> findById(@Param("id")@NonNull Long id);
    User findByFirstname(@Param("first_name")String first_name);
    User findByUSERTOKEN(@Param("USER_TOKEN")String TOKEN);
}
