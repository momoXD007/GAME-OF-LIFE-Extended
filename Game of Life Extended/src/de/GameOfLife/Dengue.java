package de.GameOfLife;

public class Dengue extends Krankheiten {

	Dengue virusDengue = new Dengue();

	public Dengue(){
		super();
		
		virusDengue.setTierAufTier(true);
		virusDengue.setMenschAufTier(true);
		virusDengue.setTierAufMensch(true);	
		virusDengue.setMenschAufMensch(true);
		
		virusDengue.setInfektionsRate(0);;
		virusDengue.setHeilungsRate(0);
		virusDengue.setSterbeRate(0);	
		virusDengue.setResistenzRate(0);
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
