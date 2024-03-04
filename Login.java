
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JButton rules, back;
    JTextField tfName;


    Login(){

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,800,700);
        add(image);

        JLabel heading = new JLabel("Java Programming Quiz");
        heading.setBounds(850,80,300,45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD,18 ));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(850,150,300,20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD,18 ));
        name.setForeground(new Color(30,144,254));
        add(name);

        tfName = new JTextField();
        tfName.setBounds(850,180,150,25);
        tfName.setFont(new Font("Mongolian Baiti", Font.BOLD,18 ));
        add(tfName);

        rules =  new JButton("Proceed");
        rules.setBounds(850,270,120, 25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.WHITE);

        rules.addActionListener(this);

        add(rules);
        
        back =  new JButton("Exit");
        back.setBounds(850,370,120, 25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200,800);
        setLocation(170,110);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == rules){
            String text =  tfName.getText();
            if(text == ""){
                text = "User";
            }
            setVisible(false);
            new Rules(text);

        }else if(e.getSource() == back){
            setVisible(false);
            dispose();
        }
    }

    public static void main(String[] args) {
        // anonymous object
        new Login();


    }
    
}