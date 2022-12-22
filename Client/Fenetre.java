
package affichage;

import java.awt.*;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.FlowView;

import client.*;
import listener.*;

public class Fenetre extends JFrame{
    public Client client;
    
    public Fenetre() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        this.setTitle("Fenetre");
		this.setSize(900, 675);
        this.setBackground(Color.GRAY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,0,100,50));
       // panel.setPreferredSize(new Dimension(100,50));

        
        JButton photo = new JButton("Image");
        JButton music = new JButton("Music");
       // JButton video  = new JButton("Video");

        client = new Client();

        Listener listen = new Listener(this);
            photo.addMouseListener(listen);
            music.addMouseListener(listen);
           // video.addMouseListener(listen); 

            panel.add(photo);
            panel.add(music);
          //  panel.add(video);

        this.add(panel);
        setVisible(true);
    }
        
}
