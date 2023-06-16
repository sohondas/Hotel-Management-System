
package hotel.management.system;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice cartype;
    JCheckBox available;
    Pickup()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text= new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel l1=new JLabel("Type of Car");
        l1.setBounds(50,100,100,20);
        add(l1);
        
        cartype= new Choice();
        cartype.setBounds(150,100,200,25);
        add(cartype);
        
        try{
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                cartype.add(rs.getString("brand"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        JLabel l11=new JLabel("Name");
        l11.setBounds(30,160,100,20);
        add(l11);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Brand");
        l5.setBounds(630,160,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Availability");
        l6.setBounds(740,160,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        
        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        try{ 
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("Select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.getStackTrace();
        }
        
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== submit){
            try{
                String query= "select * from driver where brand='"+cartype.getSelectedItem()+"'";
                
                Conn conn= new Conn();
                ResultSet rs;
                rs= conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else{
        setVisible(false);
        new Reception();
        }
    }
    public static void main(String args[])
    {
        new Pickup();
    }
}
