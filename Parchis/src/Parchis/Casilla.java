package Parchis;

public class Casilla {
	private int numCasilla;
	private String tipo;
	private Ficha hueco1 = null;
	private Ficha hueco2 = null;
	
	public Casilla(int pNumCas, String pTipo) {
		this.numCasilla = pNumCas;
		this.tipo = pTipo;
	}
	
	public void setTipo(String pTipo) {
		this.tipo = pTipo;
	}
	
	public int getNumCasilla() {
		return this.numCasilla;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void sacarFicha(Ficha pFicha) { 
		if (this.hueco1 == null ) {
			this.hueco1 = pFicha;
		} else {
			this.hueco2 = pFicha; 
		}
		
		//*if (esta(pFicha)) {
			//System.out.println(true);
		//}*/
	}
	
	public boolean esta (Ficha pFicha) {
		if (pFicha == this.hueco1 || pFicha == this.hueco2) {
			return true;
		}
		return false;
	}
	
	public void eliminarFicha(Ficha pFicha) {
		if (pFicha == hueco1) {
			hueco1 = null;
		} else {
			hueco2 = null;
		}
	}
}
