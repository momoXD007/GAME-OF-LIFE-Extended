package de.GameOfLife;

public abstract class Krankheiten {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5046215450772680923L;

	protected boolean[] BoolValuesIllness;
	protected Double[] RatesIllness;
	private boolean menschAufMensch;
	private boolean tierAufTier;
	private boolean menschAufTier;
	private boolean tierAufMensch;
	private double infektionsRate;
	private double heilungsRate;
	private double resistenzRate;
	private double sterbeRate;
	
	public Krankheiten() {
		BoolValuesIllness[0] = tierAufMensch;
		BoolValuesIllness[1] = menschAufTier;
		BoolValuesIllness[2] = menschAufMensch;
		BoolValuesIllness[3] = tierAufTier;
		
		RatesIllness[0] = sterbeRate;
		RatesIllness[1] = resistenzRate;
		RatesIllness[2] = heilungsRate;
		RatesIllness[3] = infektionsRate;
		
	}
	
	public void setTierAufMensch(boolean auss){
		tierAufMensch = auss;
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
	
	public boolean MenschTierAufMensch(){
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
