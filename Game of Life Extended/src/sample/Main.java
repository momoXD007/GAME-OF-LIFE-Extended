package sample;

import de.GameOfLife.Pest;
import de.GameOfLife.Spielraster;
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
//        launch(args);
    	
    double daySum = 0;
    for (int i = 0; i < 1000; i++) {
    	Spielraster raster = new Spielraster(75, 0, 5000, 75, 0, 5000, 150,75, new Pest());
    	int maxInf=0;
    	int day =0;
    	for (int j = 0; j < 50; j++) {
			raster.iteriere(1);
			if(maxInf < raster.getAnzTiereInfiziert()+raster.getMesnchenAnzInfiziert()){
				maxInf = raster.getAnzTiereInfiziert()+raster.getMesnchenAnzInfiziert();
				day = j;
			}
    	}
    	daySum += day;
	}
   System.out.println(daySum/1000);
    
    }
}
