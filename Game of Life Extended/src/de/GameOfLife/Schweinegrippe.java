package de.GameOfLife;

public class Schweinegrippe extends Krankheiten {
	
	Schweinegrippe virusSchweinegrippe = new Schweinegrippe();

	public Schweinegrippe(){
		super();
		
		virusSchweinegrippe.setTierAufTier(true);
		virusSchweinegrippe.setMenschAufTier(true);
		virusSchweinegrippe.setTierAufMensch(true);	
		virusSchweinegrippe.setMenschAufMensch(true);
		
		virusSchweinegrippe.setInfektionsRate(0);;
		virusSchweinegrippe.setHeilungsRate(0);
		virusSchweinegrippe.setSterbeRate(0);	
		virusSchweinegrippe.setResistenzRate(0);
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
