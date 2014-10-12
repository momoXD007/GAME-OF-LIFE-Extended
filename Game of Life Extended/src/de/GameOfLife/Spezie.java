package de.GameOfLife;

import java.util.Random;

public class Spezie {
 private boolean gesund;
 private boolean resistent;
 private Random zufallsGen = new Random();
 private double zufall=zufallsGen.nextDouble();
private int yPos;
private int xPos;
private Spielraster raster;
private boolean warDran=false;//beschreibt ob Zelle schon diese Runde dran war


 public Spezie(boolean lGesund,boolean lResistent,int lyPos, int lxPos, Spielraster lRaster){
	 
	 gesund=lGesund;
	 resistent=lResistent;
	 yPos=lyPos;
	 xPos=lxPos;
	 raster = lRaster;
 }
 
 protected  void bewege(){
	 //ToDo
	 
 };
 protected  Spezie[] getNeighbours(){
	 int gefunden=0;
	 Spezie[] nachbarn = new Spezie[8];
	 //oberer Nachbar
	 nachbarn[0]=raster.holeSpezieVon(xPos, yPos+1);
	 //oben rechts
	 nachbarn[1]=raster.holeSpezieVon(xPos+1, yPos+1);
	 //rechts
	 nachbarn[2]=raster.holeSpezieVon(xPos+1, yPos);
	 //unten rechts
	 nachbarn[3]=raster.holeSpezieVon(xPos+1, yPos-1);
	 //unten
	 nachbarn[4]=raster.holeSpezieVon(xPos, yPos-1);
	 //unten links
	 nachbarn[5]=raster.holeSpezieVon(xPos-1, yPos-1);
	 //links
	 nachbarn[6]=raster.holeSpezieVon(xPos-1, yPos);
	 //oben links
	 nachbarn[7]=raster.holeSpezieVon(xPos-1, yPos+1);
	 
	 
	 return nachbarn;
 }; 
 public boolean sterbe(double rate){
	 //toDo
	 
	 return rate>=zufall;
	 
 };
 
 public void werdeInfiziert(double rate) throws IllegalArgumentException{
	 if(rate<0 || rate>1){
		 throw new IllegalArgumentException("Argument muss einer Prozentzähl entsprechen");
	 }
	 
	 //checke ob bereits krank oder resistent
	 if(gesund && (!resistent)){
		 if(rate>=zufall){
			 //hier eventuell inkubationszeit einbauen
			 gesund=false;
		 }
	 }
 };
 protected void bildeResitenz(double rate){
 	if(!gesund && !resistent){
 		if(rate>=zufall){
 			gesund=true;
 			resistent=true;
 		}
 	}
 }
 
 protected void heile(double rate){
	 if(!gesund){
		 if(rate>=zufall){
			 gesund=true;
		 }
	 }
 }
 /**
  * 
  * @param infektionsRate wie wahrscheinlich ist es das eine Zelle eine andere benachbarte Zelle infiziert
  * @param resistenzRate Wahrscheinlichkeit das Zelle resitenz bildet
  * @param heilungsRate
  * @return gibt true zurück wenn Zelle gestorben ist
  */
public boolean iteration(double infektionsRate,double resistenzRate, double heilungsRate, double sterbeRate){
	zufall=zufallsGen.nextDouble();
	this.bewege();
	if(!gesund){
		Spezie nachbarn[] = this.getNeighbours();
		Spezie nachbar; 
		for(int i=0; i<nachbarn.length;i++ ){
			nachbar = nachbarn[i];
			if(nachbar !=null){
				nachbar.werdeInfiziert(infektionsRate);
			}
		}
		this.bildeResitenz(resistenzRate);
		if(!gesund){
			this.heile(heilungsRate);
		}
	}

	this.setWarDran(true);
	
	return sterbe(sterbeRate);


}
public boolean getWarDran(){
	return warDran;
}
public void setWarDran(boolean lWarDran){

	warDran=lWarDran;
}

public boolean isGesund() {
	return gesund;
}

public void setGesund(boolean gesund) {
	this.gesund = gesund;
}

public boolean isResistent() {
	return resistent;
}

public void setResistent(boolean resistent) {
	this.resistent = resistent;
}
}




