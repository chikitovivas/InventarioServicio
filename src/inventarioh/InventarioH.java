/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventarioh;

import interfazNueva.Index;
import static inventarioh.InventarioH.VentanaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 */
public class InventarioH {

    /**
     * @param args the command line arguments
     */
    static Index VentanaPrincipal = new Index();
    
    public static void main(String[] args) {     
        /*Look And Feel de Windows para el programa*/
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());  
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(InventarioH.class.getName()).log(Level.SEVERE, null, ex);
        }
        VentanaPrincipal.setVisible(true);
        
    }
        
        
    

 
    
    
}
