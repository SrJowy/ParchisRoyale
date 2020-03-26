package Parchis;
import java.util.*;

public class ListaCasillas {
	private ArrayList <Casilla> listaC;
	
	public ListaCasillas() {
		this.listaC = new ArrayList <Casilla>();
		
		for (int i = 0; i < 68; i++) {

			if (i == 5 || i == 22 || i == 39 || i == 56) {
				Casilla casB = new Casilla(i, "Casa");
				this.listaC.add(casB);
			} else if (i == 12 || i == 17 || i == 29 || i == 34 || i == 46 || i == 51 || i == 63 || i == 68) {
				Casilla casS = new Casilla(i, "Seguro");
				this.listaC.add(casS);
			} else {
				Casilla casN = new Casilla(i, "Normal");
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
		int i = casillaInic.getNumCasilla()+1; //OJO!!!!!!!
		Casilla casillaF = casillaInic;
		while (pNum!=0) {
			casillaF = this.listaC.get(i);
			pNum = pNum-1;
			i++;
		}
		casillaF.sacarFicha(pFicha);
		casillaInic.eliminarFicha(pFicha);
	}
	
}
