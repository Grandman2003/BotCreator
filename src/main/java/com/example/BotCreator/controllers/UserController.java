package com.example.BotCreator.controllers;

import com.example.BotCreator.domain.BotInfo;
import com.example.BotCreator.domain.User;
import com.example.BotCreator.domain.UserInfo;
import com.example.BotCreator.repositories.BotInfoRepo;
import com.example.BotCreator.repositories.UserRepo;
import com.example.BotCreator.system.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    public User addUser(@RequestBody UserInfo userInfo) {
        User userFromDb = userRepo.findByUSERTOKEN(userInfo.getToken());
        if (userFromDb == null) {
            User user = new User(userInfo);
            userRepo.save(user);
            return user;
        }
        return null;
    }

    @GetMapping
    public Iterable<User> list() {
        //if(secret_key.equals("O BOZHECHKY")){
        return userRepo.findAll();//}
        // return null;
    }
    @GetMapping("/{token}")
    public User getUser(@PathVariable String token){
        return userRepo.findByUSERTOKEN(token);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody UserInfo info) {
        User user = userRepo.findByFirstname(info.getFirst_name());
        userRepo.delete(user);
    }

    @PostMapping("/addBot")
    public static void addBot(@RequestBody Bot bot) {
        File dir = new File("E:\\Gena\\BotCreator\\src\\main\\java\\com\\example\\BotCreator\\bots\\" + bot.getBOT_NAME().toLowerCase());
        dir.mkdir();
        File file = new File(dir + "\\" + bot.getBOT_NAME() + ".java");
        try {
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(new FileWriter(file));
                writer.write("package com.example.BotCreator.bots." + bot.getBOT_NAME().toLowerCase() + ";\n\n" +

                        "import org.telegram.telegrambots.ApiContextInitializer;\n" +
                        "import org.telegram.telegrambots.bots.TelegramLongPollingBot;\n" +
                        "import org.telegram.telegrambots.meta.TelegramBotsApi;\n" +
                        "import org.telegram.telegrambots.meta.api.methods.send.SendMessage;\n" +
                        "import org.telegram.telegrambots.meta.api.objects.Update;\n" +
                        "import org.telegram.telegrambots.meta.exceptions.TelegramApiException;\n" +
                        "import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;\n\n" +

                        " public class " + bot.getBOT_NAME() + " {\n" +
                        "     public static void main(String[] args) {\n" +
                        "       ApiContextInitializer.init();\n" +
                        "       TelegramBotsApi Botapi=new TelegramBotsApi();\n" +

                        "   try {\n" +
                        "       Botapi.registerBot(new TelegramLongPollingBot() { \n" +
                        "           public static final String TOKEN = \"1490083571:AAFl435QRXdmFrn1wfKb0IYmrDad2-EqTQ4\";\n" +
                        "           public static final String USERNAME = \"first_bot_of_creator_bot\";\n" +

                        "           @Override\n" +
                        "           public String getBotToken() {\n" +
                        "               return TOKEN;\n" +
                        "           }\n" +

                        "           @Override\n" +
                        "           public void onUpdateReceived(Update update) {\n" +
                        "               if (update.hasMessage() && update.getMessage().hasText()) {\n" +
                        "                   long chat_id = update.getMessage().getChatId();\n" +
                        "                   String message_text = update.getMessage().getText();\n" +
                        "                   String answer = message_text;\n" +
                        "                   SendMessage mes = new SendMessage()\n" +
                        "                   .setText(answer)\n" +
                        "                   .setChatId(chat_id);\n" +
                        "               try {\n" +
                        "                   execute(mes);\n" +
                        "               } catch (TelegramApiException e) {\n" +
                        "                   e.printStackTrace();\n" +
                        "               }\n" +
                        "           }\n" +
                        "           }\n" +

                        "           @Override\n" +
                        "           public String getBotUsername() {\n" +
                        "               return USERNAME;\n" +
                        "           }\n" +
                        "           });\n" +
                        "    } catch (" +
                        "TelegramApiRequestException e) {\n" +
                        "      e.printStackTrace();\n" +
                        "}" +
                        "}\n" +
                        "}\n"
                );
                writer.close();
                String task = "javac -cp \"E:\\Gena\\BotCreator\\libraries\\*\" src\\main\\java\\com\\example\\BotCreator\\bots\\" + bot.getBOT_NAME().toLowerCase() + "\\" + bot.getBOT_NAME() + ".java";
                Process real=Runtime.getRuntime().exec(task);
                real.destroy();
                task=task.replaceFirst("javac","java");
                Process process=Runtime.getRuntime().exec(task);
                //process.destroy();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
