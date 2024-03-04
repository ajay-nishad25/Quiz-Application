import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rules extends JFrame implements ActionListener {
    String name;
    JButton start, back;
    Rules(String text){

        this.name = text;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+name+ " to Programming Quiz");
        heading.setBounds(20,20,300,45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD,18 ));
        add(heading);
        
        JLabel rulesList = new JLabel();
        rulesList.setBounds(50,70,900,350);
        rulesList.setFont(new Font("Mongolian Baiti", Font.BOLD,16 ));

        rulesList.setText(
            "<html>"+ 
                "1. No semicolons; only winks . (Just kidding, please use semicolons!)" + "<br><br>" +
                "2. Coffee is mandatory fuel. One line of code per cup required. (Maybe replace with a real rule about breaks or hydration.)" + "<br><br>" +
                "3. Rubber duck debugging is mandatory. Explain your code to an inanimate object for clarity." + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Naming variables after your favorite foods is encouraged. Spaghetti for strings, anyone?" + "<br><br>" +
                "6. Every class must have a main method that prints a dad joke. A little humor goes a long way." + "<br><br>" +
                "7. Use System.out.println(\"I'm giving it my all!\") for every loop iteration. Motivate them even when the code gets tough." + "<br><br>" +
                "8. Compiling errors are just the universe testing your patience. Encourage perseverance in the face of challenges" + "<br><br>" +
            "<html>"
        );

        add(rulesList);


        start =  new JButton("Start");
        start.setBounds(1050,500,120, 25);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        back =  new JButton("Back");
        back.setBounds(20,500,120, 25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);




        setSize(1200,800);
        setLocation(170,110);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            new Login();
            dispose();
        }else if(e.getSource() == start){
            setVisible(false);
            new Quiz(name);
            dispose();
        }
    }


    public static void main(String[] args) {
        
        new Rules("User");


    }

}
