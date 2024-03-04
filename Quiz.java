
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Quiz extends JFrame implements ActionListener{

    String questions[][] = new String[10][5];

    String answers[][]  = new String[10][2];

    String userAnswer[][] = new String[10][1];
 
    JLabel questionNo, question;

    JRadioButton option1, option2 ,option3, option4;

    JButton next,lifeLine,submit;

    ButtonGroup grpBtn;

    public static int ans_given = 0;

    public static int timer = 15;

    public static int count = 0;

    public static int score = 0;

    String username;

    Quiz(String username){

        this.username = username;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1200,392);
        add(image);

        questionNo = new JLabel();
        questionNo.setBounds(100,450,50,30);
        questionNo.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(questionNo);

        question = new JLabel();
        question.setBounds(130,450,1000,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(question);


        
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        option1 = new JRadioButton();
        option1.setBounds(160,480,700,30);
        option1.setBackground(Color.WHITE);
        option1.setFont(new Font("Dialog",Font.PLAIN,17));
        add(option1);
        
        option2 = new JRadioButton();
        option2.setBounds(160,520,700,30);
        option2.setBackground(Color.WHITE);
        option2.setFont(new Font("Dialog",Font.PLAIN,17));
        add(option2);
        
        option3 = new JRadioButton();
        option3.setBounds(160,560,700,30);
        option3.setBackground(Color.WHITE);
        option3.setFont(new Font("Dialog",Font.PLAIN,17));
        add(option3);
        
        option4 = new JRadioButton();
        option4.setBounds(160,600,700,30);
        option4.setBackground(Color.WHITE);
        option4.setFont(new Font("Dialog",Font.PLAIN,17));
        add(option4);

        grpBtn = new ButtonGroup();
        grpBtn.add(option1);
        grpBtn.add(option2);
        grpBtn.add(option3);
        grpBtn.add(option4);

        next = new JButton("Next");
        next.setBounds(900, 450, 200,40);
        next.setFont(new Font("Dialog",Font.PLAIN,18));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        // lifeLine = new JButton("50-50 LifeLine");
        // lifeLine.setBounds(900, 550, 200,40);
        // lifeLine.setFont(new Font("Dialog",Font.PLAIN,18));
        // lifeLine.setBackground(new Color(30,144,255));
        // lifeLine.setForeground(Color.WHITE);
        // lifeLine.addActionListener(this);
        // add(lifeLine);
        
        submit = new JButton("Submit");
        submit.setBounds(900, 650, 200,40);
        submit.setFont(new Font("Dialog",Font.PLAIN,18));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);



        setSize(1200,800);
        setLocation(170,110);
        setVisible(true);
    }


    public void start(int count){
        questionNo.setText(count + 1 + ".");
        question.setText(questions[count][0]);
    
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
    
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
    
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
    
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);
    
        grpBtn.clearSelection();
    }


    public void paint(Graphics g){

        super.paint(g);
        String time = "Time left : "+ timer +" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Dialog",Font.BOLD,22));


        if(timer>0){
            g.drawString(time, 900, 450);
        }else{
            g.drawString("Times up", 900, 450);
        }
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // user selected an answer
        if(ans_given == 1){
            ans_given = 0;
            timer = 15;
        }else if(timer<0){
            timer = 15;
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if(count == 9){ // submit
                if(grpBtn.getSelection() == null){
                    userAnswer[count][0] = "";
                }else{
                    userAnswer[count][0] = grpBtn.getSelection().getActionCommand();
                }

                for(int i=0 ; i<userAnswer.length ; i++){
                    if(userAnswer[i][0].equals(answers[i][1])){
                        score += 10;
                    }
                }

                setVisible(false);
                dispose();
                new Score(username,score);

            }else{
                if(grpBtn.getSelection() == null){
                    userAnswer[count][0] = "";
                }else{
                    userAnswer[count][0] = grpBtn.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }



    public void actionPerformed(ActionEvent e){

        if(e.getSource() == next){
            repaint();

            ans_given = 1;

            if(grpBtn.getSelection() == null){
                userAnswer[count][0] = "";
            }else{
                userAnswer[count][0] = grpBtn.getSelection().getActionCommand();
            }

            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
            
        }
        
        if(e.getSource() == submit){
            ans_given = 1;

            if(grpBtn.getSelection() == null){
                userAnswer[count][0] = "";
            }else{
                userAnswer[count][0] = grpBtn.getSelection().getActionCommand();
            }

            for(int i=0 ; i<userAnswer.length ; i++){
                if(userAnswer[i][0].equals(answers[i][1])){
                    score += 10;
                }
            }

            setVisible(false);
            dispose();
            new Score(username,score);
        }

    }



    

    public static void main(String[] args) {
        new Quiz("User");
    }

}
