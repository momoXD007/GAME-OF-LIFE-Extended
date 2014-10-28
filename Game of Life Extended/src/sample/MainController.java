package sample;

import java.net.URL;
import java.util.ResourceBundle;

import sample.LaufenLasser;
import de.GameOfLife.Spielraster;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
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
	public static final int x_koordinate = 150;
	public static final int y_koordinate = 75;
	@FXML // fx:id="toteMenschen"
    private TextField toteMenschen; // Value injected by FXMLLoader

    @FXML // fx:id="toteTiere"
    private TextField toteTiere; // Value injected by FXMLLoader
	public BorderPane borderBack;
	public TilePane spielfeld;
	private Spielraster spiel;
	public TextField rundenZahl;
	public CheckBox endlosBox;
	public Button simulateButton;
	public Button loeseButton;
	private boolean running = false;
	private LaufenLasser lassIhn;
	private int startGroese;
	@FXML
	public LineChart<?, ?> menschChart;    
	@FXML // fx:id="tierChart"
    private LineChart<?, ?> tierChart; // Value injected by FXMLLoader
	public XYChart.Series menschGesund = new XYChart.Series();
	public XYChart.Series menschInfiziert = new XYChart.Series();
	public XYChart.Series menschResistent = new XYChart.Series();
	public XYChart.Series tierGesund = new XYChart.Series();
	public XYChart.Series tierInfiziert = new XYChart.Series();
	public XYChart.Series tierResistent = new XYChart.Series();

	//@Override
	public void initialize(URL location, ResourceBundle resources) {

		spielfeld = new TilePane();
		spielfeld.setHgap(1);
		spielfeld.setVgap(1);
		spielfeld.setPrefColumns(x_koordinate);
		spielfeld.setPrefRows(y_koordinate);
		Group display = new Group(spielfeld);
		borderBack.setCenter(display);
		initCharts();
	}

	public void setSpiel(Spielraster s) {
		spiel = s;
	}

	public void updateRaster() {
		if (spiel != null) {
			spielfeld.getChildren().clear();
			for (int y = 0; y < y_koordinate; y++) {
				for (int x = 0; x < x_koordinate; x++) {
					int code = spiel.zustandsBeschreibung(x, y);
					switch (code) {
					case 0:
						spielfeld.getChildren().add(
								new Rectangle(5, 5, Color.WHITE));
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
			updateCharts();
			if(spiel!=null){
				toteMenschen.setText(String.valueOf(spiel.getAnzMenschenGestorben()));
				toteTiere.setText(String.valueOf(spiel.getAnzTiereGestorben()));
			}
		}
	}

	private void updateCharts() {
		String runde = "Runde " +spiel.rundenCounter;
	
		menschGesund.getData().add(new XYChart.Data(runde,spiel.getMenschenAnzGesund()));
		menschInfiziert.getData().add(new XYChart.Data(runde,spiel.getMesnchenAnzInfiziert()));
		menschResistent.getData().add(new XYChart.Data(runde,spiel.getAnzMenschenResisten()));

		tierGesund.getData().add(new XYChart.Data(runde,spiel.getAnzTiereGesund()));
		tierInfiziert.getData().add(new XYChart.Data(runde,spiel.getAnzTiereInfiziert()));
		tierResistent.getData().add(new XYChart.Data(runde,spiel.getAnzTiereResistent()));
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
	public void initCharts(){
		tierChart.setCreateSymbols(false);
		menschChart.setCreateSymbols(false);
		
		menschGesund.setName("Gesund"); 
		tierGesund.setName("Gesund");	
		menschInfiziert.setName("Infiziert"); 
		tierInfiziert.setName("Infiziert");	
		
		menschResistent.setName("Resistent"); 
		tierResistent.setName("Resistent");	
		
		menschChart.getData().addAll(menschGesund,menschInfiziert,menschResistent);
		tierChart.getData().addAll(tierGesund,tierInfiziert,tierResistent);
		

	
	}
}
