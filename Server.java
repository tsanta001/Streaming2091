package server;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import javazoom.jl.player.Player;

public class Server{
    private static ServerSocket server;  
    private static int port = 9876;//(1)
    private static File music = new File("E:/Code NAINA/SOCKET PROJET/hira");
    private static File[] listeMusic= music.listFiles();
    private static int nbrAudio= listeMusic.length;
    private static String musicName=new String();
    private static Player player;
    
    //-------------------FONCCTION-----------------------------
    public static void play(File mp3){
        try {
            FileInputStream fis =new FileInputStream(mp3);
            BufferedInputStream bis= new BufferedInputStream(fis);
                player=new Player(bis);

        } catch (Exception e) {
        }
        

            new Thread(){ //GESTION PARAMETRE
                @Override
                public void run(){
                    try {
                        player.play();

                    } catch (Exception e) {
                    }
                }
            }.start();
    }

    public static void stop(){
        if(player!=null){player.close();}
    }

//--------------------------------------------------------------------

    public static void main(String args[]) throws IOException, ClassNotFoundException{

        server = new ServerSocket(port);//(2)

       //server>socket>ois.read()>message

        while(true){//(3)
            System.out.println("Waiting for the client request");
           
            Socket socket = server.accept();//(4)

            
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());//(5) // OBJ MIDITRA AO AM SERVEUR 
            
            String message = (String) ois.readObject();//(6)
            System.out.println("Message Received: " + message);

            //server>socket>oos.write()



     //-------------------------------------------------------------------------------------------


            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//(7)
            if(message.equals("Tsanta")){
                for(int i=0; i<nbrAudio; i++){
                    musicName = musicName + "/" + listeMusic[i].getName();
                }
                oos.writeObject(musicName);//(8)
            }else{
                play(listeMusic[0]);
            }
            ois.close();//(9)
            oos.close();
            socket.close();
           
           if(message.equalsIgnoreCase("exit")) break;//(10)
        }
        System.out.println("Shutting down Socket server!!");
        server.close();//(11)
    }
}

//(1)port du serveur de socket sur lequel il écoutera
//(2)  //créer l'objet serveur de socket
//(3) //Le gardien écoute indéfiniment jusqu'à ce qu'il reçoive l'appel 'exit' ou que le programme se termine.
//(4) //creating socket and waiting for client connection
//(5) //lire depuis le socket vers l'objet ObjectInputStream
//(6)//convertir un objet ObjectInputStream en String
//(7)//créer l'objet ObjectOutputStream
//(8) //écriture de l'objet dans le Socket
//(9)//ferme les ressources
//(10) //terminate the server if client sends exit request
//(11)//close the ServerSocket object


