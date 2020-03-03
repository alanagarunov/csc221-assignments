import javafx.scene.canvas.GraphicsContext;

public class myCircle extends myShape {
    private int x,y,r;

    public myCircle(int x1, int y1, int x, int y, int r, myColor c) {
        super(x, y, c);
        this.x = x1;
        this.y = y1;
        this.r = r;
    }

    public double getArea(){
        return (Math.PI*Math.pow(r, 2));
    }

    public double getPerimeter(){
        return (2*Math.PI*r);
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(getC().getARGB());
        gc.fillOval(this.x/2 , this.y/2 , r + this.x , r+ this.y);
    }

}
