package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.control.* ;
import javafx.stage.StageStyle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.sql.*;
import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        /* primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show(); */

        Connection conn = null;
        Button AddStudent, Addcourse, Addclasss;
        TextField textField;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.sqlite.JDBC");
            //conn = DriverManager.getConnection("jdbc:mysql://comtor.org/" +
            //"javafoundations?user=jf2e&password=hirsch");

            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alan\\Documents\\javadocuments\\finalproject\\thedata.db");

            if (conn != null) {
                System.out.println("We have connected to our database!");
                Statement stmt = conn.createStatement();
                boolean result = stmt.execute("CREATE TABLE IF NOT EXISTS Student (student_ID VARCHAR(30) NOT NULL, firstName VARCHAR(30) NOT NULL, lastName VARCHAR(30) NOT NULL, email VARCHAR(30) NOT NULL, sex VARCHAR(30) NOT NULL, PRIMARY KEY (student_ID))");
                Statement stmt3 = conn.createStatement();
                boolean result1 = stmt3.execute("CREATE TABLE IF NOT EXISTS Courses (course_ID VARCHAR(30) NOT NULL, courseTitle VARCHAR(30) NOT NULL, department VARCHAR(30) NOT NULL, PRIMARY KEY (course_ID))");
                Statement stmt5 = conn.createStatement();
                boolean result5 = stmt5.execute("CREATE TABLE IF NOT EXISTS Classes (course_ID VARCHAR(30) NOT NULL, student_ID VARCHAR(30) NOT NULL, section VARCHAR(30) NOT NULL, year VARCHAR(30) NOT NULL, semester VARCHAR(30) NOT NULL, gpa VARCHAR(30) NOT NULL, PRIMARY KEY (course_ID, student_ID, section)");

                System.out.println("\tTable creation result: " + result);
                System.out.println("\tTable creation result: " + result1);
                System.out.println("\tTable creation result: " + result5);

                /* Main.showColumns(conn, "Student");
                Main.showColumns(conn, "Courses");
                Main.showColumns(conn, "Classes");


                 Statement stmt2 = conn.createStatement();
                boolean rowCount = stmt2.execute("INSERT INTO Student VALUES ('0001', 'Campbell', 'Jackson', 'CampbellJackson@school.edu', 'F')");
                Statement stmt4 = conn.createStatement();
                boolean result4 = stmt4.execute("INSERT INTO Courses VALUES ('01', 'MATH201', 'Math')");

                Main.showValues(conn, "Student");
                Main.showValues(conn, "Courses");
                Main.showValues(conn, "Classes"); */

                conn.close();

            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        textField = new TextField();
        textField.setPrefWidth(500);

        AddStudent = new Button("Add student");
        AddStudent.setOnAction(e -> {
            Connection conn1 = null;
            try {
                Class.forName("org.sqlite.JDBC");
                conn1 = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alan\\Documents\\javadocuments\\finalproject\\thedata.db");
                if (conn1 != null) {
                    String ID = dataInput("What is their ID?", "What is their ID?", "Ex: 0001");
                    String Firstname = dataInput("What is their first name?", "What is their first name?", "Ex: Campbell");
                    String Lastname = dataInput("What is their last name?", "What is their last name?", "Ex: Jackson");
                    String email = dataInput("What is their email?", "What is their email?", "Ex: FirstLast@school.edu");
                    String Sex = dataInput("What is their sex?", "What is their sex?", "Ex: M/F");
                    Statement stmt6 = conn1.createStatement();
                    boolean result6 = stmt6.execute("INSERT INTO Student VALUES ( '" + ID + "', '" + Firstname + "', '" + Lastname + "', '" + email + "', '" + Sex + "')");
                    System.out.println("\tInsert creation result: " + result6);

                    Main.showColumns(conn1, "Student");
                    Main.showValues(conn1, "Student");

                    conn1.close();
                }
            }   catch(SQLException ex){
                    System.out.println("SQLException: " + ex.getMessage());
                    ex.printStackTrace();
                } catch(Exception ex){
                    System.out.println("Exception: " + ex.getMessage());
                    ex.printStackTrace();
                }
        });
        HBox buttons = new HBox(30);
        buttons.getChildren().addAll(AddStudent);
        BorderPane pane = new BorderPane();
        pane.setTop(buttons);
        Text t = new Text(10, 20, "School idol managment simulator");
        t.setFont(Font.font("Helvetica", FontPosture.ITALIC, 12));
        t.setFill(Color.BLACK);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(t);
        BorderPane pane1 = new BorderPane();
        pane1.setCenter(pane);
        pane1.setTop(vbox);
        Scene scene = new Scene(pane1, 1000, 800);
        Stage stage = new Stage();
        primaryStage.setTitle("");
        stage.setScene(scene);
        stage.show();







    }




    public static void main(String[] args) {
        launch(args);
    }

    public static void showValues(Connection conn, String table)
    {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM " + table);
            Main.showResults(table, rset);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void showColumns(Connection conn, String table)
    {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SHOW COLUMNS FROM " + table);
            Main.showResults(table, rset);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void showResults(String tableName, ResultSet rSet)
    {
        try
        {
            ResultSetMetaData rsmd = rSet.getMetaData();
            int numColumns = rsmd.getColumnCount();
            String resultString = null;
            if (numColumns > 0)
            {
                resultString = "\nTable: " + tableName + "\n" +
                        "=======================================================\n";
                for (int colNum = 1; colNum <= numColumns; colNum++)
                    resultString += rsmd.getColumnLabel(colNum) + "     ";
            }
            System.out.println(resultString);
            System.out.println(
                    "=======================================================");

            while (rSet.next())
            {
                resultString = "";
                for (int colNum = 1; colNum <= numColumns; colNum++)
                {
                    String column = rSet.getString(colNum);
                    if (column != null)
                        resultString += column + "     ";
                }
                System.out.println(resultString + '\n' +
                        "-------------------------------------------------------");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static String dataInput(String BoxTitle, String msgToUser, String indicator) {
        TextInputDialog textInputDialog = new TextInputDialog(indicator);
        textInputDialog.setTitle("Adding");
        textInputDialog.setHeaderText(BoxTitle);
        textInputDialog.setContentText(msgToUser);
        textInputDialog.initStyle(StageStyle.UTILITY);
        Optional < String > result = textInputDialog.showAndWait();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get();
        }
    }
}




