package de.GameOfLife;

public class Cholera extends Krankheiten {
	
	//Choleraepedemie (Hamburg 1982)
	Cholera virusCholera = new Cholera();

	public Cholera() {
		super();
		virusCholera.setTierAufTier(false);
		virusCholera.setMenschAufTier(false);
		virusCholera.setTierAufMensch(false);	
		virusCholera.setMenschAufMensch(true);
		
		virusCholera.setInfektionsRate(0.0265);;
		virusCholera.setHeilungsRate(0.4925);
		virusCholera.setSterbeRate(0.5075);	
		virusCholera.setResistenzRate(0);
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
