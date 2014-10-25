package de.GameOfLife;

public class Cholera extends Krankheiten {
	
	//Choleraepedemie (Hamburg 1982)

	public Cholera() {
		this.setTierAufTier(false);
		this.setMenschAufTier(false);
		this.setTierAufMensch(false);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.0265);;
		this.setHeilungsRate(0.4925);
		this.setSterbeRate(0.5075);	
		this.setResistenzRate(0);
	}

}
