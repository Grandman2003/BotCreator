package com.example.BotCreator.system;

public class QueryInfo {
    public String function;
    public String filetype;
    public String GsonData;

    public QueryInfo(String function, String filetype, String gsonData) {
        this.function = function;
        this.filetype = filetype;
        GsonData = gsonData;
    }
}
