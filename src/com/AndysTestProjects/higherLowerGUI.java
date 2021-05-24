package com.AndysTestProjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class higherLowerGUI extends JFrame {
    private JPanel mainPanel;
    private JButton newGameButton;
    private JButton exitButton;
    private JLabel scoreLabel;
    private JButton lowerButton;
    private JButton higherButton;
    private JLabel playCardLabel;
    private JLabel drawnCardLabel;
    private JLabel resultLabel;

    public higherLowerGUI(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        Game game = new Game();
        higherButton.setEnabled(false);
        lowerButton.setEnabled(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.deck.shuffle();
                scoreLabel.setText(String.valueOf(game.score));
                playCardLabel.setText(game.play.toString());
                drawnCardLabel.setText("");
                higherButton.setEnabled(true);
                lowerButton.setEnabled(true);
            }
        });
        higherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawnCardLabel.setText(String.valueOf(game.drawn));
                if (game.higherGuess() == true){
                    game.score++;
                    scoreLabel.setText(String.valueOf(game.score));
                    game.play = game.drawn;
                    game.drawn = game.deck.drawCard();
                    playCardLabel.setText(game.play.toString());
                } else {
                    game.score = 0;
                    scoreLabel.setText(String.valueOf(game.score));
                    higherButton.setEnabled(false);
                    lowerButton.setEnabled(false);
                }
            }
        });
        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawnCardLabel.setText(String.valueOf(game.drawn));
                if (game.lowerGuess() == true){
                    game.score++;
                    scoreLabel.setText(String.valueOf(game.score));
                    game.play = game.drawn;
                    game.drawn = game.deck.drawCard();
                    playCardLabel.setText(game.play.toString());
                } else {
                    game.score = 0;
                    scoreLabel.setText(String.valueOf(game.score));
                    higherButton.setEnabled(false);
                    lowerButton.setEnabled(false);
                }
            }
        });
    }
}
