package com.example.BotCreator.test;

import org.checkerframework.checker.units.qual.Time;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestforTest {

    public static void main(String[] args) {
        //ProcessBuilder builder = new ProcessBuilder("javac -cp src src\\main\\java\\com\\example\\BotCreator\\bots\\Test.java");
        File dir = new File("E:\\Gena\\BotCreator\\src\\main\\java\\com\\example\\BotCreator\\bots\\testBot");
        dir.mkdir();
        File file = new File(dir + "\\TestBotApp.java");
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            writer.write("package com.example.BotCreator.bots.testBot;\n\n" +

                    "import org.telegram.telegrambots.ApiContextInitializer;\n" +
                    "import org.telegram.telegrambots.bots.TelegramLongPollingBot;\n" +
                    "import org.telegram.telegrambots.meta.TelegramBotsApi;\n" +
                    "import org.telegram.telegrambots.meta.api.methods.send.SendMessage;\n" +
                    "import org.telegram.telegrambots.meta.api.objects.Update;\n" +
                    "import org.telegram.telegrambots.meta.exceptions.TelegramApiException;\n" +
                    "import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;\n\n" +

                    " public class TestBotApp {\n" +
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
            String task = "javac -cp \"E:\\Gena\\BotCreator\\libraries\\*\" src\\main\\java\\com\\example\\BotCreator\\bots\\testBot\\TestBotApp.java";
            Process real=Runtime.getRuntime().exec(task);
            real.destroyForcibly();
            task=task.replaceFirst("javac","java");
            final String tasky=task;
           // process.destroy();
            Thread thread = new Thread(new Runnable() {
                final Process process = Runtime.getRuntime().exec(tasky);
                @Override
                public void run() {
                 //   System.out
                    process.destroy();
                    System.out.println(process.isAlive());
                }
            });
            thread.start();
            System.out.println(Thread.activeCount());

          ProcessHandle.allProcesses().forEach(ProcessHandle::destroy);
            ProcessHandle.allProcesses().forEach(processHandle -> System.out.println(processHandle.info().commandLine()));
            System.out.println(ProcessHandle.allProcesses().count());
            //Runtime.getRuntime().
            //Process process = Runtime.getRuntime().exec("javac -cp C:\\Users\\user\\.gradle\\caches\\modules-2\\files-2.1\\org.telegram\\telegrambots-meta\\4.9.1\\6d4968834d78a66aa447ad088a004a23ebad1c74\\telegrambots-meta-4.9.1.jar  C:\\Users\\user\\.gradle\\caches\\modules-2\\files-2.1\\org.telegram\\telegrambots\\4.9.1\\311debf33081ea45ede67a4ebc7dcba79f10b3f4\\telegrambots-4.9.1.jar src\\main\\java\\com\\example\\BotCreator\\bots\\TestBotApp.java");
           /* --Example of execution commands--

            To generate .class file:
            javac -cp "E:\Gena\BotCreator\libraries\*" src\main\java\com\example\BotCreator\bots\TestBotApp.java

            To run generated file:
            java -cp "E:\Gena\BotCreator\libraries\*" src\main\java\com\example\BotCreator\bots\TestBotApp.java

            */
            //catch (IOException | InterruptedException e) {
            //  e.printStackTrace();
            //}
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
