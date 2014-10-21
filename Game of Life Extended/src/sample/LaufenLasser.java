package sample;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import de.GameOfLife.Spielraster;

public class LaufenLasser extends Thread {

	private Spielraster sp;
	private Button b;
	private int schritte;

	public LaufenLasser(Spielraster sp, Button b, int s) {
		super();
		setDaemon(true);
		this.sp = sp;
		this.b = b;
		this.schritte = s;
	}

	public void run() {
		while (!this.isInterrupted()) {
			sp.iteriere(schritte);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
