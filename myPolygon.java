import javafx.scene.canvas.GraphicsContext;
import java.lang.Math;
import javafx.scene.shape.Polygon;

public class myPolygon extends myShape{
    private int x, y, n, r;
    double[] Xcorrds;
    double[] Ycorrds;

    public myPolygon(int x1, int y1, int x, int y, int n, int r, myColor c) {
        super(x, y, c);
        this.x = x1;
        this.y = y1;
        this.n = n;
        this.r = r;
        this.Xcorrds = new double[n];
        this.Ycorrds = new double[n];

        for(int i = 0; i < n; i++){
            this.Xcorrds[i] = r* Math.cos(2*Math.PI*i/n) + this.x;                    //((Math.sin((double)i/(n*2*Math.PI)))* r) + this.x;
            System.out.println(Xcorrds[i]);
            this.Ycorrds[i] = r* Math.sin(2*Math.PI*i/n) + this.y;                    //((Math.cos((double)i/(n*2*Math.PI)))* r) + this.y;
            System.out.println(Ycorrds[i]);
        }
    }
    public double getSides(){
        return Math.sqrt((Xcorrds[0]*Xcorrds[0]) + (Ycorrds[0]*Ycorrds[0]));
    }
    public double getPerimeter(){
        return getSides()*this.n;
    }
    public double getArea(){
        return ((getSides()/(2*Math.tan(180/this.n)))*getPerimeter())/2;
    }

    @Override
    public String toString(){
        return "The area is " +getArea() + " and the perimeter is " + getPerimeter() + " and the number of sides is " + getSides();
    }

    @Override
    public void draw(GraphicsContext gc) {
        //Polygon p1 = new Polygon();
        //double[] Xcorrds = new double[n];
        //double[] Ycorrds = new double[n];
        //gc.fillPolygon(Xcorrds,  Ycorrds, n);
        gc.setFill(getC().getARGB());
        gc.fillPolygon(Xcorrds, Ycorrds, n);
    }
}
