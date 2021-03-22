package Lesson4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatWindowPanel extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";

    public ChatWindowPanel() {
        super(new GridBagLayout());

        //текстовое поле, куда писать
        textField = new JTextField(40);
        textField.addActionListener(this);

        textArea = new JTextArea(15, 40);
        textArea.setEditable(false);
        textArea.setBackground(new Color(255,241,207));
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Добавление компонентов на панель
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
        add(scrollPane, c);
    }

    //добавление текста в чат
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textArea.append(text + newline);
        textField.setText("");
    }
}