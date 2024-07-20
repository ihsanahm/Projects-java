package Employee.information.system;


import com.example.projects.DBconnection;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.Font;
import java.awt.event.ActionEvent;

import static java.awt.Color.*;


public class AddEmployeeForm extends JFrame implements ActionListener {
    Random random = new Random();
    int employee = random.nextInt(999999);

    JLabel firstName, middlename, lastname, Fathername, CNIC, Gmail, Salary, Dsiganation, EmployeeId;
    JTextField TfirstName, Tmiddlename, Tlastname, TFathername, TCNIC, TGmail, TSalary;
    JLabel TemployId;
    JLabel Qulifaction, DataOfbirth, gender;

    JCheckBox male, female;

    JButton button, butto1;
    JButton button1;
    JDateChooser todb;
JPanel myPanel;
JLabel myEmail;
JComboBox TQulifactiont,TDsiganation;


    public AddEmployeeForm() {
            myPanel=new JPanel();
        JLabel heading = new JLabel("ADD EMPLOYEE DETAIL");
        heading.setBounds(230, 40, 500, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(Color.white);
        add(heading);
        firstName = new JLabel("FIRST NAME        :");
        firstName.setFont(new Font("Arial", Font.BOLD, 15));
        firstName.setBounds(100, 100, 150, 40);
        firstName.setForeground(Color.white);
        TfirstName = new JTextField();
        TfirstName.setFont(new Font("Arial", Font.BOLD, 15));
        TfirstName.setBounds(250, 100, 200, 30);
        middlename = new JLabel("MIDDLE NAME    :");
        middlename.setFont(new Font("Arial", Font.BOLD, 15));
        middlename.setBounds(100, 145, 150, 40);
        middlename.setForeground(Color.white);
        Tmiddlename = new JTextField();
        Tmiddlename.setFont(new Font("Arial", Font.BOLD, 15));
        Tmiddlename.setBounds(250, 145, 200, 30);

        lastname = new JLabel("LAST NAME        :");
        lastname.setFont(new Font("Arial", Font.BOLD, 15));
        lastname.setBounds(100, 195, 150, 40);
        lastname.setForeground(white);
        Tlastname = new JTextField();
        Tlastname.setBounds(250, 195, 200, 30);
        Tlastname.setFont(new Font("Arial", Font.BOLD, 15));
        Fathername = new JLabel("FATHER NAME   :");
        Fathername.setFont(new Font("Arial", Font.BOLD, 15));
        Fathername.setBounds(100, 240, 150, 40);
        Fathername.setForeground(Color.white);
        TFathername = new JTextField();
        TFathername.setFont(new Font("Arial", Font.BOLD, 15));
        TFathername.setBounds(250, 240, 200, 30);

        CNIC = new JLabel("CNIC         :");
        CNIC.setFont(new Font("Arial", Font.BOLD, 15));
        CNIC.setBounds(475, 90, 150, 40);
        CNIC.setForeground(Color.white);

        TCNIC = new JTextField();
        TCNIC.setFont(new Font("Arial", Font.BOLD, 15));
        TCNIC.setBounds(570, 90, 200, 30);
        Gmail = new JLabel("GMAIL      :");
        Gmail.setFont(new Font("Arial", Font.BOLD, 15));
        Gmail.setBounds(475, 135, 150, 40);
        Gmail.setForeground(Color.white);
        TGmail = new JTextField();
        TGmail.setFont(new Font("Arial", Font.BOLD, 15));
        TGmail.setBounds(570, 135, 200, 30);

        Salary = new JLabel("SALARY   :");
        Salary.setFont(new Font("Arial", Font.BOLD, 15));
        Salary.setBounds(475, 180, 150, 40);
        Salary.setForeground(Color.white);
        TSalary = new JTextField();
        TSalary.setFont(new Font("Arial", Font.BOLD, 15));
        TSalary.setBounds(570, 180, 200, 30);
        Dsiganation = new JLabel("DESIGNATION     :");
        Dsiganation.setFont(new Font("Arial", Font.BOLD, 15));
        Dsiganation.setBounds(100, 290, 150, 40);
        Dsiganation.setForeground(Color.white);
        String job[]={"HRM", "Manager", "Engineer", "Computer operator","Head of Department","Worker"};
        TDsiganation = new JComboBox(job);
        TDsiganation.setFont(new Font("Arial", Font.BOLD, 15));
        TDsiganation.setBounds(250, 290, 200, 30);
        Qulifaction = new JLabel("QUALIFICATION  :");


        //this line genrate an error I don't know how to handle this case'
        Qulifaction.setFont(new Font("Arial", Font.BOLD, 15));


        Qulifaction.setBounds(100, 340, 150, 40);
        Qulifaction.setForeground(Color.white);
        String course[]={"BBA","BSCS","AC","Be.d","PHD","EE","CSE","SE","AI","MBA","B.com"};
        TQulifactiont = new JComboBox(course);

        TQulifactiont.setFont(new Font("Arial", Font.BOLD, 15));
        TQulifactiont.setBounds(250, 340, 200, 30);

        gender = new JLabel("GENDER   :");
        gender.setFont(new Font("Arial", Font.BOLD, 15));
        gender.setBounds(475, 230, 150, 40);
        gender.setForeground(Color.white);
        male = new JCheckBox("Male");
        male.setFont(new Font("Arial", Font.BOLD, 15));
        male.setBounds(575, 230, 100, 20);
        female = new JCheckBox("Female", true);
        female.setFont(new Font("Arial", Font.BOLD, 15));
        female.setBounds(680, 230, 90, 20);

        EmployeeId = new JLabel("EMPLOYEE ID      : ");
        EmployeeId.setFont(new Font("Arial", Font.BOLD, 15));
        EmployeeId.setBounds(100, 380, 150, 40);
        EmployeeId.setForeground(Color.white);
        TemployId = new JLabel("" + employee);
        TemployId.setFont(new Font("Arial", Font.BOLD, 25));
        TemployId.setForeground(Color.white);
        TemployId.setBounds(250, 380, 200, 30);

        DataOfbirth = new JLabel("Data Of Birth : ");
        DataOfbirth.setFont(new Font("Arial", Font.BOLD, 15));
        DataOfbirth.setBounds(480, 270, 150, 40);
        DataOfbirth.setForeground(Color.white);
        todb = new JDateChooser();
        todb.setBounds(610, 270, 150, 30);
        add(DataOfbirth);
        add(todb);

        myEmail =new JLabel("ihsanahmed.bscsf23@siba-suk.edu.pk");
        myEmail.setFont(new Font("Arial", Font.BOLD, 25));
        myEmail.setForeground(green);
        myEmail.setBounds(20, 550, 600, 40);
        add(myEmail);


        button = new JButton("SUBMIT");
        button.addActionListener((ActionListener) this);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBounds(270, 450, 130, 40);
        button.setForeground(white);
        button.setBackground(green);
        button.setFocusable(false);
        butto1 = new JButton("CANCEL");
        butto1.addActionListener((ActionListener) this);
        butto1.setFont(new Font("Arial", Font.BOLD, 20));
        butto1.setBounds(410, 450, 130, 40);
        butto1.setForeground(WHITE);
        butto1.setBackground(red);
        butto1.setFocusable(false);
        button1 = new JButton("BACK");
        button1.addActionListener((ActionListener) this);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setBounds(550, 450, 130, 40);
        button1.setForeground(WHITE);
        button1.setBackground(black);
        button1.setFocusable(false);

        add(button);
        add(butto1);
        add(button1);
        add(firstName);
        add(TfirstName);
        add(middlename);
        add(Tmiddlename);
        add(lastname);

        add(Tlastname);

        add(Fathername);
        add(TFathername);
        add(CNIC);
        add(TCNIC);
        add(Gmail);
        add(TGmail);
        add(Salary);
        add(TSalary);
        add(Dsiganation);
        add(TDsiganation);
        add(Qulifaction);
        add(TQulifactiont);
        add(gender);
        add(male);
        add(female);
        add(EmployeeId);
        add(TemployId);
        myPanel.setBounds(0,0,900,700);
        myPanel.setLayout(null);
        myPanel.setBackground(Color.decode("#657873"));
        add(myPanel);

        setSize(900, 700);
        setLocation(180, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                // Get the values from the text fields
                int employeeId = Integer.parseInt(TemployId.getText());
                String firstName = TfirstName.getText();
                String middleName = Tmiddlename.getText();
                String lastName = Tlastname.getText();
                String fatherName = TFathername.getText();
                String cnic = TCNIC.getText();
                String email = TGmail.getText();
                String salary = TSalary.getText();
                String designation = (String) TDsiganation.getSelectedItem();
                String qualification = (String) TQulifactiont.getSelectedItem();
                String gender = male.isSelected() ? "Male" : "Female";
                java.util.Date dateOfBirth = todb.getDate();

                // Establish the database connection
                Connection connection = DBconnection.connector();

                // Construct the SQL query using PreparedStatement
                String query = "INSERT INTO Employees (EmployeeId, First_name, M_name, Last_name, F_name, CNIC, Email, Designation, Qualification, DateOfBirth, Gender, Salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                // Set the values for the query
                preparedStatement.setInt(1, employeeId);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, middleName);
                preparedStatement.setString(4, lastName);
                preparedStatement.setString(5, fatherName);
                preparedStatement.setString(6, cnic);
                preparedStatement.setString(7, email);
                preparedStatement.setString(8, designation);
                preparedStatement.setString(9, qualification);
                preparedStatement.setDate(10, new java.sql.Date(dateOfBirth.getTime()));
                preparedStatement.setString(11, gender);
                preparedStatement.setString(12, salary);

                // Execute the query
                preparedStatement.executeUpdate();

                // Show a success message
                JOptionPane.showMessageDialog(null, "Employee Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                // Print the SQL query and stack trace for debugging
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "There is something wrong! Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == button1) {
            dispose();
            new Home();
        } else if (e.getSource() == butto1) {
            // Clear the text fields
            TfirstName.setText("");
            Tmiddlename.setText("");
            Tlastname.setText("");
            TFathername.setText("");
            TCNIC.setText("");
            TSalary.setText("");
            TQulifactiont.getSelectedItem().equals("");
            TDsiganation.getSelectedItem().equals("");
            TGmail.setText("");
            todb.setDate(null);
        }
    }


    public static void main(String[] args) {

        new AddEmployeeForm();
    }
}

