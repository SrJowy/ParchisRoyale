package Parchis;

public class Meta extends Casilla{
	
	private Ficha hueco3 = null;
	private Ficha hueco4 = null;
	
	public Meta(int pNumCas) {
		super(pNumCas);
	}
	
	public String getTipo() {
		return "Meta";
	}
}
