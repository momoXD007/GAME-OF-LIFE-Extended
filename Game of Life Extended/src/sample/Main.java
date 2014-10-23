package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root;
        root = (Parent) loader.load(getClass().getResource("sample.fxml").openStream());
        primaryStage.setTitle("Und wann bist du dran?");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("B_hazard.gif"))); 
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
