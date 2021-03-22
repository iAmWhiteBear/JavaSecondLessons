package Lesson4;

import javax.swing.*;

public class ChatApp {
    public static void main(String[] args) {
        JFrame frame = getChatFrame();
    }

    private static JFrame getChatFrame() {
        JFrame frame = new JFrame("MyChat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChatWindowPanel());
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
