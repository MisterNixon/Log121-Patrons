package exercice_B15;

public class Afficher implements Visitor{

	private StringBuffer sb = new StringBuffer();
	
	@Override
	public void visit(Operante o) {
		sb.append(o.getNombre());
		
	}

	@Override
	public void visit(Operations o) {
		
	sb.append(o.getOper());
		
	}

}
