
package hotel.management.system;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus,tfpaid;
    JTextField tfpending;
    JButton check,update,back;
    UpdateRoom()
    { 
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text= new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        
        
        JLabel lid=new JLabel("Customer Id");
        lid.setBounds(30,80,100,20);
        add(lid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel room=new JLabel("Room");
        room.setBounds(30,130,100,20);
        add(room);
        
        tfroom= new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);
        
        JLabel name=new JLabel("Availability");
        name.setBounds(30,180,100,20);
        add(name);
        
        tfavailable= new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);
        
        JLabel checkin=new JLabel("Cleaning Status");
        checkin.setBounds(30,230,100,20);
        add(checkin);
        
        tfstatus= new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);
        
        
        
        check= new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update= new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i1= i.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i1);
        JLabel i2= new JLabel(i3);
        i2.setBounds(400,50,500,300);
        add(i2);
        
        setBounds(300,200,980,450);
        setVisible (true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== check)
        {
            String id= ccustomer.getSelectedItem();
            String query= "Select * from customer where number = '"+id+"'";
            try{
                Conn c= new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while (rs.next())
                {
                    tfroom.setText(rs.getString("room"));
                    
                              
                }
                ResultSet rs2= c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next())
                {
                   tfavailable.setText(rs2.getString("availability"));
                   tfstatus.setText(rs2.getString("cleaning_status"));
                    
                }
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }   
        else if(ae.getSource()== update)
        {
            String number= ccustomer.getSelectedItem();
            String room= tfroom.getText();
            String available= tfavailable.getText();
            String status= tfstatus.getText();
            
            try{
                Conn c= new Conn();
                c.s.executeUpdate("update room set availability= '"+available+"', cleaning_status= '"+status+"' where roomnumber= '"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Update Successfully");
                
                setVisible (false);
                new Reception();
            } catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else 
        {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String args[])
    {
        new UpdateRoom();
    }
}
