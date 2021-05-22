package com.AndysTestProjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class higherLowerGUI extends JFrame {
    private JPanel mainPanel;
    private JButton newGameButton;
    private JButton exitButton;
    Deck deck = new Deck();

    public higherLowerGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Game game = new Game();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
