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
public class ThemePanel extends JPanel
{
 private BufferedImage myImage;
 private Graphics myBuffer;
 private String myTheme;
 private int temp = 0;
 public Theme theme;
 private JTextField box1;
 private JTextField box2;
  private ArrayList<JButton> buttons = new ArrayList<JButton>();
 public ThemePanel()
 {
  
 String[] array = {"Classic","America","India"};
 int x = 350;
 myTheme = "Classic";
 setLayout(null);
      int y = 240;
      for (int i=0;i<3;i++)
      {
         JButton button1 = new JButton();
         JLabel label = new JLabel(array[i]);
         label.setFont(new Font("Serif", Font.BOLD, 30));
         button1.setBounds(x,y,140,70);
         buttons.add(button1);
         label.setForeground(Color.BLUE);
         x = x + 220;
         add(button1);
         button1.add(label);
       }
      JLabel label2 = new JLabel("Themes: ");
      label2.setFont(new Font("Serif",Font.BOLD,50));
      label2.setBounds(80,240,400,60);
      label2.setForeground(Color.ORANGE.brighter());
      add(label2);
      JLabel label4 = new JLabel("Nicknames: ");
      label4.setFont(new Font("Serif",Font.BOLD,50));
      label4.setBounds(80,600,400,60);
      label4.setForeground(Color.ORANGE.brighter());
      add(label4);
      box1 = new JTextField("Player1", 10);
        box1.setBounds(380,610,250,50);
        box1.setFont(new Font("Serif",Font.BOLD,20));
        add(box1);        
 box2 = new JTextField("Player2", 10);
         box2.setBounds(700,610,250,50);
         box2.setFont(new Font("Serif",Font.BOLD,20));
         add(box2);
       JLabel currentTheme = new JLabel("Current Theme: " + myTheme);
   currentTheme.setFont(new Font("Serif",Font.BOLD,40));
      currentTheme.setBounds(400,320,500,60);
      currentTheme.setForeground(Color.ORANGE);
      add(currentTheme);
      for (int button = 0 ; button <= buttons.size() - 1; button++) {
      int a = button;
    buttons.get(button).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String[] tempA = {"Classic","America","India"};
            myTheme = tempA[a];
            currentTheme.setText("Current Theme: " + myTheme);
          
  }});}
 
  
  try{
   myImage = ImageIO.read(new File("Image1.jpg"));
   myImage = enlarge(myImage,6);
   myImage.getScaledInstance(1000,1000, Image.SCALE_DEFAULT);
}
catch(IOException e)
{
 
}
 
 JLabel label1 = new JLabel("Choose your Themes and Nicknames");
 label1.setFont(new Font("Serif", Font.BOLD, 55));
 label1.setForeground(Color.CYAN);
 label1.setBounds(50,0,1000,100);
 add(label1);
 
 }
 public void paintComponent(Graphics g)
   {
    super.paintComponent(g);
    g.drawImage(myImage,0,0,null);
   }
   public static BufferedImage enlarge(BufferedImage image, int n) {
        
       int w = n * image.getWidth();
       int h = n * image.getHeight();
        
       BufferedImage enlargedImage =
               new BufferedImage(w, h, image.getType());
        
       for (int y=0; y < h; ++y)
           for (int x=0; x < w; ++x)
               enlargedImage.setRGB(x, y, image.getRGB(x/n, y/n));
        
       return enlargedImage;
   }
   private class Listener1 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
          theme = new Theme(myTheme);
          theme.setP1Name(box1.getText());
          theme.setP2Name(box2.getText());
          System.out.println(theme.getp1Name());
          System.out.println(theme.getp2Name());
         }
      }
  public Theme getTheme()
  {
   return theme;
  }
  public String getString()
  {
   return myTheme;
  }
  public String getP1nick()
  {
   return box1.getText();
  }
  public String getP2nick()
  {
   return box2.getText();
  }
}