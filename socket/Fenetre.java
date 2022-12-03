
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.text.FlowView;


public class Fenetre extends JFrame{


ConteneurFenetre pan=new ConteneurFenetre();
           

    public Fenetre(){
        this.setSize(700, 700);//Taille de la Fenetre
        this.setResizable(false);//Pour qu'on puisse pas redimentionner la fenetre
        this.setLocationRelativeTo(null);//Centrer a l'ecran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Pour que le programe s'arrete bien apres avoir cliquer sur X
        this.setAlwaysOnTop(true);//Rester au dessus de tout les fenetre pour ne pas la perdre deriere
        this.setVisible(true);
        this.add(pan); 

        //Manambatra Fenetre @ Contenue Fenetre
       /* JPanel contentPane=(JPanel) this.getContentPane();
                contentPane.setLayout(new BorderLayout());
                contentPane.add(CreateNorth(), BorderLayout.NORTH);*/ 
               

                public JToolBar CreateNorth(){
                    JToolBar pane=new JToolBar();

                    JButton btn1 =new JButton("Photo");
                        pane.add(btn1);
                        
                    return pane;
                   }

            JPanel panel =new JPanel();
                panel.setLayout(new BorderLayout());
                panel.add(CreateNorth(), BorderLayout.NORTH);


    }
        
}
