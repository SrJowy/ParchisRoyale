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
	
	public void ponerFicha(Ficha pFicha) {//FALTA: Caso de la casilla esta llena
		if (this.estaOcupada()) {
			if (this.tipo == "Normal"){
				if (this.hueco1 != null && this.hueco1.colorDiferente(pFicha)) {
					this.hueco2 = pFicha;
					this.hueco1.setBase(true);
					System.out.println("Has comido la ficha de color " + this.hueco1.getColor());
					this.eliminarFicha(hueco1);
				} else if (this.hueco2 != null && this.hueco2.colorDiferente(pFicha)) {
					this.hueco1 = pFicha;
					this.hueco2.setBase(true);
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
		
		/*if (esta(pFicha)) {
			//System.out.println(true);
		}*/
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
}
