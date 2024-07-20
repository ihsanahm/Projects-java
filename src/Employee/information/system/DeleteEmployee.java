package Employee.information.system;

import com.example.projects.DBconnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static java.awt.Color.*;
import static java.lang.Math.E;

public class DeleteEmployee extends JFrame implements ActionListener{


    JPanel mypanel;
Choice employeeid;
JButton delete,back;

    DeleteEmployee()
    {
        mypanel=new JPanel();

        JLabel label=new JLabel("Search Employee : ");
        label.setFont(new Font("Arial",Font.BOLD,15));
        label.setBounds(40,30 ,170,40);
        label.setForeground(Color.BLACK);
        add(label);

        employeeid=new Choice();
        employeeid.setFont(new Font("Arial",Font.BOLD,15));
        employeeid.setBounds(220,40 ,200,40);
        add(employeeid);
        try {
            Connection connection= DBconnection.connector();
            ResultSet resultSet =connection.createStatement().executeQuery( "select * from Employees");
            while (resultSet.next())
            {

                employeeid.add(resultSet.getString("EmployeeId"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        JLabel firstName = new JLabel("FIRST NAME    :");
        firstName.setFont(new Font("Arial", Font.BOLD, 15));
        firstName.setBounds(100, 100, 150, 40);
        firstName.setForeground(black);
        add(firstName);
        JLabel TfirstName = new JLabel();
        TfirstName.setFont(new Font("Arial", Font.BOLD, 15));
        TfirstName.setBounds(250, 100, 200, 30);
        add(TfirstName);
        JLabel middlename = new JLabel("MIDDLE NAME :");
        middlename.setFont(new Font("Arial", Font.BOLD, 15));
        middlename.setBounds(100, 145, 150, 40);
        middlename.setForeground(black);
        add(middlename);
        JLabel Tmiddlename = new JLabel();
        Tmiddlename.setFont(new Font("Arial", Font.BOLD, 15));
        Tmiddlename.setBounds(250, 145, 200, 30);
        add(Tmiddlename);

        JLabel lastname = new JLabel("LAST NAME      :");
        lastname.setFont(new Font("Arial", Font.BOLD, 15));
        lastname.setBounds(100, 195, 150, 40);
        lastname.setForeground(black);
        add(lastname);
        JLabel Tlastname = new JLabel();
        Tlastname.setBounds(250, 195, 200, 30);
        Tlastname.setFont(new Font("Arial", Font.BOLD, 15));
        add(Tlastname);
        JLabel Gmail = new JLabel("GMAIL                :");
        Gmail.setFont(new Font("Arial", Font.BOLD, 15));
        Gmail.setBounds(100, 240, 150, 40);
        Gmail.setForeground(black);
        add(Gmail);
        JLabel TGmail = new JLabel();
        TGmail.setFont(new Font("Arial", Font.BOLD, 15));
        TGmail.setBounds(250, 240, 200, 30);
        add(TGmail);


        JLabel CNIC = new JLabel("CNIC                   : ");
        CNIC.setFont(new Font("Arial", Font.BOLD, 15));
        CNIC.setBounds(100, 280, 150, 40);
        CNIC.setForeground(black);
        add(CNIC);

        JLabel TCNIC = new JLabel();
        TCNIC.setFont(new Font("Arial", Font.BOLD, 15));
        TCNIC.setBounds(250, 280, 200, 30);
        add(TCNIC);
        try {

            Connection connection= DBconnection.connector();
            ResultSet resultSet =connection.createStatement().executeQuery( "select * from Employees");
            while (resultSet.next())
                {


                   TfirstName.setText(resultSet.getString("First_Name"));
                    Tmiddlename.setText(resultSet.getString("M_name"));
                    Tlastname.setText(resultSet.getString("Last_Name"));
                    TGmail.setText(resultSet.getString("Email"));
                    TCNIC.setText(resultSet.getString("CNIC"));
                }


        }
        catch (Exception e)
            {
                e.printStackTrace();
            }


        employeeid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    String selectedEmployeeId = employeeid.getSelectedItem();
                    Connection connection = DBconnection.connector();
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employees WHERE EmployeeId = ?");
                    statement.setString(1, selectedEmployeeId);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        TfirstName.setText(resultSet.getString("First_Name"));
                        Tmiddlename.setText(resultSet.getString("M_name"));
                        Tlastname.setText(resultSet.getString("Last_Name"));
                        TGmail.setText(resultSet.getString("Email"));
                        TCNIC.setText(resultSet.getString("CNIC"));
                    }
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        delete=new JButton("DELETE");
        delete.setFont(new Font("Arial",Font.BOLD,15));
        delete.setBounds(100,350,100,40);
        delete.addActionListener(this);
        add(delete);
        back=new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.setBounds(250,350,100,40);
        back.addActionListener(this);
        add(back);
        ImageIcon image1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/myicon/delete.png")));
        JLabel myLabel1=new JLabel(image1);
        myLabel1.setBounds(460,40,500,550);
        add(myLabel1);

        ImageIcon image=new ImageIcon(Objects.requireNonNull(getClass().getResource("/myicon/rback.png")));
        JLabel myLabel=new JLabel(image);
        myLabel.setBounds(0,0,900,600);
        add(myLabel);


        mypanel.setSize(900,600);
        mypanel.setLayout(null);
        mypanel.setBackground(decode("#90ccd1"));
        add(mypanel);

       setSize(900,600);
        setLocation(150, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete)
        {
            try {
                String selectedEmployeeId = employeeid.getSelectedItem();
                Connection connection = DBconnection.connector();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM Employees WHERE EmployeeId = ?");
                statement.setString(1, selectedEmployeeId);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
            }
            catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Employee Not Deleted");
            }
        }
        else if (e.getSource()==back)
        {
            dispose();
            new Home();
        }
    }
    public static void main(String[] args)
    {
        new DeleteEmployee();
    }
}
