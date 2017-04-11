package exercice_strategie;

public class CalculateurAmericain implements Calculateur {

	@Override
	public double calculerTaxes(int age, double revenuBrut) {
		if (revenuBrut < 18550.0)
			return revenuBrut * 0.10;
		
		else if (revenuBrut < 75300.0)
			return 1855 + (revenuBrut - 18550.0) * 0.15;
		
		else if (revenuBrut < 151900.0)
			return 10367.5 + (revenuBrut - 75300.0) * 0.25;
		
		else if (revenuBrut < 231450.0)
			return 29517.5 + (revenuBrut - 151900.0) * 0.28;
		
		else if (revenuBrut < 413350.0)
			return 51791.5 + (revenuBrut - 231450.0) * 0.33;
		
		else if (revenuBrut < 466950.0)
			return 111818.5 + (revenuBrut - 413350.0) * 0.35;
		
		else
			// cas non documente
			return 111818.5 + (466950.0 - 413350.0) * 0.35;
	}
}
