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

import listener.*;

public class Server{
    private static ServerSocket server;  
    private static int port = 9876;//(1)

    private static String pathName= System.getProperty("user.dir");
    private static String path= pathName.replace("\\","/");
    private static String pathMusic= path +"/hira";
    private static String pathPhoto= path +"/photo";

    private static File music = new File(pathMusic);
    private static File[] listeMusic= music.listFiles();
    private static int nbrAudio= listeMusic.length;
    private static String musicName = new String();

    private static File photo = new File(pathPhoto);
    private static File[] listePhoto= photo.listFiles();
    private static int nbrPhoto= listePhoto.length;
    private static String photoName = new String();

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);

        while(true){
            System.out.println("Waiting for the client request");

            Socket socket = server.accept();

            //--------------------------------------------------------------------------------------

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
           // System.out.println("Message received:" + message);

            //---------------------------------------------------------------------------------------

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            //----------------------------------------------------------------
        
                if(message.equalsIgnoreCase("music")){
                    musicName = new String();
                    for(int i=0; i<nbrAudio; i++){
                        try{
                            musicName = musicName + "/" + listeMusic[i].getName();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println(musicName);
                    oos.writeObject(musicName);
                }

            for(int i=0; i<nbrAudio;i++){
                if(message.equalsIgnoreCase("music"+i)){
                    musicName = new String();
                        try{
                            musicName = listeMusic[i].getPath();
                        }catch(Exception e){
                        System.out.println(e.getMessage());
                        }
                    System.out.println(musicName);
                    oos.writeObject(musicName);
                }
            }
            //------------------------------------------------------------------
            if(message.equalsIgnoreCase("photo")){
                photoName = new String();
                for(int i=0; i<nbrPhoto; i++){
                    try{
                        photoName = photoName + "/" + listePhoto[i].getName();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(photoName);
                oos.writeObject(photoName);
            }


            for(int i=0; i<nbrPhoto;i++){
                if(message.equalsIgnoreCase("photo"+i)){
                    photoName = new String();
                        try{
                            photoName = listePhoto[i].getPath();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    System.out.println(photoName);
                    oos.writeObject(photoName);
                }
            }

            if(message.equalsIgnoreCase("retourPhoto")){
                photoName = new String();
                for(int i=0; i<nbrPhoto; i++){
                    try{
                        photoName = photoName + "/" + listePhoto[i].getName();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(photoName);
                oos.writeObject(photoName);
            }

            if(message.equalsIgnoreCase("retourFenPhoto")){
                photoName = new String();
                for(int i=0; i<nbrPhoto; i++){
                    try{
                        photoName = photoName + "/" + listePhoto[i].getName();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(photoName);
                oos.writeObject(photoName);
            }

            if(message.equalsIgnoreCase("retourFenMusic")){
                musicName = new String();
                    for(int i=0; i<nbrAudio; i++){
                        try{
                            musicName = musicName + "/" + listeMusic[i].getName();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println(musicName);
                    oos.writeObject(musicName);
            }

            if(message.equalsIgnoreCase("retourMusic")){
                musicName = new String();
                    for(int i=0; i<nbrAudio; i++){
                        try{
                            musicName = musicName + "/" + listeMusic[i].getName();
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println(musicName);
                    oos.writeObject(musicName);
            }

            ois.close();
            oos.close();
            socket.close();

            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!");
        server.close();
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


