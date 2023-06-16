package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton checkout,newcustomer,customer,dept,allemp,manager,rstatus,searchroom,room,logout,pickup,update;

   
    Reception()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        newcustomer= new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.black);
        newcustomer.setForeground(Color.white);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
        room= new JButton("Rooms");
        room.setBounds(10,70,200,30);
        room.setBackground(Color.black);
        room.setForeground(Color.white);
        room.addActionListener(this);
        add(room);
        
        dept= new JButton("Department");
        dept.setBounds(10,110,200,30);
        dept.setBackground(Color.black);
        dept.setForeground(Color.white);
        dept.addActionListener(this);
        add(dept);
        
        allemp= new JButton("All Employee");
        allemp.setBounds(10,150,200,30);
        allemp.setBackground(Color.black);
        allemp.setForeground(Color.white);
        allemp.addActionListener(this);
        add(allemp);
        
        customer= new JButton("Customers Info");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        add(customer);
        
        manager= new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);
        
        checkout= new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        update= new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        rstatus= new JButton("Room Status");
        rstatus.setBounds(10,350,200,30);
        rstatus.setBackground(Color.black);
        rstatus.setForeground(Color.white);
        rstatus.addActionListener(this);
        add(rstatus);
        
        pickup= new JButton("Pickup service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
        
        searchroom= new JButton("Search Room");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);
        
        logout= new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel l= new JLabel(ic);
        l.setBounds(250,30,500,470);
        add(l);
        
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource()==newcustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==customer){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()==dept){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource()==allemp){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource()==manager){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==room){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==searchroom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()== update )
        {
            setVisible(false);
            new UpdateCheck();
        }
         else if(ae.getSource()== rstatus )
        {
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()== pickup )
        {
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    
    public static void main(String args[])
    {
        new Reception();
        
        
    }
    
}
