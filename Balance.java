import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class Balance{

    String userId;
    String bl;

    public Balance(String userId){

        this.userId = userId ;



        JFrame frame = new JFrame("Balance");

        Font f1 = new Font("Serif",Font.BOLD,45);
        Font f2 = new Font ("Ariel",Font.PLAIN,25);

        JLabel l1 = new JLabel("Balance");
        l1.setBounds(290,0,800,150);
        l1.setFont(f1);


        JLabel l2 = new JLabel("Account Number :");
        JLabel l3 = new JLabel("Account Balance :");
        JLabel l4 = new JLabel(userId);
        JLabel l5 = new JLabel();





        String sql="SELECT Balance from balance where id = '" +userId+ "' "; 


                try {
					Class.forName("com.mysql.jdbc.Driver");
					final Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root",
                            "");


                            Statement s = c.createStatement();

                            

                            
                            ResultSet rsss=s.executeQuery(sql);

                            

                            rsss.next();

                            rsss.getString("Balance");

                            System.out.println(rsss.getString("Balance"));

                            String b = rsss.getString("Balance");

                            l5.setText(b);

                            




                }


                catch (Exception ee){

                }

                finally{


                    // con.close();
                    // stm.close();
                    // rs.close();
                }

        //setlabel();

        






        l2.setBounds(170,200,800,150);
        l2.setFont(f2);


        l3.setBounds(170,300,800,150);
        l3.setFont(f2);


        l4.setBounds(550,200,800,150);
        l4.setFont(f2);


        l5.setBounds(550,300,800,150);
        l5.setFont(f2);


        JButton bt1 = new JButton("Back");
        bt1.setBounds(20,20,100,40);


        bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                First f = new First(userId);
                
                frame.dispose();
            }
        } );


        

        


        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(bt1);
        frame.setSize(1200,800);
        frame.setBounds(600, 160, 1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    
}
