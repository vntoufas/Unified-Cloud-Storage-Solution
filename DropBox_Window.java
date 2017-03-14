
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.dropbox.core.*;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxEntry.*;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import sun.java2d.loops.ProcessPath.ProcessHandler;
import java.io.*;
import java.nio.charset.Charset;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class DropBox_Window extends JFrame implements ActionListener  {

    private static final String DROP_BOX_APP_KEY = "562vgazel8cxk7y";
    private static final String DROP_BOX_APP_SECRET = "pax9jw99cpumgm7";
    JMenuItem item1 = new JMenuItem("Log in");
    JMenuItem item2 = new JMenuItem("Log out");
    JMenuItem item3 = new JMenuItem("Exit");
    DbxClient dbxClient;
     JLabel UserAccount = new JLabel("");
    JLabel FullCapacity = new JLabel("");
    JLabel SharedCapacity = new JLabel("");
    JLabel NormalCapacity = new JLabel("");
    JLabel kati = new JLabel("...");
    JButton listbutton=new JButton("List Files");
    JButton createfolder=new JButton("Create folder");
    JButton uploadfile=new JButton("Upload file");
    JTextArea foldname=new JTextArea();
    JFileChooser jfc=new JFileChooser();
    FileInputStream fis;
    
    public static String authAccessToken;
    java.io.File xyz = new java.io.File("SavedAuthCode.txt");
    java.io.File abc = new java.io.File("SavedToken.txt");
    private static String dropboxAuthCode;
    private static com.dropbox.core.DbxAuthFinish authFinish;
    private static com.dropbox.core.DbxWebAuthNoRedirect dbxWebAuthNoRedirect;
    //com.dropbox.core.DbxAuthFinish authFinish = null;
    
    public DropBox_Window()throws IOException, DbxException {
        DbxEntry dbxe;
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(5,2,10,10));
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Manage Access");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menuBar.add(menu);
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        listbutton.addActionListener(this);
        createfolder.addActionListener(this);
        jfc.addActionListener(this);
        uploadfile.addActionListener(this);
        JFrame DropboxWindow = new JFrame();
        DropboxWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DropboxWindow.setSize(800, 640);
        
        
        
        DropboxWindow.setJMenuBar(menuBar);
        UserAccount.setText("user account");
        NormalCapacity.setText("full capacity");
        UserAccount.setBounds(10, 10, 170, 30);
        FullCapacity.setBounds(10, 40, 270, 30);
        NormalCapacity.setBounds(10, 70, 170, 30);
        SharedCapacity.setBounds(10, 100, 170, 30);
        kati.setBounds(10, 130, 230, 30);
        listbutton.setBounds(10,150,50,50);
       
        panel.add(UserAccount);
        panel.add(FullCapacity);
        panel.add(NormalCapacity);
        panel.add(SharedCapacity);
        panel.add(kati);
        panel.add(listbutton);
        panel.add(createfolder);
        panel.add(foldname);
        panel.add(jfc);
        panel.add(uploadfile);
        DropboxWindow.setVisible(true);
        panel.setBounds(1,1,798,600);
        DropboxWindow.add(panel);
        pack();

    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if (source == item1) {

            if (this.xyz.exists()) {
                 try {
                    InputStream fis = null;
                    String a;
                    try {
                       fis = new FileInputStream(abc);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                       } 
                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                    BufferedReader br = new BufferedReader(isr);
                    String c;

                     String s;
                    FileInputStream fis2 = new FileInputStream(xyz);
                      InputStreamReader isr2 = new InputStreamReader(fis2, Charset.forName("UTF-8"));
                     
                    BufferedReader br2 = new BufferedReader(isr2);
                    while (( s = br2.readLine()) != null) {
                      dropboxAuthCode=s;
                      System.out.println("--------auth code-------> "+DropBox_Window.dropboxAuthCode);  
                    }

                    while (( c = br.readLine()) != null) {
                        authAccessToken=c;
                        System.out.println("--------access token-------> "+DropBox_Window.authAccessToken);  
                    }
                    
                    
                    
                    DbxRequestConfig dbxRequestConfig = new DbxRequestConfig("JavaDropboxTutorial/1.0", Locale.getDefault().toString());
                     dbxClient = new DbxClient(dbxRequestConfig, DropBox_Window.authAccessToken);
                    System.out.println("test10");
                    br.close();
                    isr.close();
                    fis.close();
                     System.out.println("test11 "+DropBox_Window.authAccessToken);
                    
                } catch (IOException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
                
                
                    System.out.println("test12 (Token)..."+authAccessToken);
                   
                    System.out.println("test13(AuthCode)..."+dropboxAuthCode);
                    DbxRequestConfig dbxRequestConfig = new DbxRequestConfig("JavaDropboxTutorial/1.0", Locale.getDefault().toString()); 
                   // DropBox_Window.dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(dbxRequestConfig, dbxAppInfo);
                    //authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
                    dbxClient = new DbxClient(dbxRequestConfig, authAccessToken);
                    System.out.println("test13(AuthCode).bb-->"+dropboxAuthCode);
                
                 
                
                    //authAccessToken = authFinish.accessToken;
                 //DbxRequestConfig dbxRequestConfig = new DbxRequestConfig("JavaDropboxTutorial/1.0", Locale.getDefault().toString());

                    dbxClient = new DbxClient(dbxRequestConfig, authAccessToken);
                try {
                    UserAccount.setText("Welcone "+dbxClient.getAccountInfo().displayName);
                    FullCapacity.setText("Total Dropbox capacity: "+getDropboxSize());
                   // NormalCapacity.setText("Ssed Capacity: ")
                } catch (DbxException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    System.out.println("This->"+dbxClient.getAccountInfo().displayName);
                } catch (DbxException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else{
                         
                    DbxAppInfo dbxAppInfo = new DbxAppInfo(DROP_BOX_APP_KEY, DROP_BOX_APP_SECRET);
                    DbxRequestConfig dbxRequestConfig = new DbxRequestConfig("JavaDropboxTutorial/1.0", Locale.getDefault().toString());
                    dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(dbxRequestConfig, dbxAppInfo);
                   System.out.println("Yolo1");
                    String authorizeUrl = dbxWebAuthNoRedirect.start();
                    try { System.out.println("Yolo2");
                        Desktop.getDesktop().browse(new URL(authorizeUrl).toURI()); }
                    catch (Exception e) {}
                    //System.out.println("1. Authorize: Go to URL and click Allow : " + );
                    JTextArea authlink=new JTextArea();
                    authlink.setText(authorizeUrl);
                    JOptionPane.showMessageDialog(null, authlink);
                    FileOutputStream is = null;
                    
                try {
                    is = new FileOutputStream(xyz);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                    BufferedOutputStream out=new BufferedOutputStream(is);
                    dropboxAuthCode=JOptionPane.showInputDialog("Copy authorization code and input here");

                try {
                    out.write(dropboxAuthCode.getBytes("UTF-8"));
                    
                     
                } catch (IOException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println("this is the authCode -> "+dropboxAuthCode);
                try {
                    out.close();
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                     authFinish = null;
                try {
                    authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
                } catch (DbxException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                    authAccessToken = authFinish.accessToken;
                    System.out.println("This is the token -> "+authAccessToken);
            dbxClient = new DbxClient(dbxRequestConfig, authAccessToken);
            
            
                    FileOutputStream is2 = null;
                try {
                    is2 = new FileOutputStream(abc);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                    BufferedOutputStream out2=new BufferedOutputStream(is2);
                    System.out.println("This is the token AGAIN-> "+authAccessToken);
                try {
                    out2.write(authAccessToken.getBytes("UTF-8"));
                } catch (IOException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    out2.close();
                } catch (IOException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    is2.close();
                } catch (IOException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    UserAccount.setText(dbxClient.getAccountInfo().displayName);
                } catch (DbxException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    System.out.println("This->"+dbxClient.getAccountInfo().displayName);
                } catch (DbxException ex) {
                    Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
                }       
       }
            }
        else if (source==item2){
            int choice=0;
           choice=JOptionPane.showConfirmDialog(null, "Are you sure you want to Log out?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           if (choice==JOptionPane.NO_OPTION)
                   return;
           else {abc.delete();
                    xyz.delete();}
    }
        else if (source==item3){
        System.exit(0);
        }
        else if (source==listbutton){
            try {
                
                listDropboxFolders("/");
            } catch (DbxException ex) {
                Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(source==createfolder){
        
            try {
                createFolder(foldname.getText());
            } catch (DbxException ex) {
                Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        else if(source==uploadfile){
        
            try {
               //java.io.File selectedfile= new java.io.File(jfc.toString()); 
               java.io.File selectedFile = jfc.getSelectedFile();
                System.out.println("Auto 1 "+jfc.toString());
                //filename=jfc.getFileSelectionMode();
                uploadToDropbox(selectedFile.toString());
                
                //uploadToDropbox
            } catch (DbxException ex) {
                Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DropBox_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }
    
    
    public void createFolder(String folderName) throws DbxException {
		dbxClient.createFolder("/" + folderName);
	}
    
    public void listDropboxFolders(String folderPath) throws DbxException {
		DbxEntry.WithChildren listing = dbxClient.getMetadataWithChildren(folderPath);
		System.out.println("Files List:");
		//DbxEntry child=null;
                
                for (DbxEntry child : listing.children){
                    System.out.println(child.name);
                }//" : "+child.toString()+" "
                
                //for ( DbxEntry child : listing.children) {
		//	System.out.println("	" + child.name + ": " + child.toString());
		//}
	}
    
    public void uploadToDropbox(String fileName) throws DbxException,IOException {
        java.io.File inputFile = new java.io.File(fileName);
        System.out.println(fileName);		 
    fis = new FileInputStream(fileName);
                System.out.println("eftase mehri edo");
		try {
                DbxEntry.File uploadedFile = dbxClient.uploadFile("/" + fileName,DbxWriteMode.add(), inputFile.length(), fis);
		//String sharedUrl = dbxClient.createShareableUrl("/" + uploadedFile);
                String sharedUrl=dbxClient.createShareableUrl("/"+uploadedFile);
                System.out.println("This is the sharable url -> "+sharedUrl);
		System.out.println("Uploaded:....--> " + uploadedFile.toString());
		} finally {
			fis.close();
		}
	}
    
    public String getDropboxSize() throws DbxException {
		long dropboxSize = 0;
                long size2=0;
		DbxAccountInfo dbxAccountInfo = dbxClient.getAccountInfo();
		// in GB :)
                size2=dbxClient.getAccountInfo().quota.shared/1024/1024;
                long size3=dbxClient.getAccountInfo().quota.normal/1024/1024;
		dropboxSize = dbxAccountInfo.quota.total / 1024 / 1024;
               // System.out.println(dbxAccountInfo.email);
                //dbxAccountInfo.
                System.out.println(dropboxSize);
                String s=""+dropboxSize+" Mb";
                System.out.println("shared = "+size2);
                System.out.println("normal = "+size3);
		FullCapacity.setText(""+dbxAccountInfo.quota.total / 1024 / 1024);
                NormalCapacity.setText("Used "+dbxAccountInfo.quota.normal / 1024 / 1024);
                SharedCapacity.setText("Sharing "+dbxAccountInfo.quota.shared / 1024 / 1024+" with others");
                return s;
	}
}