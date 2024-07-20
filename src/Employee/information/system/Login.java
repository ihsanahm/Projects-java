package Employee.information.system;

import com.example.projects.DBconnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.lang.System;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {



    static JTextField textField;
    static JPasswordField passwordField;
    JFrame frame;
    JButton button, button1;
    Login()
    {
         frame=new JFrame();
        textField=new JTextField();
        passwordField=new JPasswordField();

        JLabel l1=new JLabel("Username");
        l1.setBounds(100,50,100,30);
        textField.setBounds(170,50,150,30);

        JLabel l2=new JLabel("Password");
        button=new JButton("Login");
        button .setFocusable(false);
        button.addActionListener(this);

        button.setBounds(170,130,150,30);
        button.setBackground(Color.gray);
        button.setForeground(Color.WHITE);
         button1=new JButton("Back");
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setForeground(Color.WHITE);
        ImageIcon image1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/myicon/Ihsan1.PNG")));
        JLabel label1=new JLabel(image1);
        label1.setBounds(400,0,1000,600);
       frame.add(label1);

        button1.setBounds(170,170,150,30);
        button1.setBackground(Color.gray);
        l2.setBounds(100,90,300,30);
        passwordField.setBounds(170,90,150,30);





        ImageIcon image=new ImageIcon(Objects.requireNonNull(getClass().getResource("/myicon/LoginB (1).jpg")));
        JLabel label=new JLabel(image);
        label.setBounds(0,0,1000,700);



        frame.add(l1);
        frame.add(textField);
        frame.add(l2);
        frame.add(passwordField);
        frame.add(button);
        frame.add(button1);

        frame.add(label);


        frame.setSize(700,400);
        frame.setLocation(300,100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            try {
                String username = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                System.out.println(STR."\{username} \{password}");

                Connection connection = DBconnection.connector();

                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                System.out.println("Query not executed");
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();


                if (resultSet.next()) {
                    String name = resultSet.getString("username");

                    frame.dispose();
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (HeadlessException e1) {
                throw new RuntimeException(e1);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == button1) {
            System.exit(98);
        }
    }



    public static void main(String[] args) {
      DBconnection.connector();

        new Login();
    }
}
