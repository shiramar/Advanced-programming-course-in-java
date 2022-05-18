import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawShape extends Application{

    public void start(Stage stage) throws Exception{
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("DrawShape.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("DrawShape");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }

    //enum for the shape
    public static enum ShapeName{
        ELLIPSE,
        RECTANGLE,
        LINE;
    }


}
