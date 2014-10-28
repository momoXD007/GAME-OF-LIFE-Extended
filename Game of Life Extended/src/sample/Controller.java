package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.GameOfLife.*;

public class Controller implements Initializable {

	public TextField text_it;
	public TextField text_rm;
	public TextField text_gt;
	public TextField text_gm;
	public ToggleGroup start;
	public Button goButton;
	public TextField text_rt;
	public RadioButton zufall;
	public TextField text_im;
	public ComboBox<String> comboKrank;
	public RadioButton bestehend;
	public TextField path;
	public ImageView bBild;
	private File config;

	//@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboKrank.getItems().addAll("AIDS", "Cholera (Hamburg 1892)", "Cholera (Simbabwe 2008/9)", "Dengue", "Ebola",
				"Mittelalterpest", "Schweinegrippe", "Spanische Grippe", "Tollwut", "Tuberkulose");
		goButton.setText("GO");
		zufall.setSelected(true);
		path.setDisable(true);
		bBild.setImage(new Image(Main.class.getResourceAsStream("B_hazard.gif")));
		start.selectedToggleProperty().addListener(
				new ChangeListener<Toggle>() {
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

	public void go(ActionEvent event) {
		Stage stage = (Stage) goButton.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		Parent root = null;
		MainController mc = null;
		try {
			root = loader
					.load(getClass().getResource("main.fxml").openStream());
			mc = (MainController) loader.getController();
			Spielraster raster = new Spielraster(Integer.parseInt(text_im
					.getText()), // inf menschen
					Integer.parseInt(text_rm.getText()), // res menschen
					Integer.parseInt(text_gm.getText()), // gesund menschen
					Integer.parseInt(text_it.getText()), // inf menschen
					Integer.parseInt(text_rt.getText()), // res menschen
					Integer.parseInt(text_gt.getText()), // gesund menschen
					MainController.x_koordinate,
					MainController.y_koordinate	, getKrankheit());
			mc.setSpiel(raster);
			mc.updateRaster();

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add("sample/legende.css");
		stage.setScene(scene);
		stage.show();
		stage.centerOnScreen();
		stage.setResizable(true);
	}

	private Krankheiten getKrankheit() {
		Krankheiten k = null;
		String kString = comboKrank.getValue();
		if (kString.equals("AIDS")) {
			k = new Aids();
		}
		if (kString.equals("Cholera (Hamburg 1892)")) {
			k= new Cholera();
		}
		if (kString.equals("Dengue")) {
			k=new Dengue();
		}
		if (kString.equals("Ebola")) {
			k=new Ebola();
		}
		if (kString.equals("Mittelalterpest")) {
			k = new Pest();
		}
		if (kString.equals("Cholera (Simbabwe 2008/9)")) {
			k = new CholeraAfrika();
		}
		if (kString.equals("Schweinegrippe")) {
			k = new Schweinegrippe();
		}
		if (kString.equals("Tollwut")) {
			k = new Tollwut();
		}
		if (kString.equals("Tuberkulose")) {
			k = new Tuberkulose();
		}
		if (kString.equals("Spanische Grippe")) {
			k = new SpanischeGrippe();
		}
		return k;
	}

	public File getStartResource() {
		return config;
	}
}
