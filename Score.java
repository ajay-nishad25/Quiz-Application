import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Score extends JFrame implements ActionListener{

    String username;
    int score;

    JButton again,exit;

    Score(String username, int score){
        this.username = username;
        this.score = score;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Thank you "+username+" for your participation");
        heading.setBounds(480,60,400,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(heading);

        JLabel scoreBoard = new JLabel("Your score is "+score);
        scoreBoard.setBounds(520,200,400,30);
        scoreBoard.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(scoreBoard);


                
        again = new JButton("Play again");
        again.setBounds(340, 250, 200,40);
        again.setFont(new Font("Dialog",Font.PLAIN,18));
        again.setBackground(new Color(30,144,255));
        again.setForeground(Color.WHITE);
        again.addActionListener(this);
        add(again);
        
                
        exit = new JButton("Exit");
        exit.setBounds(640, 250, 200,40);
        exit.setFont(new Font("Dialog",Font.PLAIN,18));
        exit.setBackground(new Color(30,144,255));
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);


        setSize(1200,800);
        setLocation(170,110);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == again){
            setVisible(false);
            dispose();
            new Login();
        }else if(e.getSource() == exit){
            setVisible(false);
            dispose();
        }
    }

    public static void main(String[] args) {
        new Score("", 0);
    }
}
