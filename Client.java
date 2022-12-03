

package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
       
        InetAddress host = InetAddress.getLocalHost();//(1)
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for(int i=0; i<2;i++){
            
            socket = new Socket(host.getHostName(), 9876);//(2)
            
            oos = new ObjectOutputStream(socket.getOutputStream());//(3)
            System.out.println("Sending request to Socket Server");
           // if(i==4)oos.writeObject("exit");
          //  else 
            String message= "Tsanta";
            if(i==0)
                oos.writeObject(message);
            else
                oos.writeObject("play music");



           //-------------------------------------------------------------
            ois = new ObjectInputStream(socket.getInputStream());//(4)
            String musicName = (String) ois.readObject();

            String[] TableauMusic= musicName.split("/");//MANASARAKA SORATRA;

            for(int j=0; j<TableauMusic.length;j++){
                System.out.println(TableauMusic[j]);
            }
           
           
            ois.close();//(5)
            oos.close();
            Thread.sleep(100);
        }
    }
}
//(1) //obtient l'adresse IP de l'hôte local, si le serveur fonctionne sur une autre IP, vous devez l'utiliser.
//(2)//establish socket connection to server
//(3)//écrire sur le socket en utilisant ObjectOutputStream
//(4) //read the server response message
//(5) //close resources

