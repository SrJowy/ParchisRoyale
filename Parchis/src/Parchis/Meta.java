package Parchis;

public class Meta extends Casilla{
	
	private Ficha hueco3 = null;
	private Ficha hueco4 = null;
	
	public Meta(int pNumCas) {
		super(pNumCas);
	}
	
	public String getTipo() {
		return "una Meta";
	}
	
	public boolean estaLlena() {
		if (super.estaLlena() && hueco3!= null && hueco4!= null) {
			return true;
		}
		return false;
	}
	
	public boolean esta(Ficha pFicha) {
		if (this.hueco1 == pFicha || this.hueco2 == pFicha || this.hueco3 == pFicha || this.hueco4 == pFicha) {
			return true;
		}
		return false;
	}
	
	public void ponerFicha(Ficha pFicha, Casilla pCas) {
		
		System.out.println("Has llegado a la meta con una ficha");
		
		if (pCas != null) {
			pCas.eliminarFicha(pFicha);
		}
		
		if (this.hueco1 == null) {
			this.hueco1 = pFicha;
			
		} else if (this.hueco2 == null) {
			this.hueco2 = pFicha;

		} else if (this.hueco3 == null) {
			this.hueco3 = pFicha;
			
		} else {
			this.hueco4 = pFicha;
		}
		
		if (!this.estaLlena()) {
			Tablero.getTablero().contarNum(10);
		}
		
	}
}
