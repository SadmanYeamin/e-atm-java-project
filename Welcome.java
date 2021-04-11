import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;


public class Welcome{


    public Welcome()

    {
        JFrame frame = new JFrame("E-Banking ATM");

        Font f1 = new Font("Serif",Font.BOLD,70);
        Font f2 = new Font ("Ariel",Font.PLAIN,30);
        Font f3 = new Font ("Ariel",Font.PLAIN,5);

        JLabel l1 = new JLabel("E-Banking ATM");
        l1.setBounds(290,0,800,150);
        l1.setFont(f1);


        JButton bt1 = new JButton("Login");
        bt1.setBounds(330,300,400,80);
        bt1.setFont(f2);
        


        JButton bt2 = new JButton("Register");
        bt2.setBounds(330,400,400,80);
        bt2.setFont(f2);



        bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                Login l = new Login();
                
                frame.dispose();
            }
        } );



        bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                Registration l = new Registration();
                
                frame.dispose();
            }
        } );

        //ImageIcon icon = new ImageIcon(getClass().getResource("atm2.jpg"));
        //ImageIcon icon = new ImageIcon("atm2.jpg");
        


        //Image image = icon.getImage();
        //JLabel l3 = new JLabel(icon);
        //l3.setBounds(60,360,800,800);
        //l3.setFont(f3);
         
        


        frame.add(bt1);
        frame.add(bt2);
        frame.add(l1);
        //frame.add(l3);
        frame.setSize(1200,800);
        //frame.setLayout(new GridLayout(2,3));
        //frame.pack();
        frame.setLayout(null);
        frame.setBounds(600, 160, 1000, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}