
import com.dropbox.core.DbxException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;


public class SelectAccount extends JFrame implements ActionListener{
    
    
    String user1;
    String pass1;
    String user2;
    String pass2;
    String user3;
    String pass3;
    String Service1Name="Dropbox";
    String Service2Name="Google Drive";
    String Service3Name="Amazon Drive";
    JButton Service1Button=new JButton(Service1Name+" Login");
    JButton Service2Button=new JButton(Service2Name+" Login");
    JButton Service3Button=new JButton(Service3Name+" Login");
    JTextField Service1Username=new JTextField();
    JPasswordField Service1pass=new JPasswordField();
    JTextField Service2Username=new JTextField();
    JPasswordField Service2pass=new JPasswordField();
    JTextField Service3Username=new JTextField();
    JPasswordField Service3pass=new JPasswordField();
    File x=new File("demo.txt");
    
   public SelectAccount(){

    
    Service1pass.setEchoChar('*');
    Service2pass.setEchoChar('*');
    Service3pass.setEchoChar('*');
    
    JFrame aWindow = new JFrame ("DropGooZon");
    aWindow.setBackground(Color.black);
    int dim=40;
    int windowWidth = 700;          
    int windowHeight = 800;          
    aWindow.setSize(windowWidth, windowHeight);  
    aWindow.setVisible(true);  
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aWindow.setLayout(new GridLayout(3,1,10,10));
    ///////////////////////////////////////////////////////
    ///////////////////Service 1 Panel/////////////////////
    JPanel Service1Panel=new JPanel();
    Service1Panel.setLayout(new GridLayout(3,2,10,10));
    Service1Panel.setBackground(Color.yellow);
    JLabel Service1UsernameLabel=new JLabel(Service1Name+ "Username");
    JLabel Service1pass_label=new JLabel(Service1Name+" Password");
    
    
    Service1Panel.add(Service1UsernameLabel);
    Service1Panel.add(Service1Username);
    Service1Panel.add(Service1pass_label);
    Service1Panel.add(Service1pass);
    //GLogin.setPreferredSize(new Dimension(dim, dim));
    Service1Panel.add(Service1Button);
    Service1Button.addActionListener(this);
    
   //////////////////////////////////////////////////////////
    //////////////Service 2 Panel///////////////////////////////
    
    JPanel Service2Panel=new JPanel();
    Service2Panel.setLayout(new GridLayout(3,2,10,10));
    Service2Panel.setBackground(Color.red);
    JLabel Service2UsernameLabel=new JLabel(Service2Name+ "Username");
    JLabel Service2pass_label=new JLabel(Service2Name+" Password");
    
    Service2Panel.add(Service2UsernameLabel);
    Service2Panel.add(Service2Username);
    Service2Panel.add(Service2pass_label);
    Service2Panel.add(Service2pass);
    //GLogin.setPreferredSize(new Dimension(dim, dim));
    Service2Panel.add(Service2Button);
    Service2Button.addActionListener(this);
    
     //////////////////////Third Provider///////////////
    
     JPanel Service3Panel=new JPanel();
    Service3Panel.setLayout(new GridLayout(3,2,10,10));
    Service3Panel.setBackground(Color.green);
    JLabel Service3UsernameLabel=new JLabel(Service3Name+ "Username");
    JLabel Service3pass_label=new JLabel(Service3Name+" Password");
  
    
    Service3Panel.add(Service3UsernameLabel);
    Service3Panel.add(Service3Username);
    Service3Panel.add(Service3pass_label);
    Service3Panel.add(Service3pass);
    Service3Button.setPreferredSize(new Dimension(dim, dim));
    Service3Panel.add(Service3Button);
    Service3Button.addActionListener(this);
     
    
    ///////////////////////////////////////////////////////////////
    aWindow.add(Service1Panel);
    aWindow.add(Service2Panel);
    aWindow.add(Service3Panel);
      
    
    
    
     aWindow.pack();
}

   public void actionPerformed(ActionEvent evt) { 
       Object source = evt.getSource();
if (source==Service1Button) {
           try {
               DropBox_Window dbw=new DropBox_Window();
               System.out.println(Service1Username.getText());
               System.out.println(Service1pass.getPassword());
           } catch (IOException ex) {
               Logger.getLogger(SelectAccount.class.getName()).log(Level.SEVERE, null, ex);
           } catch (DbxException ex) {
               Logger.getLogger(SelectAccount.class.getName()).log(Level.SEVERE, null, ex);
           }
}
else if (source==Service2Button){
   
    System.out.println(Service2Username.getText());
    System.out.println(Service2pass.getText());
}
else if (source==Service3Button){
    
    System.out.println(Service3Username.getText());
    System.out.println(Service3pass.getText());
}
}
    
   
}
