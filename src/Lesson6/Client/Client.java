package Lesson6.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {
            //соединение по адресу 127.0.0.1, на порт 8080 (тот что сервер слушает)
            Socket socket = new Socket("127.0.0.1",8080);
            System.out.println("connection established");
            Scanner scanner = new Scanner(System.in);
            //Стрим для отправки данных
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //новые поток, для приёма данных, что бы получить данные можно было независимо от отправки
            new Thread(()->{
                try {
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    while (true){
                        System.out.println(in.readUTF());
                    }
                } catch (IOException e) {
                    System.out.printf("connection %s ended%n", socket);
                    System.out.println("press enter to close");
                }
            }).start();
            //цикл отправки данных
            while (true){
                out.writeUTF(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("server not found");
        }
    }
}
