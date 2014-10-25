package de.GameOfLife;

public class CholeraAfrika extends Krankheiten {
	
	//Choleraepedemie (Simbabwe 2008/2009)
	
	public CholeraAfrika() {
		this.setTierAufTier(false);
		this.setMenschAufTier(false);
		this.setTierAufMensch(false);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.0077);;
		this.setHeilungsRate(0.4925);
		this.setSterbeRate(0.053);	
		this.setResistenzRate(0);
	}
	
}
