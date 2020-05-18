package Parchis;

public class Normal extends Casilla{
	
	public Normal(int pNumCas) {
		super(pNumCas);
	}
	
	public String getTipo() {
		return "una Normal";
	}
	
	public void ponerFicha(Ficha pFicha, Casilla pCas) {
		pCas.eliminarFicha(pFicha);
		if (super.estaOcupada()) {
			if (this.hueco1 != null && this.hueco1.colorDiferente(pFicha)) {
				this.hueco1 = pFicha;
				System.out.println("Has comido la ficha de color " + this.hueco1.getColor());
				Tablero.getTablero().contarNum(20);
				
			} else if (this.hueco2 != null && this.hueco2.colorDiferente(pFicha)) {
				this.hueco2 = pFicha;
				System.out.println("Has comido la ficha de color " + this.hueco1.getColor());
				Tablero.getTablero().contarNum(20);
				
			} else {
				if (this.hueco1 == null) {
					this.hueco1 = pFicha;
				} else {
					this.hueco2 = pFicha;
				}
				System.out.println("Ahora tu ficha de color " + pFicha.getColor() + " esta en la casilla " + this.getNumCasilla());
			}
		} else {
			this.hueco1 = pFicha;
			System.out.println("Ahora tu ficha de color " + pFicha.getColor() + " esta en la casilla " + this.getNumCasilla());
		}
		
	}
}
