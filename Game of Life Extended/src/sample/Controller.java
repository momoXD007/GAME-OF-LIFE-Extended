package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.GameOfLife.Aids;
import de.GameOfLife.Spielraster;

public class Controller implements Initializable {


    public ComboBox comboKrank;
    public TextField text_gm;
    public Button goButton;

    public RadioButton zufall;
    public RadioButton bestehend;
    public TextField path;
    public ToggleGroup start;

    private File config;
    	
    public void go(ActionEvent event) {
        Stage stage =  (Stage)goButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        MainController mc = null;
        try {
//            root = loader.load(getClass().getResource("main.fxml"));
            root = loader.load(getClass().getResource("main.fxml").openStream());
            mc = (MainController) loader.getController();
    		Spielraster raster = new Spielraster(500, 50, 500, 40, 20, 80, 2500, new Aids());
    		mc.setSpiel(raster);
    		mc.updateRaster();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setResizable(true);
    }

    public void setText(String s) {
        text_gm.setText(s);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboKrank.getItems().addAll(
                "Hallo",
                "Test"
        );
        goButton.setText("GO");
        zufall.setSelected(true);
        path.setDisable(true);

        start.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (start.getSelectedToggle().equals(zufall)) {
                    path.setDisable(true);
                }
                if (start.getSelectedToggle().equals(bestehend)) {
                    path.setDisable(false);
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Open Resource File");
                    Stage file = new Stage();
                    config = fileChooser.showOpenDialog(file);
                    path.setText(config.getAbsolutePath());
                }
            }
        });
    }

    public File getStartResource(){
        return config;
    }
}
