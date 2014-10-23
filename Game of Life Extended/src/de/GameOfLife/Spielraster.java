package de.GameOfLife;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

//ToDo überlegen ob diese Klasse nicht als Singleton erzeugt wird dann muss man sie nicht immer mitgeben
public class Spielraster implements Serializable {

private static final long serialVersionUID = 1849731288047615175L;

private int anzMenschenInfiziert;
private int anzMenschenResistent;
private int anzMenschenGesund;
private int anzMenschenGestorben;
//
private int anzTiereInfiziert;
private int anzTiereResistent;
private int anzTiereGesund;
private int anzTiereGestorben;

//rastereigenschaften
private int groesse;
private int maxX;
private int maxY;

//Krankheitseigenschaften
private boolean tierAufMensch;
private boolean menschAufMensch;
private boolean tierAufTier;
private boolean menschAufTier;
private double infektionsRate;
private double resistenzRate;
private double heilungsRate;
private double sterbeRate;
public int rundenCounter = 0;

private Spezie[][] raster =new Spezie[1][1];

public Spielraster(int startMenschenInfizierte,int startMenschenResistent,int startMenschenGesund,
		int startTiereInfiziert,int startTiereResistent,int startTiereGesund, int groesse,
		Krankheiten k){
		this(startMenschenInfizierte, startMenschenResistent, startMenschenGesund, startTiereInfiziert, startTiereResistent, startTiereGesund, (int)Math.round(Math.sqrt(groesse)), (int)Math.round(Math.sqrt(groesse)), k);
	
		
	}


public Spielraster(int startMenschenInfizierte,int startMenschenResistent,int startMenschenGesund,
		int startTiereInfiziert,int startTiereResistent,int startTiereGesund, int x,int y,
		Krankheiten k){
	 anzMenschenInfiziert=startMenschenInfizierte;
	 anzMenschenResistent = startMenschenResistent;
	 anzMenschenGesund=startMenschenGesund;
	 anzTiereInfiziert=startTiereInfiziert;
	 anzTiereResistent=startTiereResistent;
	 anzTiereGesund=startTiereGesund;
	 
	 //Krankheitseigenschaften übernehemen
	 
	 tierAufMensch=k.isTierAufMensch();
	 tierAufTier=k.isTierAufTier();
	 menschAufMensch=k.isMenschAufMensch();
	 menschAufTier=k.isMenschAufTier();
	 
	 infektionsRate=k.getInfektionsRate();
	 resistenzRate=k.getResistenzRate();
	 heilungsRate=k.getHeilungsRate();
	 sterbeRate=k.getSterbeRate();
	 
	 
	 
	 
	 maxX=x;
	 maxY=y;
	 
	 raster=new Spezie[maxX][maxY];
	 //sorgt dafür das auch wirkliche durch 2 teilbare Größe gespeichert wird
	 //bsp.: falls User 13 eingibt wird 13/2=6 gerechnet dann 6*2=12 also die Anzahl die auch wirklich genutzt wird;
	 groesse=maxX*maxY;
	 this.besiedleRaster();

}

private void besiedleRaster(){

	
	//sanity checks einbauen
	
	//ist Raster überhaupt groß genug für Anzahl der Individuen
	
	
	
	Random rand = new Random();
	
	
	//verteile gesunde Menschen
	for(int i=0;i<anzMenschenGesund; i++){
		boolean gesetzt=false;
		while(!gesetzt){
			int x=rand.nextInt()%(maxX);
			if(x<0){x=x*-1;}
			int y=rand.nextInt()%(maxY);
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
			int y=rand.nextInt()%(maxY);
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
			int y=rand.nextInt()%(maxY);
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
			int y=rand.nextInt()%(maxY);
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
			int y=rand.nextInt()%(maxY);
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
			int y=rand.nextInt()%(maxY);
			if(y<0){y=y*-1;}
			if(raster[x][y]==null){
				//die beiden hinteren Werte müssen irgendwie global verwaltet werden
				raster[x][y]= new Tier(true, true, y, x, this, menschAufTier, tierAufTier);
				gesetzt=true;
			}
		}
		
	}
};

public boolean setzeZelle(int x, int y, Spezie lSpezie, int altX, int altY){
	Spezie curr;
	boolean error=false;
	if(x<0 || y<0 || x>maxX || y>maxY){
		error=true;
	}
	try{
		curr=raster[x][y];
	}catch(ArrayIndexOutOfBoundsException e){
		curr=null;
		error=true;
	}
	if(curr !=null || error ){
		return false;
	}else{
		raster[x][y]=lSpezie;
		raster[altX][altY]=null;
		return true;
	}
	
	
	
}


public int zustandsBeschreibung(int xPos, int yPos){
	int rueckgabe=0;
	Spezie ausgewaehlt;
	try{
		ausgewaehlt=raster[xPos][yPos];
	}catch(ArrayIndexOutOfBoundsException e){
		ausgewaehlt=null;
	}
	if(ausgewaehlt==null){
		rueckgabe=0;
	}else if(ausgewaehlt instanceof Mensch){
		if(ausgewaehlt.isGesund()){
			rueckgabe=1;
		}else{
			rueckgabe=2;
		}
		if(ausgewaehlt.isResistent()){
			rueckgabe=3;
		}
	}else if(ausgewaehlt instanceof Tier){
		if(ausgewaehlt.isGesund()){
			rueckgabe=4;
		}else{
			rueckgabe=5;
		}
		if (ausgewaehlt.isResistent()) {
			rueckgabe=6;
		}
	}
	return rueckgabe;
}

 public Spezie holeSpezieVon(int xPos,int  yPos){
	 Spezie nachbar;
	 try {
		nachbar=raster[xPos][yPos];
	} catch (ArrayIndexOutOfBoundsException e) {
		nachbar=null;
	}
	 
	 return nachbar;
	 
 }
 
 
 public synchronized void iteriere(int anzRunden){
	anzMenschenGestorben=0;
	anzTiereGestorben=0;
	 for (int i = 0; i < anzRunden; i++) {
			rundenCounter++;
			Spezie curr;
			for(int y=0; y<maxY; y++){
				
			
				//in jeder Reihe über die x-Koordinaten gehen
				for(int x=0; x<maxX; x++){
					curr=raster[x][y];
					if(curr!=null && !(curr.getWarDran())){
						//ToDo: raten flexibel halten!!!!
						if(curr.iteration(infektionsRate, resistenzRate, heilungsRate, sterbeRate)){
							
							//zelle ist tot-->Referenz wird gelöscht
							raster[x][y]=null;
							//Todescounter inkremtieren solange Referenz auf Zelle noch da ist
							if(curr instanceof Mensch) {
								anzMenschenGestorben++;		
							}else{
								anzTiereGestorben++;
							}
						}
					}
				}
			}
			this.reseteAlleZellen();
		}
		
		this.aktualiesiereStats();
	}
 
 public void aktualiesiereStats(){
		int menschenInfiziert=0;
		int menschenGesund =0;
		int menschenResistent=0;
		int tiereInfiziert=0;
		int tiereGesund=0;
		int tiereResistent=0;
	 
	 
	 	Spezie curr;
		for(int y=0; y<maxY; y++){
			
		
			//in jeder Reihe über die x-Koordinaten gehen
			for(int x=0; x<maxX; x++){
				curr=raster[x][y];
				if(curr!=null){
					if(curr instanceof Mensch){
						if(curr.isGesund()){
							menschenGesund++;
						}else{
							menschenInfiziert++;
						}
						if(curr.isResistent()){
							menschenResistent++;
						}
					}else if(curr instanceof Tier){
						
						if(curr.isGesund()){
							tiereGesund++;
						}else{
							tiereInfiziert++;
						}
						if(curr.isResistent()){
							tiereResistent++;
						}
					}
				}
			}
		}
		//Stats für Menschen updaten
		anzMenschenInfiziert=menschenInfiziert;
		anzMenschenResistent=menschenResistent;
		anzMenschenGesund=menschenGesund-menschenResistent;
		//Stats für Tiere updaten
		anzTiereGesund=tiereGesund-tiereResistent;
		anzTiereInfiziert=tiereInfiziert;
		anzTiereResistent=tiereResistent;
		
		
 }
 
 
 
 
//setzt das Attribut warDran innerhalb aller Zellen auf false
public void reseteAlleZellen(){
	
		Spezie curr;
		for(int y=0; y<maxY; y++){
			
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

public int getAnzMenschenGestorben(){
	return anzMenschenGestorben;
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
}

public int getAnzTiereGestorben(){
	return anzTiereGestorben;
}

public void saveState(){
	try
	{
		//Serialize Object to a file
		FileOutputStream fileOut =
				new FileOutputStream("Zustand_"+System.currentTimeMillis()+ ".ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(raster);
				out.close();
				fileOut.close();
				
				System.out.println("Serialized data is saved in given folder");
	}	catch(IOException i)
	{
			i.printStackTrace();
	}
	
}

public void loadState(File f){
	Spezie[][] raster = null;
	try
    {
       FileInputStream fileIn = new FileInputStream(f);
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


