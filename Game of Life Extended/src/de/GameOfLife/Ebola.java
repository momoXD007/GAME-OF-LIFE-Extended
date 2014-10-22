package de.GameOfLife;

public class Ebola extends Krankheiten {
	

	public Ebola() {
		this.setTierAufTier(true);
		this.setMenschAufTier(false);
		this.setTierAufMensch(true);	
		this.setMenschAufMensch(true);
		
		this.setInfektionsRate(0.1);
		this.setHeilungsRate(0.3);
		this.setSterbeRate(0.7);	
		this.setResistenzRate(0);
	}
	
	public void setTierAufMensch(boolean TaM){
		tierAufMensch = TaM;
	}
	
	public boolean getTierAufMensch(){
		return tierAufMensch;
	}
	
	public void setTierAufTier(boolean auss){
		tierAufTier = auss;
	}
	
	public boolean getTierAufTier(){
		return tierAufTier;
	}
	
	public void setMenschAufMensch(boolean auss){
		menschAufMensch = auss;
	}
	
	public boolean getMenschAufMensch(){
		return menschAufMensch;
	}
	
	public void setMenschAufTier(boolean auss){
		menschAufTier = auss;
	}
	
	public boolean getMenschAufTier(){
		return menschAufTier;
	}
	
	public void setInfektionsRate(double auss){
		infektionsRate = auss;
	}
	
	public double getInfektionsRate(){
		return infektionsRate;
	}

	public void setHeilungsRate(double auss){
		heilungsRate = auss;
	}
	
	public double getHeilungsRate(){
		return heilungsRate;
	}	
	
	public void setSterbeRate(double auss){
		sterbeRate = auss;
	}
	
	public double getSterbeRate(){
		return sterbeRate;
	}
	
	public void setResistenzRate(double auss){
		resistenzRate = auss;
	}
	
	public double getResistenzRate(){
		return resistenzRate;
	}
	
	
}
