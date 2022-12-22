
package client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;

import affichage.*;

public class Client{

    private InetAddress host = InetAddress.getLocalHost();//(1)
    public Socket socket = null;
    public ObjectOutputStream oos = null;
    public ObjectInputStream ois = null;

    private Player player;
    //------------------------CONSTRUCTOR----------------------------------
    public Client() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        socket = new Socket(host.getHostName(), 9876);//(2)
        oos = new ObjectOutputStream(socket.getOutputStream());//(3)  
    }

    //------------------------FONCTION-------------------------------
    public String receve() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        
            ois = new ObjectInputStream(socket.getInputStream());//(4)
            String message= (String) ois.readObject();
            
        return message;
    }

    
    public void Activer() throws IOException, InterruptedException {
       
        new Thread() {
            @Override
            public void run() {
                try {
                    DataInputStream go=new DataInputStream(socket.getInputStream()); DataInputStream hira;
                   player = new Player(go);
                    new Thread() {
                        @Override
                        public void run() {
                            try {player.play();} catch (JavaLayerException e) {System.out.println(e.getMessage());}
                        }
                    }.start(); 

                } catch (IOException | JavaLayerException  ex) {
                    
                }
            }
        }.start();
    }

    public void arret(){
        if(player!=null){
            player.close();
        }
    }
    
}
