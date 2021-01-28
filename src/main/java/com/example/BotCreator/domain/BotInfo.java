package com.example.BotCreator.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;

@Entity
public class BotInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String botname;
    private String BOT_TOKEN;
    private String bot_description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBotname() {
        return botname;
    }

    public void setBotname(String botname) {
        this.botname = botname;
    }

    public String getBOT_TOKEN() {
        return BOT_TOKEN;
    }

    public void setBOT_TOKEN(String BOT_TOKEN) {
        this.BOT_TOKEN = BOT_TOKEN;
    }


    public String getBot_description() {
        return bot_description;
    }

    public void setBot_description(String bot_description) {
        this.bot_description = bot_description;
    }

    public BotInfo(Long id, String botname, String BOT_TOKEN, String bot_description) {
        this.id = id;
        this.botname = botname;
        this.BOT_TOKEN = BOT_TOKEN;
        this.bot_description = bot_description;
    }
}
