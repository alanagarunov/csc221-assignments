
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Hello World");
        int w = 500;
        int h = 500;

        myShape c1 = new myShape(w,h, myColor.BLUE);
        Canvas canvas = new Canvas(c1.getX(), c1.getY());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        myLine l1 = new myLine(0,0, w, h, myColor.BLACK);
        myLine l2 = new myLine(0,0, 0, h, myColor.BLACK);
        myLine l3 = new myLine(0,h, w, 0, myColor.BLACK);
        myLine l4 = new myLine(0,0, w, 0, myColor.BLACK);
        myLine l5 = new myLine(w,0, w, h, myColor.BLACK);
        myLine l6 = new myLine(0,h, w, h, myColor.BLACK);


        myPolygon p1 = new myPolygon((int)(h*0.50),(int)(w*0.50),0,0,6,200, myColor.BLACK);
        myCircle cir1 = new myCircle((int)(h*0.40),(int)(w*0.40),0,0,100, myColor.YELLOW);
        myCircle cir2 = new myCircle((int)(h*0.45),(int)(w*0.45),0,0,45, myColor.PINK);
        myPolygon p2 = new myPolygon((int)(h*0.50),(int)(w*0.50),0,0,6,150, myColor.GREEN);
        myPolygon p3 = new myPolygon((int)(h*0.50),(int)(w*0.50),0,0,6,110, myColor.BLUE);

        p1.draw(gc);
        cir1.draw(gc);
        p2.draw(gc);
        cir2.draw(gc);
        p3.draw(gc);

        l1.draw(gc);
        l2.draw(gc);
        l3.draw(gc);
        l4.draw(gc);
        l5.draw(gc);
        l6.draw(gc);

        Pane P = new Pane();
        P.getChildren().add(canvas);
        //P.getChildren().add(l1.draw(gc));
        root.setCenter(P);
        Scene sc = new Scene(root, 500,500);

        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setScene(sc);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        System.out.println(myColor.RED.getARGB());
    }
}
