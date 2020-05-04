package Parchis;

public abstract class Casilla {
	private int numCasilla;
	protected Ficha hueco1 = null;
	protected Ficha hueco2 = null;
	
	public Casilla(int pNumCas) {
		this.numCasilla = pNumCas;
	}
	
	public int getNumCasilla() {
		return this.numCasilla;
	}
	
	public void ponerFicha(Ficha pFicha, Casilla pCas) {
		if (pCas != null) {
			pCas.eliminarFicha(pFicha);
		}
		
		if (this.hueco1 == null) {
			this.hueco1 = pFicha;
		} else {
			this.hueco2 = pFicha; 
			//this.hueco1 = pFicha;
		}
		if (this instanceof Meta) {
			Tablero.getTablero().contarNum(10);
		}
		System.out.println("Ahora tu ficha de color " + pFicha.getColor() + " esta en la casilla " + this.getNumCasilla());
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
	
	public boolean estaOcupada() {
		if (this.hueco1 != null || this.hueco2 != null) {
			return true;
		}
		return false;
	}
	
	public boolean estaLlena() {
		if (this.hueco1 != null && this.hueco2 != null) {
			return true;
		}
		return false;
	}
	
	public void limpiar() {
		this.hueco1 = null;
		this.hueco2 = null;
	}
	
	public abstract String getTipo();
}
