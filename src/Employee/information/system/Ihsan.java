
package Employee.information.system;
import javax.swing.*;

public class Akhtar extends JFrame {

   Akhtar (){
        JFrame myframe=new JFrame();

        ImageIcon image=new ImageIcon(getClass().getResource("/myicon/front.gif"));
        JLabel label=new JLabel(image);
        label.setBounds(0,0,1000,650);
        myframe.add(label);

        myframe.setSize(1000,650);
        myframe.setLocation(100,40);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setVisible(true);


        try {
            Thread.sleep(5000);
            myframe.dispose();
            new Login();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

        new Akhtar();

    }
}

