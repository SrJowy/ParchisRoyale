package Parchis;
import java.util.*;

public class ListaCasillas {
	private ArrayList <Casilla> listaC;
	
	public ListaCasillas() {
		this.listaC = new ArrayList <Casilla>();
		
		for (int i = 0; i < 100; i++) { //Las casillas i son una más para que cuadre

			if (i == 4 || i == 21 || i == 38 || i == 55) {
				Casilla casB = new Casilla(i+1, "Casa");
				this.listaC.add(casB);
			} else if (i == 11 || i == 16 || i == 28 || i == 33 || i == 45 || i == 50 || i == 62 || i == 67) {
				Casilla casS = new Casilla(i+1, "Seguro");
				this.listaC.add(casS);
			} else if (i < 68) {
				Casilla casN = new Casilla(i+1, "Normal");
				this.listaC.add(casN);
			} else if (i == 75 || i == 83 || i == 91 || i == 99) {
				Casilla casM = new Casilla(i+1, "Meta");
				this.listaC.add(casM);
			} else {
				Casilla casP = new Casilla(i+1, "Pasillo");
				this.listaC.add(casP);
			}
			// (indice) CasInicPas == "Azul" = 68, "Rojo" = 76, "Verde" = 84, "Amarillo" = 92
			// la casilla seria una mas
		}
	}
	
	public Casilla getCas(int pNum) {
		if (pNum == 0) {
			return null;
		} else {
			pNum--;
			return this.listaC.get(pNum);
		}
	}
	
	private Iterator <Casilla> getIterador(){
		return this.listaC.iterator();
	}
	
	public String getTipo(int i) {
		return this.listaC.get(i).getTipo();
	}
	
	public void sacarFicha(Ficha pFicha, int pCas) {
		pCas = pCas-1;
		Casilla pCasilla = this.listaC.get(pCas);
		pCasilla.ponerFicha(pFicha);
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
	
	public void moverFicha(int pNum, Ficha pFicha) {
		Casilla casillaInic = this.buscarCasilla(pFicha);
		int i = casillaInic.getNumCasilla(); //Tomamos el valor real de la casilla
		i = i-1; 							 //Restamos para obtener su id dentro del array
		Casilla casillaF = casillaInic;
		while (pNum!=0) {
			if (i == 16 && pFicha.getColor() == "Azul") {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(68);
				casillaInic.ponerFicha(pFicha);
				i = 68;
			} else if (i == 33 && pFicha.getColor() == "Rojo") {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(76);
				casillaInic.ponerFicha(pFicha);
				i = 76;
			} else if (i == 50 && pFicha.getColor() == "Verde") {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(84);
				casillaInic.ponerFicha(pFicha);
				i = 84;
			} else if (i == 67 && pFicha.getColor() == "Amarillo") {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(92);
				casillaInic.ponerFicha(pFicha);
				i = 92;
			} else if (i == 67) {
				i = 0;
			} else {
				i++;
			}
				casillaF = this.listaC.get(i);
				pNum = pNum-1;
		}
		casillaF.ponerFicha(pFicha);
		casillaInic.eliminarFicha(pFicha);
		if (i == 75 && pFicha.getColor() == "Azul") {
			pFicha.setMeta(true);
		} else if (i == 83 && pFicha.getColor() == "Rojo") {
			pFicha.setMeta(true);
		} else if (i == 91 && pFicha.getColor() == "Verde") {
			pFicha.setMeta(true);
		} else if (i == 99 && pFicha.getColor() == "Amarillo") {
			pFicha.setMeta(true);
		}
		i++;
		pFicha.setCasAct(i);
	}
	
}
