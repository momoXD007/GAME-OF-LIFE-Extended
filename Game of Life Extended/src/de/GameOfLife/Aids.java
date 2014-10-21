package de.GameOfLife;

public class Aids extends Krankheiten {
	
	Aids virusAids = new Aids();

	public Aids() {
		super();
		virusAids.setTierAufTier(true);
		virusAids.setMenschAufTier(true);
		virusAids.setTierAufMensch(true);	
		virusAids.setMenschAufMensch(true);
		
		virusAids.setInfektionsRate(0);;
		virusAids.setHeilungsRate(0);
		virusAids.setSterbeRate(0);	
		virusAids.setResistenzRate(0);
	}
	
	@Override
	public void setTierAufMensch(boolean auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getTierAufMensch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTierAufTier(boolean auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getTierAufTier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMenschAufMensch(boolean auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getMenschAufMensch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMenschAufTier(boolean auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getMenschAufTier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInfektionsRate(double auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getInfektionsRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeilungsRate(double auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHeilungsRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSterbeRate(double auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSterbeRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setResistenzRate(double auss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getResistenzRate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
