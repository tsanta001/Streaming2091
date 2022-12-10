
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client{

    private InetAddress host = InetAddress.getLocalHost();//(1)
    public Socket socket = null;
    public ObjectOutputStream oos = null;
    public ObjectInputStream ois = null;


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
}
