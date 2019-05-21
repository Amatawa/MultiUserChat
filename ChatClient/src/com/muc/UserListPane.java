package com.muc;

import javax.swing.*;
import java.awt.*;

public class UserListPane extends JPanel {
    public UserListPane(ChatClient client) {
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 8818);

        UserListPane userListPane = new UserListPane(client);
        JFrame frame = new JFrame("User List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        frame.getContentPane().add(new JScrollPane(userListPane), BorderLayout.CENTER);
        frame.setVisible(true);


    }
}
