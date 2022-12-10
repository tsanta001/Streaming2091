package affichage;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.net.UnknownHostException;
import javazoom.jl.player.Player;

import listener.*;
import client.*;

public class FenetreMusic extends JFrame{

    public Client client;
    public String[] musicName;
    public JButton[] btt;
    public int nbrHira;
    private Player player;

    public FenetreMusic(String message) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        client=new Client();
        this.setTitle("FenetreMusic");
		this.setSize(900, 675);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ListenerMusic lm=new ListenerMusic(this);
         
        JPanel panel = new JPanel();
        musicName = message.split("/");
        nbrHira=musicName.length;

        panel.setLayout(new BorderLayout());
             //panel.setLayout(new GridLayout(nbrHira,0));

        JPanel titre = new JPanel();
        titre.setLayout(new BorderLayout());
        JLabel lbl1=new JLabel("MUSIC");

        titre.add(lbl1,BorderLayout.WEST);
        panel.add(titre,BorderLayout.NORTH);

        JPanel list = new JPanel();
            list.setLayout(new GridLayout(nbrHira,0));

            btt = new JButton[nbrHira];

             
             for(int i=0; i<nbrHira; i++){
                if(i>0){
                    btt[i]=new JButton(musicName[i]);
                    btt[i].addMouseListener(lm);
                    list.add(btt[i]);
                }
             }

             panel.add(list,BorderLayout.CENTER);
                                             
        panel.add(bout(),BorderLayout.EAST);

        ListenerMusic li=new ListenerMusic(this);
            JButton btn=new JButton("Retour");
                    panel.add(btn,BorderLayout.PAGE_END);
                    btn.addMouseListener(li);

        this.add(panel);
        this.setVisible(true);

    }

//----------------------------------FONCTION---------------------------------------
    public JPanel bout(){

        JPanel pnl=new JPanel();
               pnl.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
       // JButton btn1= new JButton("Play");
       // JButton btn2= new JButton("Pause");
        JButton btn3= new JButton("Stop");

       ListnerMusic lm=new ListnerMusic(this);
       // btn1.addMouseListener(lm);
       // btn2.addMouseListener(lm);
       btn3.addMouseListener(lm);

       // pnl.add(btn1);
       // pnl.add(btn2);
        pnl.add(btn3);

        return pnl;
    }


    //-----------------------------------------------------------------------------
    public byte[] byteTab(String path){
        byte[] bytes=null;
        try {
            bytes = path.getBytes();
            System.out.println("Bytes"+ bytes.length);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }

    //------------------------------------------------------------------------------
    public void play(String mp3){
        try {
            byte[] bytess = byteTab(mp3);
            String ip=new String(bytess);
            FileInputStream fis =new FileInputStream(ip);
            BufferedInputStream bis= new BufferedInputStream(fis);
                player=new Player(bis);

        } catch (Exception e) {
        }
            new Thread(){ 
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
    public void stop(){
        if(player!=null){player.close();}
    }
    
    

}