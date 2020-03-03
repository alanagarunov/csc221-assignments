import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class myLine extends myShape{
    private int EndX, EndY;

    public myLine(int x, int y, int endX, int endY, myColor c) {
        super(x, y, c);
        EndX = endX;
        EndY = endY;
    }

    public double getLength(myLine line){
        double x1 = line.getX();
        double x2 = this.EndX;
        double y1 = line.getY();
        double y2 = this.EndY;
        //double totallength = sqrt(pow((x2 - x1), 2) - pow((y2 - y1), 2));
        return sqrt(pow((x2 - x1), 2) - pow((y2 - y1), 2));
    }

    public double getAngle(myLine line){
        double x1 = line.getX();
        double x2 = this.EndX;
        double y1 = line.getY();
        double y2 = this.EndY;
        return Math.atan2((x2 - x1), (y2 - y1));
    }

    @Override
    public void draw(GraphicsContext gc) {
        /*Line line = new Line();
        line.setStartX(getX());
        line.setStartY(getY());
        line.setEndX(EndX);
        line.setEndY(EndY);
        line.setStroke(getC().getARGB());
        return line;*/

        gc.setStroke(getC().getARGB());
        gc.strokeLine(getX(), getY(), EndX, EndY);


    }
}
