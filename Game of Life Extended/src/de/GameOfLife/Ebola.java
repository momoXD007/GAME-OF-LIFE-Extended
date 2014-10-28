package de.GameOfLife;

public class Ebola extends Krankheiten {
	
	//Aktuelle Zahlen weltweit
	
	public Ebola() {
		this.setTierAufTier(true);
		this.setMenschAufTier(false);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.1);
		this.setHeilungsRate(0.3);
		this.setSterbeRate(0.7);	
		this.setResistenzRate(0);
	}	
	
}
