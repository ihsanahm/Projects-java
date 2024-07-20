package Employee.information.system;

import com.example.projects.DBconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionListener;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable mytable;
    JLabel search;
    Choice searcht;
    JPanel mypanel;
    JButton back,search1,Update,print;



    ViewEmployee()
    {

        search=new JLabel("Search By Employee Id ");
        search.setFont(new Font("Arial", Font.BOLD, 15));
        search.setBounds(40,30 ,190,40);
        search.setForeground(Color.BLACK);
        add(search);
        searcht=new Choice();
        searcht.setFont(new Font("Arial", Font.BOLD, 15));
        searcht.setBounds(240,40 ,200,40);
        add(searcht);
        try {
            Connection connection= DBconnection.connector();
            ResultSet resultSet =connection.createStatement().executeQuery( "select * from Employees");
            while (resultSet.next())
            {

                searcht.add(resultSet.getString("EmployeeId"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        mytable = new JTable();
        try {
            Connection connection= DBconnection.connector();
            ResultSet resultSet =connection.createStatement().executeQuery( "select * from Employees");
            mytable.setModel(DbUtils.resultSetToTableModel(resultSet));
            mytable.setRowHeight(30);
            mytable.setFont(new Font("Arial", Font.BOLD, 15));
            mytable.setBounds(0,150,1300,900);
            add(mytable);

        }
        catch (Exception e)
            {
                e.printStackTrace();
            }
        JScrollPane scrollPane = new JScrollPane(mytable);
        scrollPane.setBounds(0,100,1300,900);
        add(scrollPane);
        search1  = new JButton("Search");
        search1.setFont(new Font("Arial", Font.BOLD, 15));
        search1.setBounds(40,70,90,25);
        search1.setFocusable(false);
        search1.addActionListener((ActionListener) this);
        add(search1);
        Update  = new JButton("Update");
        Update .setFont(new Font("Arial", Font.BOLD, 15));
        Update .setBounds(140,70,100,25);
        Update.setFocusable(false);
        Update .addActionListener((ActionListener) this);
        add( Update );
        print  = new JButton("Print");
        print.setFont(new Font("Arial", Font.BOLD, 15));
        print.setBounds(250,70,100,25);
        print.setFocusable(false);
        print.addActionListener((ActionListener) this);
        add(print);
        back  = new JButton("Back");
        back  .setFont(new Font("Arial", Font.BOLD, 15));
        back  .setBounds(360,70,100,25);
        back.setFocusable(false);
        back .addActionListener((ActionListener) this);
        add( back  );

       mypanel = new JPanel();
        mypanel.setBounds(0,0,1300,900);
        mypanel.setLayout(null);
        mypanel.setBackground(Color.decode("#756e5a"));
        add(mypanel);
        setSize(1300,900);
        setLocation(0,0);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e )
    {


        if (e.getSource() ==search1)
            {
                String query ="SELECT * FROM Employees WHERE employeeId ='"+searcht.getSelectedItem()+"'";
                try {
                    Connection connection= DBconnection.connector();
                    ResultSet resultSet =connection.createStatement().executeQuery( query);
                    mytable.setModel(DbUtils.resultSetToTableModel(resultSet));

                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        else if (e.getSource() ==Update){
            dispose();
            new UpdateEmployee(searcht.getSelectedItem());

        }
        else if (e.getSource() ==print){
            try {
                mytable.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource() ==back){

           dispose();
            new Home();
        }


    }
    public static void main(String[] args) {

        new ViewEmployee();
    }
}
