package Parchis;
import java.util.*;

public class ListaCasillas {
	private ArrayList <Casilla> listaC;
	
	public ListaCasillas() {
		this.listaC = new ArrayList <Casilla>();
		
		for (int i = 0; i < 100; i++) { //Las casillas i son una más para que cuadre

			if (i == 4 || i == 21 || i == 38 || i == 55) {
				Casilla casB = new Casa(i+1);
				this.listaC.add(casB);
			} else if (i == 11 || i == 16 || i == 28 || i == 33 || i == 45 || i == 50 || i == 62 || i == 67) {
				Casilla casS = new Seguro(i+1);
				this.listaC.add(casS);
			} else if (i < 68) {
				Casilla casN = new Normal(i+1);
				this.listaC.add(casN);
			} else if (i == 75 || i == 83 || i == 91 || i == 99) {
				Casilla casM = new Meta(i+1);
				this.listaC.add(casM);
			} else {
				Casilla casP = new Pasillo(i+1);
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
		pCasilla.ponerFicha(pFicha, null);
	}
	
	public Casilla buscarCasilla(Ficha pFicha) {
		Casilla unaCasilla;
		Iterator <Casilla> itr = this.getIterador();
		while (itr.hasNext()) {
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
				casillaInic.ponerFicha(pFicha,casillaInic);
				i = 68;
			} else if (i == 33 && pFicha.getColor() == "Rojo") {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(76);
				casillaInic.ponerFicha(pFicha,casillaInic);
				i = 76;
			} else if (i == 50 && pFicha.getColor() == "Verde") {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(84);
				casillaInic.ponerFicha(pFicha,casillaInic);
				i = 84;
			} else if (i == 67 && pFicha.getColor() == "Amarillo") {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(92);
				casillaInic.ponerFicha(pFicha,casillaInic);
				i = 92;
			} else if (i == 67) {
				i = 0;
			} else {
				i++;
			}
				casillaF = this.listaC.get(i);
				pNum = pNum-1;
		}
		casillaF.ponerFicha(pFicha, casillaInic);
		i++;
	}
	
	public boolean comprobarCasLlena(int pNum, Ficha pFicha) {
		int casDest = this.buscarCasilla(pFicha).getNumCasilla();
			while (pNum > 0) {
				if (casDest == 68 && pFicha.getColor() == "Amarillo") {
					casDest = 1;
				} else if(casDest == 17 && pFicha.getColor() == "Azul") {
					casDest = 69;
				} else if (casDest + pNum > 77 && pFicha.getColor() == "Azul") {
					return false;
				} else if (casDest == 34 && pFicha.getColor() == "Rojo" ) {
					casDest = 77;
				} else if (casDest + pNum > 85 && pFicha.getColor() == "Rojo") {
					return false;
				} else if (casDest == 51 && pFicha.getColor() == "Verde") {
					casDest = 85;
				} else if (casDest + pNum > 93 && pFicha.getColor() == "Verde") {
					return false;
				} else if (casDest == 68 && pFicha.getColor() == "Amarillo") {
					casDest = 93;
				} else if (casDest + pNum > 101 && pFicha.getColor() == "Amarillo") {
					return false;
				} else {
					casDest++;
				}
				pNum = pNum - 1;
			}
			if (this.getCas(casDest).estaLlena()) {
				return true;
			} else {
				return false;
			}
	}
	
	public boolean casSalidaLlena(Ficha pFicha) {
		int casDest;
		if (pFicha.getColor() == "Azul") {
			casDest = 22;
		} else if (pFicha.getColor() == "Verde") {
			casDest = 56;
		} else if (pFicha.getColor() == "Amarillo") {
			casDest = 5;
		} else {
			casDest = 39;
		}
		if (this.getCas(casDest).estaLlena()) {
			return true;
		} else {
			return false;
		}
	}
	
}
