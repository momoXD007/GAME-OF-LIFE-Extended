package de.GameOfLife;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spielraster raster = new Spielraster(10, 2, 10, 0, 2, 10, 100);
		raster.iteriere(5);
	}

}
