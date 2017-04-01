package connect4game;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.lang.*;
public class Main extends JFrame
{
 public static final int WIDTH = 1000;
 public static final int HEIGHT = 1000;
 public Main()
 {
  new Game1(WIDTH,HEIGHT,
 }
 public static void main(String[] args)
 {
  JFrame frame = new JFrame("Connect 4: Ajith Kemisetti");
         frame.setSize(1000, 1000);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Theme theme = new Theme("India");
       	frame.setContentPane(new Board(theme));
         frame.setVisible(true);
 }
}
