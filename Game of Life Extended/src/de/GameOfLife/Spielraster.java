package de.GameOfLife;
//ToDo überlegen ob diese Klasse nicht als Singleton erzeugt wird dann muss man sie nicht immer mitgeben
public class Spielraster {
private int anzInfiziert;
private int anzResistent;
private int anzGesund;
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
					if(curr!=null && !(curr.getWarDran())){
						//ToDo: raten flexibel halten!!!!
						if(curr.iteration(0.2, 0.2, 0.2, 0.2)){
							//zelle ist tot-->Referenz wird gelöscht
							raster[x][y]=null;
						}
					}
				}
			}
		}
		this.reseteAlleZellen();
	}
 
 public void aktualiesiereStats(){
		int infiziert=0;
		int gesund =0;
		int resistent=0;
	 
	 
	 	Spezie curr;
		for(int y=0; y<groesse/2; y++){
			
		
			//in jeder Reihe über die x-Koordinaten gehen
			for(int x=0; x<groesse/2; x++){
				curr=raster[x][y];
				if(curr!=null){
					if(curr.isGesund()){
						gesund++;
					}else if(curr.isResistent()){
						resistent++;
					}else{
						infiziert++;
					}
				}
			}
		}
		anzInfiziert=infiziert;
		anzResistent=resistent;
		anzGesund=gesund;
 }
 
 
 
 
//setzt das Attribut warDran innerhalb aller Zellen auf false
public void reseteAlleZellen(){
	
		Spezie curr;
		for(int y=0; y<groesse/2; y++){
			
		
			//in jeder Reihe über die x-Koordinaten gehen
			for(int x=0; x<groesse/2; x++){
				curr=raster[x][y];
				if(curr!=null){
					curr.setWarDran(false);
				}
			}
		}
	}



public int getAnzInfiziert(){
	return anzInfiziert;
}
public int getAnzResisten(){
	return anzResistent;
}
public int getAnzGesund(){
	return anzGesund;
}
public int getAnzGesamtLebendig(){
	return anzResistent+anzGesund+anzInfiziert;
}

}


