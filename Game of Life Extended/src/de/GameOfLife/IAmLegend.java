package de.GameOfLife;

public class IAmLegend extends Krankheiten {
	
	public IAmLegend() {
		this.setTierAufTier(true);
		this.setMenschAufTier(false);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.8);
		this.setHeilungsRate(0);
		this.setSterbeRate(0);	
		this.setResistenzRate(0);
	}

}
