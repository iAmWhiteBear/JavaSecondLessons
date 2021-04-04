package Lesson7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class ClientHandler {
    private final Socket socket;
    private final MultiServer server;
    private DataInputStream input;
    private DataOutputStream output;
    private String userName;
    private int countDown = 0;
    private final int TIMEOUT = 120;
    private boolean authorized = false;
    private boolean streamController = true;


    public ClientHandler(Socket clientSocket, MultiServer multiServer) {
        this.socket = clientSocket;
        this.server = multiServer;
        try {
            this.input = new DataInputStream(socket.getInputStream());
            this.output = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                getTimer().start();
                runHandler();
                receiveMessage();
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean doAuthentication(){
        try {
            String authorisation = input.readUTF();
            if (authorisation.startsWith("-auth")) {
                //разделение тэга, логина и паролья
                String[] inputLine = authorisation.split("\\s");
                //поиск указанного пользвателя
                Optional<User> user = Authentication.findUserByLoginPassword(inputLine[1], inputLine[2]);
                if (user.isPresent()) {
                    userName = user.get().getName();
                    authorized = true;
                    return true;
                } else sendMessage("this login/password not found");
            } else {
                sendMessage("should starts with -auth");
            }
        } catch (ArrayIndexOutOfBoundsException oob){
            sendMessage("there is must be login and password after -auth");
        } catch (IOException e) {
            throw new RuntimeException(socket + " timeout disconnect");
        }

        return false;
    }

    private void runHandler(){
        sendMessage("please log in by: -auth login password");
        while (streamController){
            //авторизация
            if (doAuthentication()){
                //исключения дублирования захода
                if (!server.isLoggedIn(userName)){
                    server.logInUser(this);
                    sendMessage(String.format("welcome! %s",userName));
                    server.broadcast(String.format("%s join to chat", userName));
                    return;
                }else {
                    sendMessage("this user is already logged in");
                }
            } else {
                sendMessage("incorrect authorisation");
            }
        }
    }

    public void sendMessage(String message) {
        try {
            output.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(socket + " timeout disconnect");
        }
    }

    public void receiveMessage(){
        while (streamController){
            try {
                String messageRaw = input.readUTF();
                //обработка отправки личных сообщений
                if (messageRaw.startsWith("/w")){
                    //отделение тэга и имени пользователя от основного сообщения
                    String[] messageSep = messageRaw.split("\\s");
                    //сборка сообщения заново, там наверняка были ещё пробелы
                    String message = Arrays.stream(messageSep)
                            .skip(2)
                            .collect(Collectors.joining(" "));
                    if (server.isLoggedIn(messageSep[1])){
                        //отправка личного сообщения, копия сообщения себе.
                        server.whisper(messageSep[1],String.format("private %s: %s",userName, message));
                        sendMessage(String.format("private %s: %s",messageSep[1], message));
                    }
                }else
                    // отправка простого сообщения
                    server.broadcast(String.format("%s: %s", userName, messageRaw));
            } catch (IOException e) {
                //процедура потери связи с клиентом
                server.logOutUser(this);
                server.broadcast(userName+" disconnected");
                //думаю что именно тут e.printStackTrace(); будет лишним
                break;
            }
        }
    }

    public String getUsername() {
        return userName;
    }

    //таймер для автоматического прерывания сессии
    private Thread getTimer(){
        return new Thread(() ->{
            while (countDown<TIMEOUT && !authorized) {
                try {
                    Thread.sleep(1000);
                    countDown++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //отключение соединения по завершению таймера,
            //если пользователь так и не авторизировался
            if (!authorized){
                try {
                    sendMessage("вы не авторизировались и будете отключены от сервера");
                    streamController = false;
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
