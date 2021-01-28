package com.example.BotCreator.repositories;

import com.example.BotCreator.domain.BotInfo;
import com.example.BotCreator.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BotInfoRepo extends CrudRepository<BotInfo, Long> {
    BotInfo findByBotname(@Param("botname")String botname);
}
