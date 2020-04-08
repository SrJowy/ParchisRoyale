package Parchis;

public class Pasillo extends Casilla {

	public Pasillo(int pNumCas) {
		super(pNumCas);
	}
	
	public String getTipo() {
		return "Pasillo";
	}
}