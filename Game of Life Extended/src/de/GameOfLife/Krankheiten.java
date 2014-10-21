package de.GameOfLife;

public class Krankheiten {
	
	protected boolean[] BoolValuesIllness = new boolean [4];
	protected double[] RatesIllness = new double [4];
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

	public boolean[] getBoolValuesIllness() {
		return BoolValuesIllness;
	}

	public double[] getRatesIllness() {
		return RatesIllness;
	}

	public boolean isMenschAufMensch() {
		return menschAufMensch;
	}

	public boolean isTierAufTier() {
		return tierAufTier;
	}

	public boolean isMenschAufTier() {
		return menschAufTier;
	}

	public boolean isTierAufMensch() {
		return tierAufMensch;
	}

	public double getInfektionsRate() {
		return infektionsRate;
	}

	public double getHeilungsRate() {
		return heilungsRate;
	}

	public double getResistenzRate() {
		return resistenzRate;
	}

	public double getSterbeRate() {
		return sterbeRate;
	}

	public void setBoolValuesIllness(boolean[] boolValuesIllness) {
		BoolValuesIllness = boolValuesIllness;
	}

	public void setRatesIllness(double[] ratesIllness) {
		RatesIllness = ratesIllness;
	}

	public void setMenschAufMensch(boolean menschAufMensch) {
		this.menschAufMensch = menschAufMensch;
	}

	public void setTierAufTier(boolean tierAufTier) {
		this.tierAufTier = tierAufTier;
	}

	public void setMenschAufTier(boolean menschAufTier) {
		this.menschAufTier = menschAufTier;
	}

	public void setTierAufMensch(boolean tierAufMensch) {
		this.tierAufMensch = tierAufMensch;
	}

	public void setInfektionsRate(double infektionsRate) {
		this.infektionsRate = infektionsRate;
	}

	public void setHeilungsRate(double heilungsRate) {
		this.heilungsRate = heilungsRate;
	}

	public void setResistenzRate(double resistenzRate) {
		this.resistenzRate = resistenzRate;
	}

	public void setSterbeRate(double sterbeRate) {
		this.sterbeRate = sterbeRate;
	}
	
	
}
