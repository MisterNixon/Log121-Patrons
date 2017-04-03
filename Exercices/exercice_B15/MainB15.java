package exercice_B15;

public class MainB15 {

	public static void main(String[] args) {
		Operante o1,o2,o3,o4;
		Operations x1,x2,x3;
		
		o1 = new Operante(3);
		o2 = new Operante(5);
		o3 = new Operante(2);
		o4 = new Operante(3);
		
		x1 = new Operations(Operations.Op.ADD,o1,o2);
		x2 = new Operations(Operations.Op.MUL,x1,o3);
		x3 = new Operations(Operations.Op.SUB,x2,o4);

		
//		System.out.println(x1.getNombre());
//		System.out.println(x2.getNombre());
		System.out.println(x3.getNombre());
	}

}
