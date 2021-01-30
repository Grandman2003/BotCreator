package com.example.BotCreator.system;


public class Bot {
     String BOT_TOKEN;
     String script;
     String BOT_NAME;

    public Bot(String BOT_TOKEN,String BOT_NAME,String script) {
        this.BOT_TOKEN =BOT_TOKEN;
        this.script=script;
        this.BOT_NAME=BOT_NAME;
    }

    public String getBOT_TOKEN() {
        return BOT_TOKEN;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getBOT_NAME() {
        return BOT_NAME;
    }

    public void setBOT_NAME(String BOT_NAME) {
        this.BOT_NAME = BOT_NAME;
    }
}
