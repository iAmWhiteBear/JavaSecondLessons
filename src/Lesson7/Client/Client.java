package Lesson7.Client;

import Lesson7.GUI.ChatFrame;

class Client {
    private final ChatFrame morda;
    private final ClientConnection connection;
    public Client() {
        connection = new ClientConnection();
        //подключение графики и отправка сообщений
        morda = new ChatFrame(connection::sendMessage);

        new Thread(() ->{
            String message;
            while (true){
                //приём сообщений
                message = connection.receiveMessage();
                if (message.split("\\s").length>1){
                    morda.getChatConsumer().accept(message);
                }
            }
        }).start();
    }
}
