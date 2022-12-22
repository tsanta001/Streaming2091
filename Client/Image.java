package affichage;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.net.UnknownHostException;

import client.*;
import listener.*;

    public class Image extends JFrame{
        public Client client;
    
        public Image(String message) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
            setTitle("Fenetre");
            setSize(900, 675);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            client = new Client();
    
            JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());

            ListenerImage li=new ListenerImage(this);
            JButton btn=new JButton("Retour");
                    panel.add(btn,BorderLayout.SOUTH);
                    btn.addMouseListener(li);
            JLabel table = new JLabel();
            table.setIcon(new ImageIcon(message)); 
            table.setBounds(0,0,0,0);

            panel.add(table);
    
            add(panel);
            setVisible(true);
        }
    
}