package connect4game;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.lang.*;
   import java.awt.image.*;
   import java.util.*;
   import java.awt.geom.Ellipse2D;
   import java.awt.geom.Point2D;
   import java.awt.geom.*;
public class Board
{
 private int[][] board = new int[6][7];
 private Color myColor;
 private Color player1;
 private Color player2;
 private Color tempColor;
 final int N = 1000;
 int tempx;
 int tempy;
 public Board(Theme theme)
 {
   myColor = theme.getBoard();
   player1 = theme.getp1();
   player2 = theme.getp2();
 }
public void addPiece(int x, Color color)
{
 tempx = x;
 int temp = recognizecolumn(x);
 int length = board.length;
 tempColor = color;
}
public int getX()
{
 return tempx;
}
public int getY()
{
 return tempy;
}
public static int recognizecolumn(int x){
  if ((x <= 150) && (75<=x))
  {return 0;}
  else if ((x <= 275) && (200<=x))
  {return 1;}
  else if ((x <= 400) && (325<=x))
  {return 2;}
  else if ((x <= 525) && (450<=x))
  {return 3;}
  else if ((x <= 650) && (575<=x))
  {return 4;}
  else if ((x <= 775) && (700<=x))
  {return 5;}
  else if ((x <= 900) && (825<=x))
  {return 6;}
  else{return 0;}}
  public void draw(Graphics myBuffer) 
  {
   myBuffer.setColor(tempColor);
   myBuffer.fillOval(getX(),getY(),75,75);
  }    
public boolean checkWin(int[][] matrix){
// for col = 0 to 3:
//     for row = 0 to 2:
//         if board[row][col] != 0 and
//            board[row][col] == board[row+1][col+1] and
//            board[row][col] == board[row+2][col+2] and
//            board[row][col] == board[row+3][col+3]:
//                return board[row][col]
//     for row = 3 to 5:
//         if board[row][col] != 0 and
//            board[row][col] == board[row-1][col+1] and
//            board[row][col] == board[row-2][col+2] and
//            board[row][col] == board[row-3][col+3]:
//                return board[row][col]
// return true;
return true;
}
}