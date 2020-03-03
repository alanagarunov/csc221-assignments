import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public enum myColor {
    RED(255,0,0), GREEN(0,255,0), BLUE(0,0,255), WHITE(255,255,255), BLACK(0,0,0), YELLOW(255,255,0), PINK(255, 192,203), MAGENTA(139,0,139);

    int r,g,b;

    private myColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public Paint getARGB(){
        //return 0xFF000000 | ((r << 16) & 0x00FF0000) | ((g << 8) & 0x0000FF00) | b;
        return Color.rgb(r,g,b);
    }
}
