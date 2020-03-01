package sample;

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

    public double getLength(Line line){
        double x1 = line.getStartX();
        double x2 = line.getStartY();
        double y1 = line.getEndX();
        double y2 = line.getEndY();
        //double totallength = sqrt(pow((x2 - x1), 2) - pow((y2 - y1), 2));
        return sqrt(pow((x2 - x1), 2) - pow((y2 - y1), 2));
    }

    public String toString(Line line){
        return line.toString();
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
