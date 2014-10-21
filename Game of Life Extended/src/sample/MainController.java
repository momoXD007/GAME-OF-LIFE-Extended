package sample;

import java.net.URL;
import java.util.ResourceBundle;

import sample.LaufenLasser;
import de.GameOfLife.Spielraster;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

/**
 * Created by Marvin on 20.10.2014.
 */
public class MainController implements Initializable {
	public BorderPane borderBack;
	public TilePane spielfeld;
	private Spielraster spiel;
	public TextField rundenZahl;
	public CheckBox endlosBox;
	public Button simulateButton;
	public Button loeseButton;
	private boolean running = false;
	private LaufenLasser lassIhn;
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
		if (spiel != null) {
			spielfeld.getChildren().clear();
			for (int x = 0; x < 50; x++) {
				for (int y = 0; y < 50; y++) {
					int code = spiel.zustandsBeschreibung(x, y);
					switch (code) {
					case 0:
						spielfeld.getChildren().add(
								new Rectangle(5, 5, Color.ANTIQUEWHITE));
						break;
					case 1:
						spielfeld.getChildren().add(
								new Circle(2.5, Color.GREEN));
						break;
					case 2:
						spielfeld.getChildren().add(new Circle(2.5, Color.RED));
						break;
					case 3:
						spielfeld.getChildren().add(
								new Circle(2.5, Color.BLACK));
						break;
					case 4:
						spielfeld.getChildren().add(
								new Rectangle(5, 5, Color.GREEN));
						break;
					case 5:
						spielfeld.getChildren().add(
								new Rectangle(5, 5, Color.RED));
						break;
					case 6:
						spielfeld.getChildren().add(
								new Rectangle(5, 5, Color.BLACK));
						break;
					default:
						break;
					}
				}

			}
		}
	}

	@SuppressWarnings("deprecation")
	public void starteSimulation() {
		if (!running) {
			String zahl = rundenZahl.getText();
			final int runden;
			runden = Integer.parseInt(zahl);
			
			if (!endlosBox.isSelected() && runden > 0) {

				spiel.iteriere(runden);
				updateRaster();

			} else if (endlosBox.isSelected() && runden > 0) {
				simulateButton.setText("STOP");
				running = true;
				lassIhn = new LaufenLasser(spiel, loeseButton, runden);
				lassIhn.start();
				
			}

		} else {
			simulateButton.setText("Simulate");
			running = false;
			lassIhn.stop();
			lassIhn = null;
		}
	}

	@FXML
	public void checkeKey(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			starteSimulation();
		}
	}
	public void machUpdate(){
		updateRaster();
	}
}
