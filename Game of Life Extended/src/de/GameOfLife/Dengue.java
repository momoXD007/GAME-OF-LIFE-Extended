package de.GameOfLife;

public class Dengue extends Krankheiten {

	//Aktuelle Zahlen weltweit

	public Dengue(){		
		this.setTierAufTier(true);
		this.setMenschAufTier(true);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.15);;
		this.setHeilungsRate(0.5);
		this.setSterbeRate(0.5);	
		this.setResistenzRate(0);
	}
}