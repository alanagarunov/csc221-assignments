
import javafx.scene.canvas.GraphicsContext;

public class myCircle extends myShape {
    private int x,y,r;
    private double area, perimeter;

    public myCircle(int x1, int y1, int x, int y, int r, myColor c) {
        super(x, y, c);
        this.x = x1;
        this.y = y1;
        this.r = r;
    }

    public void calcArea(){
        this.area = (Math.PI*Math.pow(r, 2));
    }
    public void calcPerimeter() {
        this.perimeter = (2 * Math.PI * r);
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString(){
        return "The area is " + getArea() + " And the perimeter is  " + getPerimeter();
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(getC().getARGB());
        gc.fillOval(this.x/2 , this.y/2 , r + this.x , r+ this.y);
    }

}
