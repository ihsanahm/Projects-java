package Employee.information.system;
import com.example.projects.DBconnection;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.awt.Color.*;

public class UpdateEmployee extends JFrame implements ActionListener  {

    JLabel firstName, middlename, lastname, Fathername, CNIC, Gmail, Salary, Dsiganation, EmployeeId;
    JTextField TGmail, TSalary;
    JLabel  TfirstName, Tmiddlename, Tlastname, TFathername, TCNIC;
    JLabel TemployId;
    JLabel Qulifaction, DataOfbirth, gender;
    JComboBox TQulifactiont,TDsiganation;
    JCheckBox male, female;

    JButton Update, butto1;
    JButton button1;
    JLabel todb;
    JPanel mypanel;
    JLabel myEmail;
    String number;
    UpdateEmployee (String number)
    {
        this.number=number;
        JLabel heading = new JLabel("UPDATE EMPLOYEE DETAIL");
        heading.setBounds(230, 30, 500, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(white);
        add(heading);
         mypanel=new JPanel();
        firstName = new JLabel("FIRST NAME");
        firstName.setFont(new Font("Arial", Font.BOLD, 15));
        firstName.setBounds(100, 90, 150, 40);
        firstName.setForeground(white);
         TfirstName = new JLabel();
        TfirstName.setFont(new Font("Arial", Font.BOLD, 15));
        TfirstName.setBounds(250, 90, 200, 30);
        middlename = new JLabel("MIDDLE NAME");
        middlename.setFont(new Font("Arial", Font.BOLD, 15));
        middlename.setBounds(100, 130, 150, 40);
        middlename.setForeground(white);
         Tmiddlename = new JLabel();
        Tmiddlename.setFont(new Font("Arial", Font.BOLD, 15));
        Tmiddlename.setBounds(250, 130, 200, 30);

        lastname = new JLabel("LAST NAME");
        lastname.setFont(new Font("Arial", Font.BOLD, 15));
        lastname.setBounds(100, 170, 150, 40);
        lastname.setForeground(WHITE);
         Tlastname = new JLabel();
        Tlastname.setBounds(250, 170, 200, 30);
        Tlastname.setFont(new Font("Arial", Font.BOLD, 15));
        Fathername = new JLabel("FATHER NAME");
        Fathername.setFont(new Font("Arial", Font.BOLD, 15));
        Fathername.setBounds(100, 210, 150, 40);
        Fathername.setForeground(white);
         TFathername = new JLabel();
        TFathername.setFont(new Font("Arial", Font.BOLD, 15));
        TFathername.setBounds(250, 210, 200, 30);

        CNIC = new JLabel("CNIC ");
        CNIC.setFont(new Font("Arial", Font.BOLD, 15));
        CNIC.setBounds(475, 90, 150, 40);
        CNIC.setForeground(white);

         TCNIC = new JLabel();
        TCNIC.setFont(new Font("Arial", Font.BOLD, 15));
        TCNIC.setBounds(570, 90, 200, 30);
        Gmail = new JLabel("GMAIL");
        Gmail.setFont(new Font("Arial", Font.BOLD, 15));
        Gmail.setBounds(475, 130, 150, 40);
        Gmail.setForeground(white);
        TGmail = new JTextField();
        TGmail.setFont(new Font("Arial", Font.BOLD, 15));
        TGmail.setBounds(570, 130, 200, 30);

        Salary = new JLabel("SALARY");
        Salary.setFont(new Font("Arial", Font.BOLD, 15));
        Salary.setBounds(475, 170, 150, 40);
        Salary.setForeground(white);
        TSalary = new JTextField();
        TSalary.setFont(new Font("Arial", Font.BOLD, 15));
        TSalary.setBounds(570, 170, 200, 30);
        Dsiganation = new JLabel("DESIGNATION ");
        Dsiganation.setFont(new Font("Arial", Font.BOLD, 15));
        Dsiganation.setBounds(100, 250, 150, 40);
        Dsiganation.setForeground(white);
        String job[]={"HRM", "Manager", "Engineer", "Computer operator","Head of Department","Worker"};
        TDsiganation = new JComboBox(job);
        TDsiganation.setFont(new Font("Arial", Font.BOLD, 15));
        TDsiganation.setBounds(250, 250, 200, 30);

        Qulifaction = new JLabel("QUALIFICATION");

        Qulifaction.setFont(new Font("Arial", Font.BOLD, 15));

        Qulifaction.setBounds(450, 210, 150, 40);
        Qulifaction.setForeground(white);
        String course[]={"BBA","BSCS","AC","Be.d","PHD","EE","CSE","SE","AI","MBA","B.com"};
        TQulifactiont = new JComboBox(course);

        TQulifactiont.setFont(new Font("Arial", Font.BOLD, 15));
        TQulifactiont.setBounds(570, 210, 200, 30);

        gender = new JLabel("GENDER");
        gender.setFont(new Font("Arial", Font.BOLD, 15));
        gender.setBounds(475, 250, 150, 40);
        gender.setForeground(white);
        male = new JCheckBox("Male");
        male.setFont(new Font("Arial", Font.BOLD, 15));
        male.setBounds(575, 260, 100, 20);
        female = new JCheckBox("Female");
        female.setFont(new Font("Arial", Font.BOLD, 15));
        female.setBounds(680, 260, 90, 20);

       EmployeeId = new JLabel("EMPLOYEE ID ");
       EmployeeId.setFont(new Font("Arial", Font.BOLD, 15));
       EmployeeId.setBounds(100, 290, 150, 40);
       EmployeeId.setForeground(white);
      TemployId = new JLabel(number);
      TemployId.setFont(new Font("Arial", Font.BOLD, 25));
      TemployId.setForeground(white);
      TemployId.setBounds(250, 290, 200, 30);

        DataOfbirth = new JLabel("Data Of Birth ");
        DataOfbirth.setFont(new Font("Arial", Font.BOLD, 15));
        DataOfbirth.setBounds(460, 290, 150, 40);
        DataOfbirth.setForeground(white);
        todb = new JLabel();
        todb.setBounds(610, 290, 150, 30);
        add(DataOfbirth);
        add(todb);
        try {
            Connection conn= DBconnection.connector();
            String query="SELECT * FROM Employees WHERE EmployeeId='"+number+"'";
            ResultSet resultSet= conn.createStatement().executeQuery(query);
            while (resultSet.next())
            {
                TfirstName.setText(resultSet.getString("First_Name"));
                Tmiddlename.setText(resultSet.getString("M_name"));
                Tlastname.setText(resultSet.getString("Last_name"));
                TFathername.setText(resultSet.getString("F_name"));
                TCNIC.setText(resultSet.getString("CNIC"));
                TGmail.setText(resultSet.getString("Email"));
                TSalary.setText(resultSet.getString("Salary"));
                TDsiganation.getSelectedItem();
                TQulifactiont.getSelectedItem();
                TemployId.setText(resultSet.getString("EmployeeId"));

               // todb.setText(String.valueOf(resultSet.getString("DataOfbirth")));

                if(resultSet.getString("Gender").equals("Male"))
                    male.setSelected(true);
                else
                    female.setSelected(true);

            }

        }
        catch (Exception e)
        {
            e.getStackTrace();
        }



        myEmail =new JLabel("ihsanahmed.bscsf23@siba-suk.edu.pk");
        myEmail.setFont(new Font("Arial", Font.BOLD, 20));
        myEmail.setForeground(blue);
        myEmail.setBounds(20, 550, 600, 40);
        add(myEmail);


       Update = new JButton("UPDATE");
       Update.addActionListener((ActionListener) this);
        Update.setFont(new Font("Arial", Font.BOLD, 20));
        Update.setBounds(10, 10, 120, 30);
        Update.setForeground(WHITE);
        Update.setBackground(GREEN);
        Update.setFocusable(false);
        butto1 = new JButton("CANCEL");
        butto1.addActionListener((ActionListener) this);
        butto1.setFont(new Font("Arial", Font.BOLD, 20));
        butto1.setBounds(510, 390, 120, 30);
        butto1.setForeground(new Color(87, 89, 12));
        butto1.setBackground(RED);
        butto1.setFocusable(false);
        button1 = new JButton("BACK");
       button1.addActionListener((ActionListener) this);
        button1.setFont(new Font("Arial", Font.BOLD, 20));
        button1.setBounds(650, 390, 120, 30);
        button1.setForeground(new Color(87, 89, 12));
        button1.setBackground(black);
        button1.setFocusable(false);
        add(Update);
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
        mypanel=new JPanel();
        mypanel.setBounds(0,0,900,700);
        mypanel.setLayout(null);
        mypanel.setBackground(decode("#756e5a"));

        add(mypanel);
        setSize(900, 700);
        setLocation(150, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Update) {
            String Salary = TSalary.getText();
            String Email = TGmail.getText();
            String Designation = (String) TDsiganation.getSelectedItem();
            String Qualification = (String) TQulifactiont.getSelectedItem();
            try (Connection conn = DBconnection.connector()) {
                if (conn == null || conn.isClosed()) {
                    System.err.println("Error: Connection is null or closed.");
                    JOptionPane.showMessageDialog(null, "Error: Connection is null or closed.");
                    return;
                }
                String query = "UPDATE Employees SET Salary=?, Email=?, Designation=?, Qualification=? WHERE EmployeeId=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, Salary);
                stmt.setString(2, Email);
                stmt.setString(3, Designation);
                stmt.setString(4, Qualification);
                stmt.setString(5, number);
                var rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Employee data updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No employee found with the given ID.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating employee data: " + ex.getMessage());
            }
        } else if (e.getSource() == butto1) {
            TSalary.setText("");
            TQulifactiont.getSelectedItem().equals("");
            TDsiganation.getSelectedItem().equals("");
            TGmail.setText("");
        } else if (e.getSource() == button1) {
            dispose();
            new ViewEmployee();
        }
    }
     public static  void main(String[] args)
    {
        new UpdateEmployee(" ");
    }
}
