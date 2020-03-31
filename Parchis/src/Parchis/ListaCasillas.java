package Parchis;
import java.util.*;

public class ListaCasillas {
	private ArrayList <Casilla> listaC;
	
	public ListaCasillas() {
		this.listaC = new ArrayList <Casilla>();
		
		for (int i = 0; i < 68; i++) { //Las casillas i son una más para que cuadre

			if (i == 4 || i == 21 || i == 38 || i == 55) {
				Casilla casB = new Casilla(i+1, "Casa");
				this.listaC.add(casB);
			} else if (i == 11 || i == 16 || i == 28 || i == 33 || i == 45 || i == 50 || i == 62 || i == 67) {
				Casilla casS = new Casilla(i+1, "Seguro");
				this.listaC.add(casS);
			} else {
				Casilla casN = new Casilla(i+1, "Normal");
				this.listaC.add(casN);
			}
		}
	}
	
	public Iterator <Casilla> getIterador(){
		return this.listaC.iterator();
	}
	
	public String getTipo(int i) {
		return this.listaC.get(i).getTipo();
	}
	
	public void sacarFicha(Ficha pFicha, int pCas) {
		pCas = pCas-1;
		Casilla pCasilla = this.listaC.get(pCas);
		pCasilla.sacarFicha(pFicha);
	}
	
	public Casilla buscarCasilla(Ficha pFicha) {
		boolean enc = false;
		Casilla unaCasilla;
		Iterator <Casilla> itr = this.getIterador();
		while (itr.hasNext() && !enc) {
			unaCasilla = itr.next();
			if (unaCasilla.esta(pFicha)) {
				return unaCasilla;
			}
		}
		return null;
	}
	
	public void moverFicha(int pNum, Ficha pFicha) { //Caso de que la casilla sea la 68
		Casilla casillaInic = this.buscarCasilla(pFicha);
		int i = casillaInic.getNumCasilla();
		Casilla casillaF = casillaInic;
		while (pNum!=0) {
			casillaF = this.listaC.get(i);
			pNum = pNum-1;
			if (i == 67) {
				i = 0;
			} else {
				i++;
			}
		}
		casillaF.sacarFicha(pFicha);
		casillaInic.eliminarFicha(pFicha);
	}
	
}
