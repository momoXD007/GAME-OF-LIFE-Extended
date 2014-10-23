package de.GameOfLife;

public class Pest extends Krankheiten {
	
	
	public Pest() {
		this.setTierAufTier(true);
		this.setMenschAufTier(true);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.33);;
		this.setHeilungsRate(0.75);
		this.setSterbeRate(0.3);	
		this.setResistenzRate(0.02);
	}
}
