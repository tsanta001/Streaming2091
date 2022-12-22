package listener;

import java.awt.event.*;
import javax.swing.*;

import affichage.*;
import client.*;

public class Listener implements MouseListener{
    public Fenetre fen;

    public Listener(Fenetre f){
        this.fen = f;
    }

    public void mouseClicked(MouseEvent e){
        JButton scr = (JButton)e.getSource();

        if(scr.getText() == "Music"){
            try{
                fen.client.oos.writeObject("music");
                String message = fen.client.receve();
                //System.out.println(message);
                fen.client.ois.close();
                fen.client.oos.close();
                FenetreMusic music = new FenetreMusic(message);
                   
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        if(scr.getText() == "Image"){
            try{
                fen.client.oos.writeObject("photo");
                String message = fen.client.receve();
                fen.client.ois.close();
                fen.client.oos.close();
                FenetrePhoto photo = new FenetrePhoto(message);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        if(scr.getText() == "Video"){
            try{
                fen.client.oos.writeObject("video");
                String message = fen.client.receve();
                fen.client.ois.close();
                fen.client.oos.close();
                //ListVideo video = new ListVideo(message);
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