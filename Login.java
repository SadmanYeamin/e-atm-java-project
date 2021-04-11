import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;


public class Login{


    public Login(){


        JFrame frame = new JFrame("E BANKING ATM");


        Font f1 = new Font("Serif",Font.BOLD,70);
        Font f2 = new Font ("Ariel",Font.PLAIN,30);
        Font f3 = new Font("Serif",Font.BOLD,22);

        JLabel l1 = new JLabel("E-Banking ATM ");
        l1.setBounds(290,0,800,150);
        l1.setFont(f1);


        JLabel l2 = new JLabel("Account Number : ");
        l2.setBounds(270,150,800,150);
        l2.setFont(f2);


        JTextField tf1 = new JTextField();
        
        tf1.setBounds(310,270,360,50);

        JLabel l3 = new JLabel("Account Password: ");
        l3.setBounds(270,300,800,150);
        l3.setFont(f2);


        JPasswordField tf2 = new JPasswordField();
        tf2.setBounds(270,420,400,50);


        JTextField tf3 = new JTextField("C");
        tf3.setBounds(270,270,50,50);
        tf3.setEnabled(false);



        tf1.setFont(f3);
        tf2.setFont(f3);
        tf3.setFont(f3);


        JButton bt1 = new JButton("Login");
        bt1.setBounds(410,520,220,50);



        JButton bt2 = new JButton("Home");
        bt2.setBounds(10,10,140,30);



        bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {


                String query = "SELECT `id`, `Password` FROM `areg`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
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
                String userId = rs.getString("id");
                String password = rs.getString("Password");
                String uid = tf3.getText()+tf1.getText();
                String pass = tf2.getText();

                System.out.println(uid);
                System.out.println(pass);
				
				if(userId.equals(uid) && password.equals(pass))
				{
					flag=true;
                    First c=new First(userId);
                    frame.dispose();
				}
			}
			
			if(!flag)
			{
				JOptionPane.showMessageDialog(null, "Invalid Account Number or Password","UnSuccess",
                                         JOptionPane.INFORMATION_MESSAGE);
				tf1.setText("");
				tf2.setText("");
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
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

                
            }
        } );


        bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


                Welcome w = new Welcome();

                frame.dispose();

                
            }
        } );



        



        frame.add(bt1);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(tf1);
        frame.add(tf2);
        frame.add(bt2);
        frame.add(tf3);
        frame.setSize(1200,800);
        frame.setBounds(600, 160, 1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        






    }




}