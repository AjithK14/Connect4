package connect4game;
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Music
{ 
public static void createButton()
{
    JButton button = new JButton("CLICK HERE FOR MUSIC");
    button.addActionListener(new AL());
}
    public static class AL implements ActionListener{
        public final void actionPerformed(ActionEvent e){
            music();
    }
}

    public static void music() 
    {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream("Baby-JB.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
    }


}