package listener;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import affichage.*;
import client.*;

public class ListenerPhoto implements MouseListener {

    public FenetrePhoto fphoto;

    public ListenerPhoto(FenetrePhoto fp){
        this.fphoto=fp;
    }

    public void mouseClicked (MouseEvent e){

    JButton scr = (JButton)e.getSource();

                for(int i=0;i<fphoto.nbrPhoto;i++){

                if(scr.getText().equalsIgnoreCase(fphoto.photoName[i])){
                    try{
                        fphoto.client.oos.writeObject("photo"+(i-1));
                        //fphoto.client.receves();
                        String message = fphoto.client.receve();
                        System.out.println(message);
                        fphoto.client.ois.close();
                        fphoto.client.oos.close();
                        Image img = new Image(message);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }

            if(scr.getText()=="Retour"){
                fphoto.setVisible(false);
                fphoto.dispose();
                try{
                    fphoto.client.oos.writeObject("retourFenPhoto");
                    String message = fphoto.client.receve();
                    System.out.println(message);
                    fphoto.client.ois.close();
                    fphoto.client.oos.close();
                    Fenetre photo = new Fenetre();
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