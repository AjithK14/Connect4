import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.lang.*; 
import java.awt.image.*; 
import java.awt.Color; 
import javax.imageio.*;
import java.awt.image.BufferedImage; 
import sun.audio.*; 
import java.io.*; 
import java.util.*;
public class StartScreenPanel extends JPanel
{
 private BufferedImage myImage;
 private int x = 0;
 private SoundTest test = new SoundTest();
 public StartScreenPanel()
 {
 setLayout(null);
 JButton button2 = new JButton();
 button2.addActionListener(new Listener2());
 JButton button3 = new JButton();
 button3.addActionListener(new Listener3());
 button2.setBounds(420,600,125,50);
 button3.setBounds(420,800,125,50);
 add(button2);
 add(button3);
 JLabel label2 = new JLabel("Music");
 JLabel label3 = new JLabel("Quit");
 label2.setForeground(Color.BLUE);
 label2.setFont(new Font("Serif", Font.BOLD, 30));
 label3.setForeground(Color.BLUE);
 label3.setFont(new Font("Serif", Font.BOLD, 30));
 button2.add(label2);
 button3.add(label3);
 JLabel start = new JLabel("Welcome to Connect 4");
 start.setFont(new Font("Serif", Font.BOLD, 95));
 start.setBounds(30,0,1000,200);
 start.setForeground(Color.BLUE);
 add(start);
 JLabel credit = new JLabel("By: Akilesh Mahesh, Ajith Kemisetti, Pranav Karthik");
 credit.setFont(new Font("Serif", 0, 30));
 credit.setBounds(200,150,1000,200);
 credit.setForeground(Color.BLACK);
 add(credit);
  try{
   myImage = ImageIO.read(new File("Image2.jpg"));
   myImage.getScaledInstance(1000,1000, Image.SCALE_DEFAULT);
}
catch(IOException e)
{
 
}

 }
 public void paintComponent(Graphics g)
   {
    super.paintComponent(g);
    g.drawImage(myImage,0,0,null);
   }

      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
       
         test.music();
         }
        
      }
      private class Listener3 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
         
         	System.exit(0);
         
         }
      }

}