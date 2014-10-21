package sample;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

import de.GameOfLife.Spielraster;

/**
 * Created by Marvin on 20.10.2014.
 */
public class MainController implements Initializable {
	public BorderPane borderBack;
	public TilePane spielfeld;
	private Spielraster spiel;
	public TextField rundenZahl;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		spielfeld = new TilePane();
		spielfeld.setHgap(1);
		spielfeld.setVgap(1);
		spielfeld.setPrefColumns(50);
		spielfeld.setPrefRows(50);
		Group display = new Group(spielfeld);
		borderBack.setCenter(display);
	}

	public void setSpiel(Spielraster s) {
		spiel = s;
	}

	public void updateRaster() {
		if(spiel!=null){
			spielfeld.getChildren().clear();
			for (int x = 0; x < 50; x++) {
				for (int y = 0; y < 50; y++) {
					int code = spiel.zustandsBeschreibung(x, y);
					switch (code) {
					case 0:
						spielfeld.getChildren().add(new Rectangle(5,5,Color.TRANSPARENT));
						break;
					case 1:
						spielfeld.getChildren().add(new Circle(2.5,Color.GREEN));
						break;
					case 2:
						spielfeld.getChildren().add(new Circle(2.5,Color.RED));
						break;
					case 3:
						spielfeld.getChildren().add(new Circle(2.5,Color.BLACK));
						break;
					case 4:
						spielfeld.getChildren().add(new Rectangle(5,5,Color.GREEN));
						break;
					case 5:
						spielfeld.getChildren().add(new Rectangle(5,5,Color.RED));
					break;
					case 6:
						spielfeld.getChildren().add(new Rectangle(5,5,Color.BLACK));
						break;
					default:
						break;
					}
				}
				
			}
		}
	}
	
	public void starteSimulation(){
		String zahl = rundenZahl.getText();
		int runden;
		try {
			runden = Integer.parseInt(zahl);
			spiel.iteriere(runden);
			updateRaster();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
