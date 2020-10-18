/*
Grid class that creates Grid structure for GoL World

Has Draw method that gets called 20x a sec to update screen

Added requirment that the outside border of the maze must be all wall
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Grid {

    public static int WIDTH; 
    public static int HEIGHT; 
    
    private Graphics2D g2D; 
    private int[][] grid;
    private int[][] buffer;
	
    Grid(){
        //Maze maze = new Maze(Maze.Small);
        Maze maze = new Maze(Maze.Big); // If we wanted big maze
        WIDTH = maze.getWidth();
        HEIGHT = maze.getHeight();

		grid = new int[WIDTH][HEIGHT];
        buffer = new int[WIDTH][HEIGHT];
        
        grid = maze.getMaze(); 
    }
	
	
	public void update(){
        int bp = 0;

        for(int x = 1; x < WIDTH-1; x++){
            for(int y = 1; y < HEIGHT-1; y++){

                // First, check if an open cell
                if(grid[x][y] == Maze.OPEN){

                    // TODO make into a neighbors int[4] array
                    int neighbors = 0;

                    if(grid[x-1][y] == Maze.FOUND){
                        neighbors++;
                    }
                    if(grid[x][y-1] == Maze.FOUND){
                        neighbors++;
                    }
                    if(grid[x][y+1] == Maze.FOUND){
                        neighbors++;
                    }
                    if(grid[x+1][y] == Maze.FOUND){
                        neighbors++;
                    }

                    // If undiscovered cells borders a found cell
                    if(neighbors>0){
                        // Touching live node, declare as found 
                        buffer[x][y] = Maze.FOUND;
                    }
                    else{
                        // Not touching any nodes, remain the same
                        buffer[x][y] = grid[x][y];
                    }
                }
                else{
                    // Otherwise remain same state
                    buffer[x][y] = grid[x][y];
                }   
            }
        }
		
        // Copy buffer to grid 
        for(int i=0; i<WIDTH; i++){
            for(int j=0; j<HEIGHT; j++)
                grid[i][j] = buffer[i][j];
        }
    }

	
    // Call 20x a second 
    public void draw(Graphics g){
		g2D = (Graphics2D)g;
		
		// Draw state over every cell in the grid
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){

                Cell cell = new Cell(x*Cell.SCALE,y*Cell.SCALE);
                
                //TODO: look into overwriting color rahter than redrawing everytime

                //TODO: if part of algo set to blue
                switch (grid[x][y])
                {
                    case Maze.OPEN:
                        g2D.setColor(Color.WHITE);
                        break;

                    case Maze.WALL:
                        g2D.setColor(Color.BLACK);
                        break;

                    case Maze.FOUND:
                        g2D.setColor(Color.BLUE);
                        break;

                    case Maze.GOAL:
                        g2D.setColor(Color.YELLOW);
                        break;
                }
                g2D.fill(cell.getShape());

            }
        }

        // After drawing current state update buffer
        update();
    }
    
}
