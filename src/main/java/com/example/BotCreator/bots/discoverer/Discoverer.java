package com.example.BotCreator.bots.discoverer;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

 public class Discoverer {
     public static void main(String[] args) {
       ApiContextInitializer.init();
       TelegramBotsApi Botapi=new TelegramBotsApi();
   try {
       Botapi.registerBot(new TelegramLongPollingBot() { 
           public static final String TOKEN = "1490083571:AAFl435QRXdmFrn1wfKb0IYmrDad2-EqTQ4";
           public static final String USERNAME = "first_bot_of_creator_bot";
           @Override
           public String getBotToken() {
               return TOKEN;
           }
           @Override
           public void onUpdateReceived(Update update) {
               if (update.hasMessage() && update.getMessage().hasText()) {
                   long chat_id = update.getMessage().getChatId();
                   String message_text = update.getMessage().getText();
                   String answer = message_text;
                   SendMessage mes = new SendMessage()
                   .setText(answer)
                   .setChatId(chat_id);
               try {
                   execute(mes);
               } catch (TelegramApiException e) {
                   e.printStackTrace();
               }
           }
           }
           @Override
           public String getBotUsername() {
               return USERNAME;
           }
           });
    } catch (TelegramApiRequestException e) {
      e.printStackTrace();
}}
}
