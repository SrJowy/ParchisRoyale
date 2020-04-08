package Parchis;

public abstract class Casilla {
	private int numCasilla;
	private Ficha hueco1 = null;
	private Ficha hueco2 = null;
	
	public Casilla(int pNumCas) {
		this.numCasilla = pNumCas;
	}
	
	public int getNumCasilla() {
		return this.numCasilla;
	}
	
	public void ponerFicha(Ficha pFicha) {
		if (this.estaOcupada()) {
			if (this instanceof Normal){
				if (this.hueco1 != null && this.hueco1.colorDiferente(pFicha)) {
					this.hueco2 = pFicha;
					System.out.println("Has comido la ficha de color " + this.hueco1.getColor());
					this.eliminarFicha(hueco1);
				} else if (this.hueco2 != null && this.hueco2.colorDiferente(pFicha)) {
					this.hueco1 = pFicha;
					System.out.println("Has comido la ficha de color " + this.hueco1.getColor());
					this.eliminarFicha(hueco2);		
				} else {
					if (this.hueco1 == null) {
						this.hueco1 = pFicha;
					} else {
						this.hueco2 = pFicha;
					}
				}
			} else {
				if (this.hueco1 == null) {
					this.hueco1 = pFicha;
				} else {
					this.hueco2 = pFicha;
				}
			}
		} else {
			if (this.hueco1 == null) {
				this.hueco1 = pFicha;
			} else {
				this.hueco2 = pFicha; 
			}
		}
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
	
	public abstract String getTipo();
}
