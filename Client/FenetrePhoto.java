package affichage;

import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;

import client.*;
import listener.*;

public class FenetrePhoto extends JFrame{

    public Client client; 
    public String[] photoName;
    public JButton[] bttp;
    public int nbrPhoto;

    public FenetrePhoto(String message) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        client = new Client();

        this.setTitle("Fenetre Photo");
		this.setSize(900, 675);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ListenerPhoto lm=new ListenerPhoto(this);
 
        JPanel panel = new JPanel();
        photoName= message.split("/");
        nbrPhoto=photoName.length;

        panel.setLayout(new BorderLayout());
             //panel.setLayout(new GridLayout(nbrHira,0));

        JPanel titre = new JPanel();
               titre.setLayout(new BorderLayout());
        JLabel lbl1=new JLabel("IMAGE");
              titre.add(lbl1,BorderLayout.WEST);
              panel.add(titre,BorderLayout.NORTH);

        JPanel list = new JPanel();
            list.setLayout(new GridLayout(nbrPhoto,0));

            bttp= new JButton[nbrPhoto];

             
             for(int i=0; i<nbrPhoto; i++){
                if(i>0){
                  //  String st="Photo "+(i);
                   bttp[i]=new JButton(photoName[i]);
                   bttp[i].addMouseListener(lm);
                    list.add(bttp[i]);
                  ///  str[i] = new String(st);
                }
                
             }

             panel.add(list,BorderLayout.CENTER);

             ListenerPhoto li=new ListenerPhoto(this);
            JButton btn=new JButton("Retour");
                    panel.add(btn,BorderLayout.SOUTH);
                    btn.addMouseListener(li);
                      
     //   panel.add(bout(),BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);

    }

//----------------------------------FONCTION---------------------------------------
   
    

}