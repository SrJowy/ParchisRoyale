package Parchis;
import java.util.*;

public class ListaFichas {
	private ArrayList <Ficha> listaF;
	
	public ListaFichas() {
		this.listaF = new ArrayList <Ficha>();
	}
	
	private Iterator <Ficha> getIterador(){
		return this.listaF.iterator();
	}
	
	public void esta() {
		Ficha unaFicha;
		int i = -1;
		Iterator <Ficha> itr = this.getIterador();
		while (itr.hasNext()) {
			i++;
			unaFicha = itr.next();
			unaFicha.esta(i);
		}
	}
	
	public Ficha elegirFicha(int pInd) {
		pInd--;
		return this.listaF.get(pInd);
	}
	
	public boolean estanTodasEnCasa() {
		boolean estan = true;
		Ficha unaFicha;
		Iterator <Ficha> itr = this.getIterador();
		while (itr.hasNext() && estan) {
			unaFicha = itr.next();
			if (Tablero.getTablero().buscarCasilla(unaFicha) != null) {
				estan = false;
			}
		}
		return estan;
	}
	
	public boolean hayAlgunaEnCasa() {
		boolean hay = false;
		Ficha unaFicha;
		Iterator <Ficha> itr = this.getIterador();
		while (itr.hasNext() && !hay) {
			unaFicha = itr.next();
			if (Tablero.getTablero().buscarCasilla(unaFicha) == null) {
				hay = true;
			}
		}
		return hay;
	}
	
	public boolean estanTodasFuera() {
		boolean estan = true;
		Ficha unaFicha;
		Iterator <Ficha> itr = this.getIterador();
		while (itr.hasNext() && estan) {
			unaFicha = itr.next();
			if (Tablero.getTablero().buscarCasilla(unaFicha) == null) {
				estan = false;
			}
		}
		return estan;
	}
	
	public void anadirFicha(Ficha pFicha) {
		this.listaF.add(pFicha);
	}
	
	public boolean comprobarWin() {
		Iterator <Ficha> itr = this.getIterador();
		Ficha unaFicha;
		while (itr.hasNext()) {
			unaFicha = itr.next();
			Casilla cas = Tablero.getTablero().buscarCasilla(unaFicha);
			if (cas == null) {
				return false;
			} else {
				if (unaFicha.getColor() == "Azul" && cas.getNumCasilla() != 76) {
					return false;
				} else if (unaFicha.getColor() == "Rojo" && cas.getNumCasilla() != 84) {
					return false;
				} else if (unaFicha.getColor() == "Verde" && cas.getNumCasilla() != 92) {
					return false;
				} else if (unaFicha.getColor() == "Verde" && cas.getNumCasilla() != 92) {
					return false;
				}
			}
		}
		return true;
	}
}
