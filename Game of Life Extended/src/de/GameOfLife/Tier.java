package de.GameOfLife;

public class Tier extends Spezie {
	private boolean infizierbarVonMensch;
	private boolean infizierbarVonTier;

	public Tier(boolean lGesund, boolean lResistent, int lyPos, int lxPos,
			Spielraster lRaster,boolean lInfVonMensch,boolean lInfVonTier) {
		super(lGesund, lResistent, lyPos, lxPos, lRaster);
		infizierbarVonMensch=lInfVonMensch;
		infizierbarVonTier=lInfVonTier;
	}

/**
 * 
 * @param rate
 * @param istMensch true falls Infektion von einem Menschen ausgeht
 * @throws IllegalArgumentException
 */
	//@Override
 protected void werdeInfiziert(double rate, boolean istMensch ) throws IllegalArgumentException{
	if(istMensch){
		if(infizierbarVonMensch){
			super.werdeInfiziert(rate);
		}
	}else{
		if(infizierbarVonTier){
			super.werdeInfiziert(rate);
		}
	}
}
	
	
}

