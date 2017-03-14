
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Billy
 */
public class SaveAuth {
    File saveddropbox=new File("SavedToken.dat");
    
    public SaveAuth(){
        

    }
public boolean FileExists(){
if (saveddropbox.exists()){return true;}
else return false;
}
    
    
    
    
}
