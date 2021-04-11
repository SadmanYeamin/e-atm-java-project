import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class Deposit{


    String userId;

    public Deposit(final String userId){


        this.userId = userId;

        


        final JFrame frame = new JFrame("Deposit");

        final Font f1 = new Font("Serif",Font.BOLD,45);
        final Font f2 = new Font ("Ariel",Font.PLAIN,25);
        final Font f3 = new Font ("Ariel",Font.BOLD,20);
        final Font f4 = new Font ("Ariel",Font.BOLD,15);

        final JLabel l1 = new JLabel("Deposit");
        l1.setBounds(290,0,800,150);
        l1.setFont(f1);


        final JLabel l2 = new JLabel("Account Number :");
        final JLabel l3 = new JLabel("Account Password :");
        final JLabel l4 = new JLabel(userId);
        final JLabel l6 = new JLabel("Deposit :");
        JLabel l7 = new JLabel();


        final JPasswordField tf1 = new JPasswordField();
        tf1.setBounds(550,357,150,40);

        final JTextField tf2 = new JTextField();
        tf2.setBounds(550,460,150,40);
        tf1.setFont(f3);

        l2.setBounds(170,200,800,150);
        l2.setFont(f2);


        l3.setBounds(170,300,800,150);
        l3.setFont(f2);


        l4.setBounds(550,200,800,150);
        l4.setFont(f2);


        


        l6.setBounds(170,400,800,150);
        l6.setFont(f2);

        l7.setBounds(550,500,300,40);
        l7.setFont(f4);


        tf2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               String value = tf2.getText();
               int l = value.length();
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                  tf2.setEditable(true);
                  l7.setText("");
               } else {
                  tf2.setEditable(false);
                  l7.setText("* Enter only numeric digits(0-9)");
               }
            }
         });


        final JButton bt1 = new JButton("Back");
        bt1.setBounds(20,20,100,40);


        final JButton bt2 = new JButton("Deposit");
        bt2.setBounds(400,600,220,50);
        bt2.setFont(f3);


        bt1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

                final First f = new First(userId);
                
                frame.dispose();
            }
        } );



        bt2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent ae) {

                // if (tf1.getText()!=null && tf2.getText()!=null) {

                    
                    final String query = "select `id`, `Password` from `balance` ; " ;
                    Connection con=null;//for connection
                    Statement st = null;//for query execution
                    ResultSet rs = null;

                    try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
            

            
			
			
            boolean flag = false;	
			while(rs.next())
			{
                final String userId = rs.getString("id");
                final String password = rs.getString("Password");
                final String uid = userId;
                final String pass = tf1.getText();

                System.out.println(uid);
                System.out.println(pass);
				
				if(userId.equals(l4.getText()) && password.equals(tf1.getText()))
				{
                    flag = true ;
					try {  
                        //Class.forName("com.mysql.jdbc.Driver");  
                        // establish connection  
                        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Studentinformation", "root", "");  
                        final Statement stmt = con.createStatement();  
                        //stmt.execute("UPDATE balance SET Balance='" + tf2.getText() + "' WHERE id= '" +userId+"' ");  

                       stmt.execute( " UPDATE balance SET Balance = (SELECT MAX(Balance) + '"+ tf2.getText() +"' FROM balance where id = '"+userId+"') WHERE id = '" +userId+ "' ;") ;
                        JOptionPane.showMessageDialog(null, "Record is updated...");  
                        stmt.close();  
                        con.close();  
                        //Referesh(); //Calling Referesh() method  
                    } catch (Exception eeeee) {  
                        //JOptionPane.showMessageDialog(null, se);  
                    } 
                    
                }
                
                // else{

                //     JOptionPane.showMessageDialog(null, "Invalid passworddd");

                // }
            }
            
            if(!flag)
			{
				JOptionPane.showMessageDialog(null, "invalid password"); 
				tf1.setText("");
				tf2.setText("");
			}


                }
                catch(final Exception eee)
                {  
                    System.out.println("Error");
            }


            finally
            {
                try
                {
                    if(rs!=null)
                        rs.close();
    
                    if(st!=null)
                        st.close();
    
                    if(con!=null)
                        con.close();
                }
                catch(Exception ex){}
            }

            

            // else{
            //     JOptionPane.showMessageDialog(null, "Invalid Passwo","UnSuccessful",
            //                              JOptionPane.INFORMATION_MESSAGE);


            // }


                

                
            }
        } );


        

        


        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l7);
        frame.add(bt1);
        frame.add(l6);
        frame.add(tf1);
        frame.add(tf2);
        frame.add(bt2);

        


        
        frame.setSize(1200,800);
        frame.setBounds(600, 160, 1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void setlabel(){



    }
}