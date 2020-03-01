package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class myShape extends Object {
    private int x,y;
    private myColor c;

    public myShape(int x, int y, myColor c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public myColor getC() {
        return c;
    }

    public void setC(myColor c) {
        this.c = c;
    }

    public void draw(GraphicsContext gc){
        //Canvas canvas = new Canvas(x,y);
        //gc = canvas.getGraphicsContext2D();
        gc.setFill(c.getARGB());
    }
}

