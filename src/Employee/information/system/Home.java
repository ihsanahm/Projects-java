package Employee.information.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Home extends JFrame implements ActionListener{


    JButton Addemployee,veiwemployee,deleteemployee;
    Home()
    {
        JLabel heading = new JLabel("Employee Information System.");
        heading.setBounds(200, 10, 550, 200);
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        heading.setForeground(Color.yellow);
        heading.setBackground(Color.decode("#ab5307"));
        add(heading);
        Addemployee=new JButton("Add Employee");
         Addemployee.setFocusable(false);
       // Addemployee.setSize(new Dimension());
        Addemployee.setForeground(Color.WHITE);
        Addemployee.setBounds(200,200,200,30);
        Addemployee.setBackground(Color.decode("#ab5307"));
        Addemployee.addActionListener(this);
        add(Addemployee);
        veiwemployee=new JButton("View Employee");
        veiwemployee.addActionListener(this);
        veiwemployee.setFocusable(false);
       // veiwemployee.setSize(new Dimension());
        veiwemployee.setForeground(Color.WHITE);
        veiwemployee.setBounds(200,300,200,30);
        veiwemployee.setBackground(Color.decode("#9c892c"));

        add(veiwemployee);
         deleteemployee=new JButton("Delete Employee");

         deleteemployee.setFocusable(false);
        deleteemployee.addActionListener(this);
        //deleteemployee.setSize(new Dimension());
        deleteemployee.setForeground(Color.WHITE);
        deleteemployee.setBounds(200,400,200,30);
        deleteemployee.setBackground(Color.decode("#f7ef07"));
        add(deleteemployee);


        ImageIcon image=new ImageIcon(Objects.requireNonNull(getClass().getResource("/myicon/homeB2.jpg")));
        JLabel label=new JLabel(image);
        label.setBounds(00,00,900,600);
       add(label);
        setSize(900,600);
        setLocation(100,40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e )
    {
        if (e.getSource() ==Addemployee){
            dispose();
            new AddEmployeeForm();
        }
        else if (e.getSource() ==veiwemployee)
        {
            dispose();
            new ViewEmployee();

        }else if (e.getSource() ==deleteemployee)

        {
            dispose();
            new DeleteEmployee();
        }

    }

    public static void main(String[] args)
    {
        new Home();

    }

}
