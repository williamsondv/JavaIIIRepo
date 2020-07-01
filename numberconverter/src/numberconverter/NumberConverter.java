

package numberconverter;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 numberConverter will convert decimal, hexadecimal and binary numbers with one another using a Java Swing UI.
 */
public class NumberConverter {
    

   
    public static void main(String[] args) {
    
    EventQueue.invokeLater(() -> {
    //Add and run menu
    Menu numConMenu = new Menu();
    numConMenu.setVisible(true);
    numConMenu.add(numConMenu.panel);
    
});
    }
    
}
