package de.GameOfLife;

public class Aids extends Krankheiten {
	

	public Aids() {
		this.setTierAufTier(true);
		this.setMenschAufTier(false);
		this.setTierAufMensch(false);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.05);
		this.setHeilungsRate(0);
		this.setSterbeRate(5.30);	
		this.setResistenzRate(0); //Schutz durch Aufklärung
	} 
}
