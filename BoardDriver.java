import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.image.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class BoardDriver extends JFrame
{
 public static void main(String[] args)
 {
  JFrame frame = new JFrame("Board Driver");
  frame.setSize(1000,1000);
  frame.setLocation(0,50);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  SoundTest test = new SoundTest();
  test.music();
  Theme theme = new Theme("America");  
  frame.setContentPane(new BoardPanel(theme));
  frame.setVisible(true);
  
 }
}