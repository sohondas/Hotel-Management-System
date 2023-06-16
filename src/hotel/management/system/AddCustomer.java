
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comid;
    JTextField tf,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    AddCustomer()
    {
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel l=new JLabel("New Customer Form");
       l.setBounds(100,20,300,30);
       l.setFont(new Font("Raleway",Font.PLAIN,20));
       add(l);
       
       JLabel iblid=new JLabel("ID");
       iblid.setBounds(35,80,100,20);
       iblid.setFont(new Font("Raleway",Font.PLAIN,20));
       add(iblid);
       
       String options[]= {"Adhar Card","Passport","Driving Lisence","Voter-id Card","Ration Card"};
       comid= new JComboBox(options);
       comid.setBounds(200,80,150,25);
       comid.setBackground(Color.WHITE);
       add(comid);
       
       JLabel iblnum=new JLabel("Number");
       iblnum.setBounds(35,120,100,20);
       iblnum.setFont(new Font("Raleway",Font.PLAIN,20));
       add(iblnum);
       
       tf= new JTextField();
       tf.setBounds(200,120,300,30);
       tf.setBackground(Color.WHITE);
       add(tf);
       
       JLabel iblname=new JLabel("Name");
       iblname.setBounds(35,160,100,20);
       iblname.setFont(new Font("Raleway",Font.PLAIN,20));
       add(iblname);
       
       tfname= new JTextField();
       tfname.setBounds(200,160,300,30);
       tfname.setBackground(Color.WHITE);
       add(tfname);
       
       JLabel gdr=new JLabel("Gender");
       gdr.setBounds(35,200,100,20);
       gdr.setFont(new Font("Raleway",Font.PLAIN,20));
       add(gdr);
       
       rmale= new JRadioButton("Male");
       rmale.setBackground(Color.WHITE);
       rmale.setBounds(200,200,60,25);
       add(rmale);
       
        rfemale= new JRadioButton("Female");
       rfemale.setBackground(Color.WHITE);
       rfemale.setBounds(270,200,100,25);
       add(rfemale);
       
       ButtonGroup bg=new ButtonGroup();
       bg.add(rmale);
       bg.add(rfemale);
       
       JLabel country=new JLabel("Country");
       country.setBounds(35,240,100,20);
       country.setFont(new Font("Raleway",Font.PLAIN,20));
       add(country);
       
       tfcountry= new JTextField();
       tfcountry.setBounds(200,240,300,30);
       tfcountry.setBackground(Color.WHITE);
       add(tfcountry);
       
       JLabel room=new JLabel("Room Number");
       room.setBounds(35,280,150,20);
       room.setFont(new Font("Raleway",Font.PLAIN,20));
       add(room);
       
       croom=new Choice();
       try
       {
           Conn conn= new Conn();
           String query= "Select * from room where availability ='Available'";
           ResultSet rs=conn.s.executeQuery(query);
           while(rs.next())
           {
               croom.add(rs.getString("roomnumber"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       croom.setBounds(200,280,150,25);
       add(croom);
       
       JLabel lbltime=new JLabel("CheckIn Time");
       lbltime.setBounds(35,320,150,25);
       lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
       add(lbltime);
       
       Date dt= new Date();
       checkintime=new JLabel(""+ dt);
       checkintime.setBounds(200,320,250,25);
       checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
       add(checkintime);
       
       JLabel deposit=new JLabel("Deposit");
       deposit.setBounds(35,360,100,20);
       deposit.setFont(new Font("Raleway",Font.PLAIN,20));
       add(deposit);
       
       tfdeposit= new JTextField();
       tfdeposit.setBounds(200,360,300,30);
       add(tfdeposit);
       
       add= new JButton("Add");
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add.setBounds(200,410,120,30);
       add.addActionListener(this);
       add(add);
       
       back=new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(200,410,120,30);
       back.addActionListener(this);
       add(back);
       
       ImageIcon il =new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
       Image i2= il.getImage().getScaledInstance(350,400, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(500,50,300,400);
       add(image);
       
       setBounds(350,200,800,550);
        setVisible(true);
    }
  public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String id= (String) comid.getSelectedItem();
            String number= tf.getText();
            String name=tfname.getText();
            String gender=null;
            
            if(rmale.isSelected())
            {
                gender= "Male";
                
            }else
                gender="Female";
            String country= tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit= tfdeposit.getText();
            
            
            try{
                String query= "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2= "update room set availability='Occupied' where roomnumber= '"+room+"'";
                
                
                Conn conn=new Conn();
                                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                
                
                JOptionPane.showMessageDialog(null,"New Customer Added");
                setVisible(false);
                new Reception();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                
            }
            
        } else if(ae.getSource()== back)
        {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String args[])
    {
        new AddCustomer();
    }

    
}
