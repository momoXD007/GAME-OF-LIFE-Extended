package de.GameOfLife;

public class Pest extends Krankheiten {
	
	Pest virusPest = new Pest();
	
	public Pest() {
		super();
		virusPest.setTierAufTier(true);
		virusPest.setMenschAufTier(true);
		virusPest.setTierAufMensch(true);	
		virusPest.setMenschAufMensch(true);
		
		virusPest.setInfektionsRate(0);;
		virusPest.setHeilungsRate(0);
		virusPest.setSterbeRate(0);	
		virusPest.setResistenzRate(0);
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
