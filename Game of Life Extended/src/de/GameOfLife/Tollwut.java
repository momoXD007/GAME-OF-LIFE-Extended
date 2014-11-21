package de.GameOfLife;

public class Tollwut extends Krankheiten{

	//Tollwut heute weltweit

	public Tollwut() {
		this.setTierAufTier(true);
		this.setMenschAufTier(false); //kommt auch nicht vor(!)
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(false); //kommt nicht vor(!)
		
		this.setInfektionsRate(0.0014);;
		this.setHeilungsRate(0);
		this.setSterbeRate(0.7857 * (Math.pow(10, -5)));	
		this.setResistenzRate(0);
	}
	
}
