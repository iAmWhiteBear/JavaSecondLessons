package Lesson6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() {
        {
            try {
                System.out.println("waiting for connection");
                // ожидание подключения на порту 8080.
                Socket socket = new ServerSocket(8080).accept();
                System.out.println("client connected");
                Scanner scanner = new Scanner(System.in);
                // стрим для отправки данных
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                // новый поток, что бы входящие и исходящие данных были независимы и один другого не ждал
                new Thread(() -> {
                    try {
                        //создаю стрим для получения данных
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        while (true) {
                            System.out.printf("%s %n", in.readUTF());    //ожидание данных и последующий их вывод.
                        }
                    } catch (IOException e) {
                        System.out.printf("connection %s ended%n", socket);
                        System.out.println("press enter to close");
                    }
                }).start();
                while (true) {
                    //ожидание данных для отправки и немедленная их отправка
                    out.writeUTF(scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println("connection closed");
            }
        }
    }
}
