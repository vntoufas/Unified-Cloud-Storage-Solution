
import java.awt.Desktop;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billy
 */
public class DropGooZon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    try {
    Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
} catch (Exception e) {}
}
        SelectAccount newac=new SelectAccount();
        
    }
    

