package de.GameOfLife;

public class Pest extends Krankheiten {
	
	//Raten aus dem Mittelalter
	
	public Pest() {
		this.setTierAufTier(true);
		this.setMenschAufTier(true);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.33);;
		this.setHeilungsRate(0.002);
		this.setSterbeRate(0.70);	
		this.setResistenzRate(0.002);
	}
}
