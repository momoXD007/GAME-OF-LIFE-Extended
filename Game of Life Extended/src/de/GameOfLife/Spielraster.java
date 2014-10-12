package de.GameOfLife;
//ToDo überlegen ob diese Klasse nicht als Singleton erzeugt wird dann muss man sie nicht immer mitgeben
public class Spielraster {
private int anzInfiziert;
private int anzResistent;
private int groesse;

private Spezie[][] raster =new Spezie[1][1];

public Spielraster(int startInfizierte,int startResistent, int startGroesse){
	 anzInfiziert=startInfizierte;
	 anzResistent = startResistent;
	 raster=new Spezie[startGroesse/2][startGroesse/2];
	 //sorgt dafür das auch wirkliche durch 2 teilbare Größe gespeichert wird
	 //bsp.: falls User 13 eingibt wird 13/2=6 gerechnet dann 6*2=12 also die Anzahl die auch wirklich genutzt wird;
	 groesse=(startGroesse/2)*2;
	 this.besiedleRaster();

}

private void besiedleRaster(){
	//ToDo was sinnvolles implementieren
	raster[0][0]= new Spezie(true, false, 0, 0, this); 
	raster[0][1]= new Spezie(false, false, 1, 0, this);
};



 public Spezie holeSpezieVon(int xPos,int  yPos){
	 Spezie nachbar;
	 try {
		nachbar=raster[xPos][yPos];
	} catch (ArrayIndexOutOfBoundsException e) {
		nachbar=null;
	}
	 
	 return nachbar;
	 
 }
 
 
 public void iteriere(int anzRunden){
		for (int i = 0; i < anzRunden; i++) {
			Spezie curr;
			for(int y=0; y<groesse/2; y++){
				
			
				//in jeder Reihe über die x-Koordinaten gehen
				for(int x=0; x<groesse/2; x++){
					curr=raster[x][y];
					if(curr!=null){
						//ToDo: raten flexibel halten!!!!
						curr.iteration(0.2, 0.2, 0.2);
					}
				}
			}
		}
	}
 
 
}


