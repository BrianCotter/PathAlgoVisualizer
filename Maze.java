/*
Maybe at some point add random maze generation

0 = open space (white)
1 = wall (black)
2 = covered (blue)
3 = goal cell (yellow)

TODO: 
*/

public class Maze { 

    private static int[][] SmallMaze = {
        {0,0,0,0,0,0,0,0,0,0},
        {0,2,0,0,1,0,0,1,1,0},
        {0,1,1,1,1,1,1,1,0,0},
        {0,0,0,1,1,0,0,1,0,0},
        {0,0,0,0,1,1,0,1,0,0},
        {0,0,0,0,0,1,1,1,1,0},
        {0,0,1,1,0,1,0,0,0,0},
        {0,0,0,1,1,1,0,0,0,0},
        {0,0,1,1,0,1,1,1,3,0},
        {0,0,0,0,0,0,0,0,0,0}
    };

    private static int[][] BigMaze = {
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,2,1,0,0,1,1,0,0,0,1,0,0,1,1,1,1,1,1,0},
    {0,0,1,0,0,0,1,1,1,1,1,0,0,1,0,1,0,0,0,0},
    {0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,1,1,1,1,0},
    {0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0,0,1,1,0},
    {0,1,1,0,0,1,1,1,0,0,1,1,0,1,0,0,1,1,1,0},
    {0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,1,0,0,0},
    {0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,0,1,0,0,0},
    {0,1,1,1,1,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0},
    {0,1,0,0,0,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0},
    {0,1,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0,1,0},
    {0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,1,0,1,0,0,0,1,0,0,1,1,1,1,0,0,0,1,0},
    {0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,1,1,1,1,0},
    {0,1,1,1,1,1,1,1,1,0,0,1,0,0,1,1,0,0,1,0},
    {0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0},
    {0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,0,1,0,0,0},
    {0,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1,1,3,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    public static final int Small = 0;
    public static final int Big = 1;

    public static final int OPEN =  1;
    public static final int WALL =  0;
    public static final int FOUND = 2;
    public static final int GOAL =  3;

    private int size;

    //TODO: after finding best path draw in red 
    
    Maze(int size){
        this.size = size;

    }

    public int getWidth(){
        if(this.size == Small){
            return 10;
        }
        if(this.size == Big){
            return 20;
        }
        else{
            return 0;
        }
    }

    public int getHeight(){
        if(this.size == Small){
            return 10;
        }
        if(this.size == Big){
            return 20;
        }
        else{
            return 0;
        }
    }

    public int[][] getMaze(){
        if(this.size == Small){
            return SmallMaze;
        }
        else{
            return BigMaze;
        }
    }
}
