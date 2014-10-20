package de.GameOfLife;

public abstract class Krankheiten {
	
	protected boolean[] BoolValuesIllness;
	protected Double[] RatesIllness;
	protected boolean menschAufMensch;
	protected boolean tierAufTier;
	protected boolean menschAufTier;
	protected boolean tierAufMensch;
	protected double infektionsRate;
	protected double heilungsRate;
	protected double resistenzRate;
	protected double sterbeRate;
	
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
	
	public abstract void setTierAufMensch(boolean auss);
	
	public abstract boolean getTierAufMensch();
	
	public abstract void setTierAufTier(boolean auss);
	
	public abstract boolean getTierAufTier();
	
	public abstract void setMenschAufMensch(boolean auss);
	
	public abstract boolean getMenschAufMensch();
	
	public abstract void setMenschAufTier(boolean auss);
	
	public abstract boolean getMenschAufTier();
	
	public abstract void setInfektionsRate(double auss);
	
	public abstract double getInfektionsRate();

	public abstract void setHeilungsRate(double auss);
	
	public abstract double getHeilungsRate();
	
	public abstract void setSterbeRate(double auss);
	
	public abstract double getSterbeRate();
	
	public abstract void setResistenzRate(double auss);
	
	public abstract double getResistenzRate();
	
}
