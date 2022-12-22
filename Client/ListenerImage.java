package listener;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import affichage.*;
import client.*;

public class ListenerImage implements MouseListener {


    public Image img;


    public ListenerImage(Image img){
        this.img=img;
    }


//-----------------FONCTION--------------------------------
    public void mouseClicked (MouseEvent e){
        JButton scr = (JButton)e.getSource();

            if(scr.getText()=="Retour"){
                img.setVisible(false);
                img.dispose();
                try{
                    img.client.oos.writeObject("retourPhoto");
                    String message = img.client.receve();
                    System.out.println(message);
                    img.client.ois.close();
                    img.client.oos.close();
                    FenetrePhoto photo = new FenetrePhoto(message);
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
