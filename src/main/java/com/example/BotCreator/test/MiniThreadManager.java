package com.example.BotCreator.test;


import java.util.ArrayList;

public class MiniThreadManager {
    static MiniThreadManager manager;
    public static  MiniThreadManager newInstance() {
        manager=new MiniThreadManager();
        return manager;
    }
    public static MiniThreadManager getInstance(){
        if(manager==null){
            return MiniThreadManager.getInstance();
        }else{
            return manager;
        }
    }

}
