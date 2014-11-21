package de.GameOfLife;

public class SpanischeGrippe extends Krankheiten {
	
	//Spanische Grippe(1918-1920) weltweit
	
	public SpanischeGrippe(){
		this.setTierAufTier(true);
		this.setMenschAufTier(true);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.0278);;
		this.setHeilungsRate(0.9);
		this.setSterbeRate(0.1);	
		this.setResistenzRate(0);
	}

}
