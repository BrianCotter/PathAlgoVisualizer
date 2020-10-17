import java.awt.Rectangle;

public class Cell {

    public static final int SCALE =  20;
    private Rectangle rect;

    Cell(int x, int y){
        rect = new Rectangle(x, y, SCALE, SCALE);
    }

    public Rectangle getShape(){
        return rect;
    }
}
