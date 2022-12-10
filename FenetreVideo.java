/*package affichage;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.net.UnknownHostException;
//import javazoom.jl.player.Player; VIDEO JAR

import listener.*;
import client.*;

public class FenetreVideo extends JFrame{

    public Client client;
    public String[] videoName;
    public JButton[] btt;
    public int nbrVideo;
    private static Player player;

    public FenetreMusic(String message) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        client=new Client();
        this.setTitle("FenetreVideo");
		this.setSize(1000, 750);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ListenerMusic lm=new ListenerMusic(this);
         
        JPanel panel = new JPanel();
        videoName = message.split("/");
        nbrVideo=videoName.length;

        panel.setLayout(new BorderLayout());
             //panel.setLayout(new GridLayout(nbrVideo,0));

        JPanel titre = new JPanel();
        titre.setLayout(new BorderLayout());
        JLabel lbl1=new JLabel("Video");

        titre.add(lbl1,BorderLayout.WEST);
        panel.add(titre,BorderLayout.NORTH);

        JPanel list = new JPanel();
            list.setLayout(new GridLayout(nbrVideo,0));

            btt = new JButton[nbrHira];

             
             for(int i=0; i<nbrVideo; i++){
                if(i>0){
                    btt[i]=new JButton(musicVideo[i]);
                    btt[i].addMouseListener(lm);
                    list.add(btt[i]);
                }
             }

             panel.add(list,BorderLayout.CENTER);
                                             
        panel.add(bout(),BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);

    }


//----------------------------------FONCTION---------------------------------------
    public JPanel bout(){

        JPanel pnl=new JPanel();
               pnl.setLayout(new FlowLayout(FlowLayout.CENTER,100,10));
       // JButton btn1= new JButton("Play");
       // JButton btn2= new JButton("Pause");
        JButton btn3= new JButton("Stop");

       ListenerMusic lm=new ListenerMusic(this);
       // btn1.addMouseListener(lm);
       // btn2.addMouseListener(lm);
       btn3.addMouseListener(lm);

       // pnl.add(btn1);
       // pnl.add(btn2);
        pnl.add(btn3);

        return pnl;
    }

    //------------------------------------------------------------------------------
    public static void play(String mp3){
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

    //------------------------------------------------------------------------
    public static void stop(){
        if(player!=null){player.close();}
    }
    

}*/