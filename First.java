import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


public class First{

    String userId;


    public First(String userId){

        this.userId = userId ;

        JFrame frame = new JFrame();

        Font f1 = new Font("Serif",Font.BOLD,50);
        Font f3 = new Font("Serif",Font.BOLD,30);
        Font f2 = new Font("Ariel",Font.PLAIN,15);

        JLabel l1 = new JLabel("E-Banking ATM System");
        l1.setBounds(290,0,800,150);
        l1.setFont(f1);


        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        //Date date = new Date();  
        //System.out.println(formatter.format(date));  

        
        LocalDateTime currentTime = LocalDateTime.now();
        String output = currentTime.toString();

        JLabel l3 = new JLabel(output);
        l3.setBounds(750,70,800,150);
        l3.setFont(f2);


        JLabel l2 = new JLabel(userId);
        l2.setBounds(100,70,800,150);
        l2.setFont(f2);
        

        

        JButton bt1 = new JButton("Deposit");
        JButton bt2 = new JButton("Withdraw");
        JButton bt3 = new JButton("Balance");
        JButton bt4 = new JButton("Logout");


        bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                Deposit d = new Deposit(userId);

                frame.dispose();

                
            }
        } );


        bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

                Withdraw wi = new Withdraw(userId);

                frame.dispose();

                
            }
        } );


        bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {


                Balance b = new Balance(userId);

                frame.dispose();

                
            }
        } );



        bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent af) {

                Welcome wl = new Welcome();
                frame.dispose();

                
            }
        } );

        bt1.setBounds(180,200,300,150);
        bt2.setBounds(500,200,300,150);
        bt3.setBounds(180,400,300,150);
        bt4.setBounds(500,400,300,150);

        bt1.setFont(f3);
        bt2.setFont(f3);
        bt3.setFont(f3);
        bt4.setFont(f3);




        frame.add(bt1);
        frame.add(bt2);
        frame.add(bt3);
        frame.add(bt4);

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.setSize(1200,800);
        frame.setBounds(600, 160, 1000, 850);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}