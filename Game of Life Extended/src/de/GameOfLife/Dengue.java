package de.GameOfLife;

public class Dengue extends Krankheiten {


	public Dengue(){
		
		this.setTierAufTier(true);
		this.setMenschAufTier(true);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0);;
		this.setHeilungsRate(0);
		this.setSterbeRate(0);	
		this.setResistenzRate(0);
	}
}