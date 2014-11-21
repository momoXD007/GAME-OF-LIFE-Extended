package de.GameOfLife;

public class Aids extends Krankheiten {
	
	//Aktuelle zahlen weltweit
	public Aids() {
		this.setTierAufTier(true);
		this.setMenschAufTier(false);
		this.setTierAufMensch(false);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.0005);
		this.setHeilungsRate(0);
		this.setSterbeRate(0.0053);	
		this.setResistenzRate(0);
	} 
}
