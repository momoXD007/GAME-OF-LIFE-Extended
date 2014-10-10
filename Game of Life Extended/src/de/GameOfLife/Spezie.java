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
 public void sterbe(double rate){
	 //toDo
	 
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
public void iteration(double infektionsRate,double resistenzRate, double heilungsRate){
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
}
 
}


