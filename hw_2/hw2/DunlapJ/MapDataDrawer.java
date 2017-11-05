/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Thomas Dunlap
 */

import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer
{
  // store map data in grid array
  private int[][] grid; 
  
  // Read 2D array into grid. Data in file "filename", grid is rows x cols
   public MapDataDrawer(String filename, int rows, int cols) throws Exception{
      // initialize grid 
      grid = new int[rows][cols];
      //read the data from the file into the grid
      Scanner S = new Scanner(new File("Colorado_844x480.dat"));    
      
       for(int row=0; row < grid.length-1; row++){
          for(int col=0; col<grid[0].length-1; col++){
             grid[row][col] = S.nextInt(); 
          }
       }
      
  }

  
  /**
   * @return the min value in the entire grid
   */
  public int findMin(){
      int min = grid[0][0];
      
      for(int row=0; row < grid.length; row++){
          for(int col=0; col < grid[0].length-1; col++){
             if (min > grid[row][col]) {
                 min = grid[row][col];
                }
          }
       }
      return min;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int max = grid[0][0];
      
      for(int row=0; row < grid.length; row++){
          for(int col=0; col < grid[0].length-1; col++){
             if (max < grid[row][col]) {
                 max = grid[row][col];
                }
          }
       }

      return max; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int indexRow = col;
      
      return indexRow;  
  }
  
  
  /**
   * DON'T CHANGE THIS CODE
   * Draws the grid using the given Graphics object. 
   * Colors should be grayscale values 0-255, scaled based on min/max values in grid
   * 
   * ALERT:Until your findMin and findMax methods work, your output will
   * be a completely black graph.
   */
  public void drawMap(Graphics g){
      
    int minVal = findMin();
    int maxVal = findMax();
    double range = maxVal - minVal;
    
    for(int row=0; row < grid.length-1; row++){
      for(int col=0; col<grid[0].length; col++){
         int val = (int)(((grid[row][col]-minVal)/range) * 255);
         //g.setColor(new Color(val,255-val,255-val));
         g.setColor(new Color(200,200,200));
         g.fillRect(col,row,1,1);
        }
    }      
  }
  

   /**
   * Find a path from West-to-East starting at given row.
   * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
   * @return the total change in elevation traveled from West-to-East
   */
  public int drawLowestElevPath(Graphics g, int row){
    int currY = row; // row in grid of step one
    int col = 0;
    // draw initial step - column 0, current row (sent in as parameter)
    g.fillRect(0,row,1,1);
    // Code to compute next step
    for (col = 0; col < grid.length-2; col++) {
        if ((Math.abs((grid[row][col]) - (grid[row+1][col+1]))) > (Math.abs((grid[row][col])) - (grid[row-1][col+1])))  {
            if ((Math.abs((grid[row][col]) - (grid[row+1][col+1]))) > (Math.abs((grid[row][col])) - (grid[row][col+1]))) {
                currY = (row + 1);
            }
        }
        if ((Math.abs((grid[row][col]) - (grid[row-1][col+1]))) > (Math.abs((grid[row][col])) - (grid[row+1][col+1])))  {
            if ((Math.abs((grid[row][col]) - (grid[row-1][col+1]))) > (Math.abs((grid[row][col])) - (grid[row][col+1]))) {
                currY = (row - 1);
            }
        }
        if ((Math.abs((grid[row][col]) - (grid[row][col+1]))) > (Math.abs((grid[row][col])) - (grid[row-1][col+1])))  {
            if ((Math.abs((grid[row][col]) - (grid[row][col+1]))) > (Math.abs((grid[row][col])) - (grid[row+1][col+1]))) {
                currY = (row);
            }
        }
        else {
            currY = (row);
        }
    }
    // draw next step where x is currently column and currY is row in grid
    int x = 0;
    
    for (col = 0; col < grid.length-2; col++) {
        x = col;
        g.fillRect(x,currY,1,1);
    }
    // the value of x will be generated by a loop that goes through the
    // columns, but for now, need something to put in "paint" statement
    
    
    return x; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      
     
      return 0; // row of path with lowest elevation
  
  }
  
  
}   