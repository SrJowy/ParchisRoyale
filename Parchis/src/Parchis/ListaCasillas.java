package Parchis;
import java.util.*;

public class ListaCasillas {
	private ArrayList <Casilla> listaC;
	/*private ArrayList <Casilla> pasilloR;
	private ArrayList <Casilla> pasilloA;
	private ArrayList <Casilla> pasilloZ;
	private ArrayList <Casilla> pasilloV;*/
	
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
		
		/*this.pasilloR = new ArrayList <Casilla>();
		this.pasilloA = new ArrayList <Casilla>();
		this.pasilloZ = new ArrayList <Casilla>();
		this.pasilloV = new ArrayList <Casilla>();
		
		for (int id = 0; id < 8; id++) {
			if (id < 7) {
				Casilla cas = new Casilla(id+1, "Pasillo");
				this.pasilloR.add(cas);
				this.pasilloA.add(cas);
				this.pasilloZ.add(cas);
				this.pasilloV.add(cas);
			} else {
				Casilla cas = new Casilla(id+1, "Meta");
				this.pasilloR.add(cas);
				this.pasilloA.add(cas);
				this.pasilloZ.add(cas);
				this.pasilloV.add(cas);
			}
		}*/
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
		int i = casillaInic.getNumCasilla();
		i = i-1;
		Casilla casillaF = casillaInic;
		boolean sucede = false;
		while (pNum!=0) {
			if (i == 16 && pFicha.getColor() == "Azul" && pNum!=0) {
				casillaInic.eliminarFicha(pFicha);
				casillaInic = this.listaC.get(68);
				pFicha.setPasillo(true);
				casillaInic.ponerFicha(pFicha);
				System.out.println(this.buscarCasilla(pFicha).getNumCasilla());
				i = 68;
			} else if (i == 33 && pFicha.getColor() == "Rojo" && pNum!=0) {
				casillaInic.eliminarFicha(pFicha);
				pFicha.setPasillo(true);
				casillaF.eliminarFicha(pFicha);
				casillaInic.ponerFicha(pFicha);
				i = 77;
			} else if (i == 50 && pFicha.getColor() == "Verde" && pNum!=0 ) {
				casillaInic.eliminarFicha(pFicha);
				pFicha.setPasillo(true);
				casillaF.eliminarFicha(pFicha);
				casillaInic.ponerFicha(pFicha);
				i = 85;
			} else if (i == 67 && pFicha.getColor() == "Amarillo" && pNum!=0 ) {
				casillaInic.eliminarFicha(pFicha);
				pFicha.setPasillo(true);
				i = 93;
			} else if (i == 67 && pFicha.getColor() != "Amarillo") {
				i = 0;
			} else {
				i++;
			}
				casillaF = this.listaC.get(i);
				pNum = pNum-1;
		}
			casillaF.ponerFicha(pFicha);
			casillaInic.eliminarFicha(pFicha);
	}
	
}
