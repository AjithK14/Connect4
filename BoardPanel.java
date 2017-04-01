import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.image.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class BoardPanel extends JPanel
{
 private Color myColor;
 private static BufferedImage myImage;
 public static Graphics buffer;
 private static Theme theme;
 private static int[][] Board;
 private int count = 0;
 private int p1wins = 0;
 private int p2wins = 0;
 private int ties = 0;
 private ArrayList<JButton> buttons = new ArrayList<JButton>();
 public BoardPanel(Theme theme1)//Add theme
 {
   theme = theme1;
     JPanel panel = new JPanel();
     add(panel);
     setLayout(null);
     Board = new int[6][7];
     final int N = 1000; //width & height of buffered
      myImage = new BufferedImage(N, 1000, BufferedImage.TYPE_INT_RGB);
      buffer = myImage.getGraphics();
      buffer.setColor(theme1.getBoard());
      buffer.fillRect(0, 0, N, 800); //fill whole thing with blue
      for (int n = 75;n<725;n = n+125)
      {
       for (int i = 75;i<N-75;i=i+125)
       {
        buffer.setColor(Color.WHITE);
        buffer.fillOval(i,n,75,75);
       }
      }
      JButton quit = new JButton("Quit");
      quit.setBounds(850,839,100,50);
      add(quit);

      quit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
      System.exit(0);
      }});
      buffer.setColor(Color.WHITE);
      buffer.fillRect(0,800,N,200);
      JLabel label1 = new JLabel(theme1.getp1Name() + ": " + p1wins);
      label1.setFont(new Font("Serif",Font.BOLD,40));
      label1.setBounds(50,800,700,60);
      label1.setForeground(Color.ORANGE);
      add(label1);
      JLabel label2 = new JLabel(theme1.getp2Name() + ": " + p2wins);
      label2.setFont(new Font("Serif",Font.BOLD,40));
      label2.setBounds(50,875,700,60);
      label2.setForeground(Color.ORANGE);
      add(label2);
      JLabel label5 = new JLabel("Ties: " + ties);
      label5.setFont(new Font("Serif",Font.BOLD,25));
      label5.setBounds(80,840,700,60);
      label5.setForeground(Color.BLACK);
      add(label5);
      JLabel move = new JLabel(theme1.getp1Name() + " to move");
      move.setFont(new Font("Serif",0,30));
      move.setBounds(400,770,500,200);
      move.setForeground(Color.MAGENTA);
      add(move);
      int x = 80;
      int y = 25;
      for (int i=0;i<7;i++)
      {
         int n = i;
         JButton button1 = new JButton("Coin");
         setLayout(null);
         button1.setBounds(x,y,70,30);
         buttons.add(button1);
         x = x + 124;
         add(button1);
       }
       for (int button = 0 ; button <= buttons.size() - 1; button++) {
    buttons.get(button).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JButton bsource = (JButton)e.getSource();
            int temp = (bsource.getX() - 80)/124;
            drawPiece(buffer,temp ,count);
            repaint();
            boolean b = check();
            int i = checkWin();
 if (b==true)
 {
  JOptionPane.showMessageDialog(null, "Its a tie!");
  ties++;
  label5.setText("Ties: " + ties);  
   for (int k = 75;k<725;k = k+125)
      {
       for (int r = 75;r<N-75;r=r+125)
       {
        buffer.setColor(Color.WHITE);
        buffer.fillOval(r,k,75,75);
       }
      }
   repaint();
      for (int index = 0;index<Board[0].length;index++)
      {
       for(int index1 = 0;index1<Board.length;index1++)
       {
        Board[index1][index] = 0;
       }
      }
       move.setText(theme1.getp1Name()+" to move");
      count = -1;

 }
 if (i==1)
 {
  JOptionPane.showMessageDialog(null, theme1.getp1Name() + " WINS!");
  p1wins++;
  label1.setText(theme1.getp1Name() + ": " + p1wins);
   for (int k = 75;k<725;k = k+125)
      {
       for (int r = 75;r<N-75;r=r+125)
       {
        buffer.setColor(Color.WHITE);
        buffer.fillOval(r,k,75,75);
       }
      }
   repaint();
      for (int index = 0;index<Board[0].length;index++)
      {
       for(int index1 = 0;index1<Board.length;index1++)
       {
        Board[index1][index] = 0;
       }
      }
       move.setText(theme1.getp1Name()+" to move");
      count = -1;
      

 }
 else if (i==2)
 {
    JOptionPane.showMessageDialog(null, theme1.getp2Name() + " WINS!");
    p2wins++;
    label2.setText(theme1.getp2Name() + ": " + p2wins);
     for (int n = 75;n<725;n = n+125)
      {
       for (int r = 75;r<N-75;r=r+125)
       {
        buffer.setColor(Color.WHITE);
        buffer.fillOval(r,n,75,75);
       }
      }
      repaint();
      for (int index = 0;index<Board[0].length;index++)
      {
       for(int index1 = 0;index1<Board.length;index1++)
       {
        Board[index1][index] = 0;
       }
      }
       move.setText(theme1.getp1Name()+" to move");
      count = -1;
    
 }
  if (count%2 == 0)
  {
   move.setText(theme1.getp2Name()+ " to move");
  }
  else
   {
    move.setText(theme1.getp1Name()+" to move");
   }
            count++;
        }
    } );
}//for loop
     }
public static int checkWin()
 {
  int g = 0;
  for (int r1 = 0;r1<=2;r1++)
  {
    for (int c1 = 0;c1<=6;c1++)
    {
        if ((!(Board[r1][c1] == 0)) &&
           (Board[r1][c1] == Board[r1+1][c1]) &&
           (Board[r1][c1] == Board[r1+2][c1]) &&
           (Board[r1][c1] == Board[r1+3][c1]))
           {
               g = Board[r1][c1];
            }
     }
   }
   
   for (int col = 0;col<=3;col++)
    {
       for (int row = 0;row<=2;row++)
       {
           if ((!(Board[row][col] == 0))&& (Board[row][col] == Board[row+1][col+1]) && (Board[row][col] == Board[row+2][col+2] ) && (Board[row][col] == Board[row+3][col+3]))
                  {
                  g = Board[row][col]; 
                  }
        }
     
       for (int row = 3;row<=5;row++)
       {
           if ((!(Board[row][col] == 0)) && (Board[row][col] == Board[row-1][col+1]) && (Board[row][col] == Board[row-1][col+1]) && (Board[row][col] == Board[row-2][col+2]) && (Board[row][col] == Board[row-3][col+3]))
        {
                  g = Board[row][col]; 
        }
       }
     }
   for (int r2 = 0;r2<=5;r2++)
   {
    for (int c2 = 0;c2<=3;c2++)
    {
        if ((Board[r2][c2] != 0) &&
           (Board[r2][c2] == Board[r2][c2+1])&&
          (Board[r2][c2] == Board[r2][c2+2]) &&
           (Board[r2][c2] == Board[r2][c2+3]))
           {
               g=Board[r2][c2];
           }
     }
   }
     return g;
}

public static void drawPiece(Graphics myBuffer, int column, int count)
{
int x = 125*column + 75;
int y;
if((count%2)==0)
{
   myBuffer.setColor(theme.getP1());
}
else
{
   myBuffer.setColor(theme.getP2());
}
for (int a = Board.length-1;a>=0;a--)
 {

   if (Board[a][column] == 0)
   {
      y = 125 * a + 75;
	   if (count%2 == 0)
      {
       Board[a][column] = 1;
      }
      else
      {
       Board[a][column] = 2;
      }
      myBuffer.fillOval(x,y,75,75);
      break;
   }
   else 
   {
      if (a == 0)
      {
         JOptionPane.showMessageDialog(null, "Full");
      }
      else
      {
         continue;
      }
   }
 } 
 
 }
   public void paintComponent(Graphics g)
   {
    super.paintComponent(g);
    g.drawImage(myImage,0,0,null);
   }
   public static boolean check()
   {
    int f = 0;
    for (int q1 = 0;q1<Board[0].length;q1++)
    {
     for(int q2=0;q2<Board.length;q2++)
     {
      if (Board[q2][q1] == 0)
      {
       f++;
      }
     }
    }
    if (f==0)
    {
     return true;
    }
    else
      {
       return false;
      }
   }
  
}