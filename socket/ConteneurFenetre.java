   
import javax.swing.*;

public class ConteneurFenetre extends JPanel {

    
    int ALLBITS;
    int ABORT;
    String name;

    public ConteneurFenetre(){

    }

    public JButton bouton(int ALLBITS,int ABORT,String name){
        JButton bout= new JButton(name);
        bout.setBounds(ALLBITS, ABORT, 100, 40);
        //bout.setName(name);
        return bout;
    }
        
//-----------------------------------------------------------------------------------------------------------------------

}