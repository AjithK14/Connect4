import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.image.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Ellipse2D;
public class ThemeDriver extends JFrame
{
 public static void main(String[] args)
 {
  JFrame frame = new JFrame("Theme Driver");
  frame.setSize(1000,1000);
  frame.setLocation(0,50);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setContentPane(new ThemePanel());
  frame.setVisible(true);
  
 }
}