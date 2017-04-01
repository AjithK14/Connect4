import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.lang.*; 
import java.awt.image.*; 
import java.awt.Color; 
import java.awt.image.BufferedImage; 
import sun.audio.*; 
import java.io.*; 
public class Theme 
{ 
private Color player1 = Color.RED; 
private Color player2 = Color.BLACK; 
private Color Board = Color.YELLOW;
private String player1name;
private String player2name;
public Theme(String arg) 
{ 
if(arg == "India") 
{ 
player1 = Color.ORANGE;
player2 = Color.GREEN.darker(); 
Board = Color.BLUE.darker(); 
} 
else if (arg == "America") 
{ 
player1 = Color.RED;
player2 = Color.GRAY;//gray 
Board = Color.BLUE; 
} 
else if (arg == "Classic") 
{ 
player1 = Color.RED;
player2 = Color.BLACK; 
Board = Color.YELLOW; 
} 
} 
public Color getP1() 
{ 
return player1; 
} 


public Color getP2() 
{ 
return player2; 
} 

public Color getBoard() 
{ 
return Board; 
} 


public void setP1Name(String a)
{
 player1name = a;
}


public void setP2Name(String b)
{
 player2name = b;
}


public String getp1Name()
{
 return player1name;
}

public String getp2Name()
{
 return player2name;
}


}

