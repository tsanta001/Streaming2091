package listener;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import affichage.*;
import client.*;

public class ListenerMusic implements MouseListener {

    public FenetreMusic fmusic;
    

    public ListenerMusic(FenetreMusic fm){
        this.fmusic=fm;
    }

    public void mouseClicked (MouseEvent e){

    JButton scr = (JButton)e.getSource();

        for(int i=0; i<fmusic.nbrHira; i++){
            if(scr.getText().equalsIgnoreCase(fmusic.musicName[i])){
                
                   // if(fmusic.btt[i].getText().equals("05. Perfect.mp3")){
                       System.out.println("mety");
                        try{
                            fmusic.client.oos.writeObject("music"+(i-1));
                            String message = fmusic.client.receve();
                            System.out.println("Message received:" + message);
                            fmusic.play(message);
                            fmusic.client.ois.close();
                            fmusic.client.oos.close();
                        }catch(Exception ex){
                            System.out.println(ex.getMessage());
                        }
            }
        } 

        if(scr.getText()=="Retour"){
            fmusic.setVisible(false);
            fmusic.dispose();
            try{
                fmusic.client.oos.writeObject("retourFenMusic");
                String message = fmusic.client.receve();
                System.out.println(message);
                fmusic.client.ois.close();
                fmusic.client.oos.close();
                Fenetre mus = new Fenetre();
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
