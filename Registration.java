import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class Registration{

    int i = 0;

    public Registration()
    {

        JFrame frame = new JFrame("Registration");

        Font f1 = new Font("Ariel",Font.BOLD,50);
        Font f2 = new Font("Serif",Font.PLAIN,22);
        Font f3 = new Font("Serif",Font.BOLD,22);

        JLabel l1 = new JLabel("Registration");
        l1.setBounds(290,0,800,150);
        l1.setFont(f1);


        JLabel l2 = new JLabel("Full Name");
        JLabel l3 = new JLabel("Account Number");
        JLabel l4 = new JLabel("Email");
        JLabel l5 = new JLabel("Phone No");
        JLabel l6 = new JLabel("Gender");
        JLabel l7 = new JLabel("Address");
        JLabel l8 = new JLabel("Password");


        l2.setBounds(140,100,400,200);
        l2.setFont(f2);
        l3.setBounds(140,170,400,200);
        l3.setFont(f2);
        l4.setBounds(140,240,400,200);
        l4.setFont(f2);
        l5.setBounds(140,310,400,200);
        l5.setFont(f2);
        l6.setBounds(140,380,400,200);
        l6.setFont(f2);
        l7.setBounds(140,450,400,200);
        l7.setFont(f2);
        l8.setBounds(140,520,400,200);
        l8.setFont(f2);



        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JTextField tf3 = new JTextField();
        JTextField tf4 = new JTextField();
        JTextField tf5 = new JTextField();
        JTextField tf6 = new JTextField();



        tf2.setEnabled(false);
        tf2.setFont(f3);
        tf6.setEnabled(false);
        tf6.setFont(f3);
        tf1.setFont(f3);
        tf3.setFont(f3);
        tf5.setFont(f3);
        tf4.setFont(f3);
        

        tf1.setBounds(410,190,220,40);
        tf2.setBounds(410,260,220,40);
        tf3.setBounds(410,330,220,40);
        tf4.setBounds(410,400,220,40);
        tf5.setBounds(410,540,220,40);
        tf6.setBounds(410,610,220,40);


        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("Female");

        r1.setActionCommand("Male");
		r2.setActionCommand("Female");

        ButtonGroup bt = new ButtonGroup();

        bt.add(r1);
        bt.add(r2);


        r1.setBounds(410,470,80,20);
        r2.setBounds(550,470,80,20);











        JButton bt1 = new JButton("Register");
        bt1.setBounds(300,700,220,50);


        JButton bt2 = new JButton("Home");
        bt2.setBounds(10,10,140,30);

        JButton bt3 = new JButton("Auto Generate");
        bt3.setBounds(650,610,120,25);

        JButton bt4 = new JButton("Auto Generate");
        bt4.setBounds(650,260,120,25);



        bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                Welcome w = new Welcome();

                frame.dispose();

                
            }
        } );


        bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {

                Random r = new Random();
			    tf6.setText(r.nextInt(89999999)+10000000+"");
			    bt3.setEnabled(false);

                
            }
        } );


        bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {

                String sql="SELECT MAX(id) from areg"; 


                try {
					Class.forName("com.mysql.jdbc.Driver");
					final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
                            "");


                            Statement stm = con.createStatement();

                            

                            
                            ResultSet rs=stm.executeQuery(sql);

                            rs.next();

                            rs.getString("MAX(id)");

                            if(rs.getString("MAX(id)")==null)
                            {
                                tf2.setText("C0001");
                            }
                            else
                            {
                                Long id = Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
                                id++;
                                tf2.setText("C0" +String.format("%03d", id));
                            }




                            
                            
                }

                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Error Occured","UnSuccessful",
                                         JOptionPane.INFORMATION_MESSAGE);

                }


                

                

                
            }
        } );



        



        bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

                String fullname = tf1.getText();
				String accountnumber = tf2.getText();
                String Email = tf3.getText();
                String Phoneno = tf4.getText();
                String	Gender = bt.getSelection().getActionCommand();
                String Address = tf5.getText();
                String Pass = tf6.getText();
                
				
				

                String query1 = "INSERT INTO areg VALUES ('" + fullname + "','" + accountnumber + "','" + Email + "','" + Phoneno + "', '" + Gender + "','" + Address + "','" + Pass + "');";
                String query2 = "INSERT INTO balance VALUES ('" + accountnumber + "','" + Pass + "',' 0000 ');";
				
                System.out.println(query1);
                System.out.println(query2);
				

				try {
					Class.forName("com.mysql.jdbc.Driver");
					final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
							"");
					final Statement stm = con.createStatement();
                    stm.execute(query1);
                    stm.execute(query2);
					
					stm.close();
					con.close();
					JOptionPane.showMessageDialog(null, "You have Registered successfully","Success",
                                         JOptionPane.INFORMATION_MESSAGE); 
					
					
				} catch (Exception ex)
		{
			System.out.println(ex);
			JOptionPane.showMessageDialog(null, "Error Occured","UnSuccessful",
                                         JOptionPane.INFORMATION_MESSAGE); 
		}

                
            }
        } );


        frame.add(tf1);
        frame.add(tf2);
        frame.add(tf3);
        frame.add(tf4);
        frame.add(tf5);
        frame.add(tf6);
        frame.add(r1);
        frame.add(r2);
        frame.add(bt2);
        frame.add(bt1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(l1);
        frame.add(bt3);
        frame.add(bt4);
        frame.setSize(1200,800);
        frame.setBounds(600, 160, 1000, 850);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}