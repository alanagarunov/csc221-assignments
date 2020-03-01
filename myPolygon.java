package sample;

import javafx.scene.canvas.GraphicsContext;
import java.lang.Math;
import javafx.scene.shape.Polygon;

public class myPolygon extends myShape{
    private int x, y, n, r;

    public myPolygon(int x1, int y1, int x, int y, int n, int r, myColor c) {
        super(x, y, c);
        this.x = x1;
        this.y = y1;
        this.n = n;
        this.r = r;
    }

    @Override
    public void draw(GraphicsContext gc) {
        //Polygon p1 = new Polygon();
        double[] Xcorrds = new double[n];
        double[] Ycorrds = new double[n];
       for(int i = 0; i < n; i++){
            Xcorrds[i] = r* Math.cos(2*Math.PI*i/n) + this.x;                    
            System.out.println(Xcorrds[i]);
            Ycorrds[i] = r* Math.sin(2*Math.PI*i/n) + this.y;                    
            System.out.println(Ycorrds[i]);
        }
        //gc.fillPolygon(Xcorrds,  Ycorrds, n);
        gc.setFill(getC().getARGB());
        gc.fillPolygon(Xcorrds, Ycorrds, n);
    }
}
