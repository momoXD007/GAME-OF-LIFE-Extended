package de.GameOfLife;

public class Tuberkulose extends Krankheiten {
	
	//Tuberkulose aktuell weltweit

	public Tuberkulose() {
		this.setTierAufTier(true);
		this.setMenschAufTier(false); //nicht erforscht
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.00123); //1/3 ist infiziert (bricht nur bei 10% aus)
		this.setHeilungsRate(0.75);
		this.setSterbeRate(0.15);	
		this.setResistenzRate(0.9); //1/3 ist infiziert (bricht nur bei 10% aus)
	}
}
