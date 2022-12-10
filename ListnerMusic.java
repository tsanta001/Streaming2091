package listener;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import affichage.*;
import client.*;

public class ListnerMusic implements MouseListener {

    public FenetreMusic fmusic;
    

    public ListnerMusic(FenetreMusic fm){
        this.fmusic=fm;
    }

    public void mouseClicked (MouseEvent e){

    JButton scr = (JButton)e.getSource();

        if(scr.getText()=="Stop"){    
            try{
                fmusic.stop();
                    fmusic.client.oos.writeObject("retourMusic");
                    String message = fmusic.client.receve();
                    System.out.println(message);
                    fmusic.client.ois.close();
                    fmusic.client.oos.close();
                    FenetreMusic photo = new FenetreMusic(message);
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
     }
  
    }        

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    } 

    public void mousePressed(MouseEvent e){

    } 

    public void mouseReleased(MouseEvent e){

    }
}
