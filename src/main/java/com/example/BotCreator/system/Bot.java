package com.example.BotCreator.system;


public class Bot {
     final String USERTOKEN;
     String script;
     String BOT_NAME;

    public Bot(String USERTOKEN,String BOT_NAME,String script) {
        this.USERTOKEN =USERTOKEN;
        this.script=script;
        this.BOT_NAME=BOT_NAME;
    }

    public String getUSERTOKEN() {
        return USERTOKEN;
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
