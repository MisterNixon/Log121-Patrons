package exercice_strategie;

public class CalculateurCanadien implements Calculateur {

	@Override
	public double calculerTaxes(int age, double revenuBrut) {
		if (revenuBrut < 44701.0)
			return revenuBrut * 0.15;
		
		else if (revenuBrut < 89401.0)
			return 6705.0 + (revenuBrut - 44701.0) * 0.22;
		
		else if (revenuBrut < 138586.0)
			return 16539.0 + (revenuBrut - 89401.0) * 0.26;
		
		else
			return 29327.0 + (revenuBrut - 138586.0) * 0.29;
	}
}
