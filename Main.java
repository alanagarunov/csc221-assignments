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

        myShape c1 = new myShape(500,500, myColor.BLUE);
        Canvas canvas = new Canvas(c1.getX(), c1.getY());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        myLine l1 = new myLine(0,0, 250, 250, myColor.BLUE);
        myPolygon p1 = new myPolygon(250,250,0,0,6,50, myColor.GREEN);
        myCircle cir1 = new myCircle(250,250,0,0,10, myColor.RED);
        c1.draw(gc);
        l1.draw(gc);
        p1.draw(gc);
        cir1.draw(gc);

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
