package de.GameOfLife;

public class Schweinegrippe extends Krankheiten {
	
	//Pandemie H1N1 2009/10
	
	public Schweinegrippe(){
		this.setTierAufTier(true);
		this.setMenschAufTier(true);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.33);
		this.setHeilungsRate(99.97);
		this.setSterbeRate(0.03);	
		this.setResistenzRate(0); 
		}

}
