package de.GameOfLife;
import java.util.Random;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

//ToDo überlegen ob diese Klasse nicht als Singleton erzeugt wird dann muss man sie nicht immer mitgeben
public class Spielraster implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1849731288047615175L;
/**
	 * 
	 */
//private static final long serialVersionUID = 1L;
	
	
private int anzMenschenInfiziert;
private int anzMenschenResistent;
private int anzMenschenGesund;

//
private int anzTiereInfiziert;
private int anzTiereResistent;
private int anzTiereGesund;

//rastereigenschaften
private int groesse;
private int maxX;

//Krankheitseigenschaften
private boolean tierAufMensch;
private boolean menschAufMensch;
private boolean tierAufTier;
private boolean menschAufTier;


private Spezie[][] raster =new Spezie[1][1];

public Spielraster(int startMenschenInfizierte,int startMenschenResistent,int startMenschenGesund,
		int startTiereInfiziert,int startTiereResistent,int startTiereGesund, int startGroesse,
		boolean lTierAufMensch, boolean lMenschAufMsnch,boolean lTierAufTier, boolean lMenschAufTier){
	 anzMenschenInfiziert=startMenschenInfizierte;
	 anzMenschenResistent = startMenschenResistent;
	 anzMenschenGesund=startMenschenGesund;
	 anzTiereInfiziert=startTiereInfiziert;
	 anzTiereResistent=startTiereResistent;
	 anzTiereGesund=startTiereGesund;
	 
	 //Krankheitseigenschaften übernehemen
	 
	 tierAufMensch=lTierAufMensch;
	 tierAufTier=lTierAufTier;
	 menschAufMensch=lMenschAufMsnch;
	 menschAufTier=lMenschAufTier;
	 
	 
	 maxX=(int) Math.round(Math.sqrt(startGroesse));
	 
	 raster=new Spezie[maxX][maxX];
	 //sorgt dafür das auch wirkliche durch 2 teilbare Größe gespeichert wird
	 //bsp.: falls User 13 eingibt wird 13/2=6 gerechnet dann 6*2=12 also die Anzahl die auch wirklich genutzt wird;
	 groesse=maxX*maxX;
	 this.besiedleRaster();

}

private void besiedleRaster(){
	//ToDo was sinnvolles implementieren
	//raster[0][0]= new Spezie(true, false, 0, 0, this); 
	//raster[0][1]= new Spezie(false, false, 1, 0, this);
	
	//sanity checks einbauen
	
	//ist Raster überhaupt groß genug für Anzahl der Individuen
	
	
	
	Random rand = new Random();
	
	
	//verteile gesunde Menschen
	for(int i=0;i<anzMenschenGesund; i++){
		boolean gesetzt=false;
		while(!gesetzt){
			int x=rand.nextInt()%(maxX);
			if(x<0){x=x*-1;}
			int y=rand.nextInt()%(maxX);
			if(y<0){y=y*-1;}
			if(raster[x][y]==null){
				//die beiden hinteren Werte müssen irgendwie global verwaltet werden
				raster[x][y]= new Mensch(true, false, y, x, this, menschAufMensch, tierAufMensch);
				gesetzt=true;
			}
		}
		
	}
	
	//setze Infizierte Menschen
	for(int i=0;i<anzMenschenInfiziert; i++){
		boolean gesetzt=false;
		while(!gesetzt){
			int x=rand.nextInt()%(maxX);
			if(x<0){x=x*-1;}
			int y=rand.nextInt()%(maxX);
			if(y<0){y=y*-1;}
			if(raster[x][y]==null){
				//die beiden hinteren Werte müssen irgendwie global verwaltet werden
				raster[x][y]= new Mensch(false, false, y, x, this, menschAufMensch, tierAufMensch);
				gesetzt=true;
			}
		}
		
	}
	
	//setze Resitente Menschen

	
	for(int i=0;i<anzMenschenResistent; i++){
		boolean gesetzt=false;
		while(!gesetzt){
			int x=rand.nextInt()%(maxX);
			if(x<0){x=x*-1;}
			int y=rand.nextInt()%(maxX);
			if(y<0){y=y*-1;}
			if(raster[x][y]==null){
				//die beiden hinteren Werte müssen irgendwie global verwaltet werden
				raster[x][y]= new Mensch(true, true, y, x, this, menschAufMensch, tierAufMensch);
				gesetzt=true;
			}
		}
		
	}
	//setze gesunde Tiere
	for(int i=0;i<anzTiereGesund; i++){
		boolean gesetzt=false;
		while(!gesetzt){
			int x=rand.nextInt()%(maxX);
			if(x<0){x=x*-1;}
			int y=rand.nextInt()%(maxX);
			if(y<0){y=y*-1;}
			if(raster[x][y]==null){
				//die beiden hinteren Werte müssen irgendwie global verwaltet werden
				raster[x][y]= new Tier(true, false, y, x, this, menschAufTier, tierAufTier);
				gesetzt=true;
			}
		}
		
	}
	
	//setzte kranke Tiere
	for(int i=0;i<anzTiereInfiziert; i++){
		boolean gesetzt=false;
		while(!gesetzt){
			int x=rand.nextInt()%(maxX);
			if(x<0){x=x*-1;}
			int y=rand.nextInt()%(maxX);
			if(y<0){y=y*-1;}
			if(raster[x][y]==null){
				//die beiden hinteren Werte müssen irgendwie global verwaltet werden
				raster[x][y]= new Tier(false, false, y, x, this, menschAufTier, tierAufTier);
				gesetzt=true;
			}
		}
		
	}
	//setze Resitente Tiere
	for(int i=0;i<anzTiereResistent; i++){
		boolean gesetzt=false;
		while(!gesetzt){
			int x=rand.nextInt()%(maxX);
			if(x<0){x=x*-1;}
			int y=rand.nextInt()%(maxX);
			if(y<0){y=y*-1;}
			if(raster[x][y]==null){
				//die beiden hinteren Werte müssen irgendwie global verwaltet werden
				raster[x][y]= new Tier(true, true, y, x, this, menschAufTier, tierAufTier);
				gesetzt=true;
			}
		}
		
	}
	
	
	
	
	
	
	
	



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
			for(int y=0; y<maxX; y++){
				
			
				//in jeder Reihe über die x-Koordinaten gehen
				for(int x=0; x<maxX; x++){
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
		int menschenInfiziert=0;
		int menschenGesund =0;
		int menschenResistent=0;
		int tiereInfiziert=0;
		int tiereGesund=0;
		int tiereResistent=0;
	 
	 
	 	Spezie curr;
		for(int y=0; y<maxX; y++){
			
		
			//in jeder Reihe über die x-Koordinaten gehen
			for(int x=0; x<maxX; x++){
				curr=raster[x][y];
				if(curr!=null){
					if(curr instanceof Mensch){
						if(curr.isGesund()){
							menschenGesund++;
						}else if(curr.isResistent()){
							menschenResistent++;
						}else{
							menschenInfiziert++;
						}
					}else if(curr instanceof Tier){
						
						if(curr.isGesund()){
							tiereGesund++;
						}else if(curr.isResistent()){
							tiereResistent++;
						}else{
							tiereInfiziert++;
						}
					}
				}
			}
		}
		//Stats für Menschen updaten
		anzMenschenInfiziert=menschenInfiziert;
		anzMenschenResistent=menschenResistent;
		anzMenschenGesund=menschenGesund;
		//Stats für Tiere updaten
		anzTiereGesund=tiereGesund;
		anzTiereInfiziert=tiereInfiziert;
		anzTiereResistent=tiereResistent;
		
		
 }
 
 
 
 
//setzt das Attribut warDran innerhalb aller Zellen auf false
public void reseteAlleZellen(){
	
		Spezie curr;
		for(int y=0; y<maxX; y++){
			
		
			//in jeder Reihe über die x-Koordinaten gehen
			for(int x=0; x<maxX; x++){
				curr=raster[x][y];
				if(curr!=null){
					curr.setWarDran(false);
				}
			}
		}
	}



public int getMesnchenAnzInfiziert(){
	return anzMenschenInfiziert;
}

public int getAnzMenschenResisten(){
	return anzMenschenResistent;
}

public int getMenschenAnzGesund(){
	return anzMenschenGesund;
}

public int getAnzMenschenGesamtLebendig(){
	return anzMenschenResistent+anzMenschenGesund+anzMenschenInfiziert;
}

public int getAnzTiereInfiziert() {
	return anzTiereInfiziert;
}

public int getAnzTiereGesund(){
	return anzTiereGesund;
}
public int getAnzTiereResistent() {
	return anzTiereResistent;


public void saveState(){
	try
	{
		//Serialize Object to a file
		FileOutputStream fileOut =
				new FileOutputStream("C:\\Zustand.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(raster);
				out.close();
				fileOut.close();
				
				System.out.printf("Serialized data is saved in given folder");
	}	catch(IOException i)
	{
			i.printStackTrace();
	}
	
}

public void loadState(){
	Spezie[][] raster = null;
	try
    {
       FileInputStream fileIn = new FileInputStream("C:\\Zustand.ser");
       ObjectInputStream in = new ObjectInputStream(fileIn);
       raster = (Spezie[][]) in.readObject();
       in.close();
       fileIn.close();
    }catch(IOException i)
    {
       i.printStackTrace();
       return;
    }catch(ClassNotFoundException c)
    {
       System.out.println("Die Zustandsklasse konnte nicht gefunden werden");
       c.printStackTrace();
       return;
    }
	

}


}


