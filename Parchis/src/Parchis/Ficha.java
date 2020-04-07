package Parchis;
//import java.util.*;

public class Ficha {
	private String color;
	private boolean base;
	private boolean meta;
	private int casAct;
	
	public Ficha(String pColor) {
		this.color = pColor;
		this.base = true;
		this.meta = false;
		this.casAct = 0;
	}
	
	public void setCasAct(int pCas) {
		this.casAct = pCas;
	}
	
	public int getCasAct() {
		return this.casAct;
	}
	
	public void setMeta(boolean m) {
		this.meta = m;
	}
	
	public boolean getMeta() {
		return this.meta;
	}
	
	public boolean getBase() {
		return this.base;
	}
	
	public void setBase(boolean b) {
		this.base = b;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void esta(int i, ListaCasillas lC) {
		
		i = i+1;
		if (this.base == true) {
			System.out.println("La ficha numero " + i + " esta en la base");
		} else {
			Casilla pCas = lC.buscarCasilla(this);
			System.out.println("La ficha numero " + i + " esta en la casilla " + pCas.getNumCasilla() + " que es un/a " + pCas.getTipo());
		}
	}
	
	public void moverFicha(int pNum, ListaCasillas lC, ListaFichas lF) {
			if (lF.hayAlgunaEnCasa(lC)) {
				if (this.base) {
					if (pNum == 5 && !this.casSalidaLlena(lC)) { //sacar ficha a menos que la casilla de salida este llena
						this.sacarFicha(lC);
						System.out.println("                                                                           ");
						System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
						this.base = false;
					} else {
						System.out.println("Esa ficha no se puede elegir, elige otra."); 
						lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
					}
				} else if (pNum == 5 && !this.casSalidaLlena(lC)) { //no se puede mover la ficha porque hay hueco en la casilla de salida
					System.out.println("Esa ficha no se puede elegir, elige otra.");
					lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
					
				} else if (!this.comprobarCasLlena(lC, pNum) && this.casSalidaLlena(lC) && pNum == 5){ //la casilla de destino esta vacia y se puede mover
					lC.moverFicha(pNum, this);														   //con 5 puesto que la casilla de salida esta llena
					System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
					
				} else if (!this.comprobarCasLlena(lC, pNum)) {
					lC.moverFicha(pNum, this);
					System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
					//se puede mover puesto que la casilla de destino no esta llena
				} else {
					System.out.println("Esa ficha no se puede elegir, elige otra.");
					lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
				}
			} else if (!this.comprobarCasLlena(lC, pNum)) {
				lC.moverFicha(pNum, this);
				System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
			} else {
				System.out.println("Esa ficha no se puede elegir, elige otra.");
				lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
			}
		}
	
	private void sacarFicha(ListaCasillas lC) {
		if (this.color == "Azul") {
			lC.sacarFicha(this, 22);
			this.setCasAct(22);
		} else if (this.color == "Amarillo") {
			lC.sacarFicha(this, 5);
			this.setCasAct(5);
		} else if (this.color == "Rojo") {
			lC.sacarFicha(this, 39);
			this.setCasAct(39);
		} else {
			lC.sacarFicha(this, 56);
			this.setCasAct(56);
		}
	}
	
	public boolean colorDiferente(Ficha pFicha) {
		if (this.color!=pFicha.color) {
			return true;
		}
		return false;
	}
	
	private boolean comprobarCasLlena(ListaCasillas lC, int pNum) {
		int casDest = this.casAct;
			while (pNum > 0) {
				if (casDest == 68 && this.color!="Amarillo") {
					casDest = 1;
				} else if(casDest == 17 && this.color == "Azul") {
					casDest = 69;
				} else if (casDest + pNum > 77 && this.color == "Azul") {
					return false;
				} else if (casDest == 34 && this.color == "Rojo" ) {
					casDest = 77;
				} else if (casDest + pNum > 85 && this.color == "Rojo") {
					return false;
				} else if (casDest == 51 && this.color == "Verde") {
					casDest = 85;
				} else if (casDest + pNum > 93 && this.color == "Verde") {
					return false;
				} else if (casDest == 68 && this.color == "Amarillo") {
					casDest = 93;
				} else if (casDest + pNum > 101 && this.color == "Amarillo") {
					return false;
				} else {
					casDest++;
				}
				pNum = pNum - 1;
			}
			if (lC.getCas(casDest).estaLlena()) {
				return true;
			} else {
				return false;
			}
	}
	
	private boolean casSalidaLlena(ListaCasillas lC) {
		int casDest;
		if (this.color == "Azul") {
			casDest = 22;
		} else if (this.color == "Verde") {
			casDest = 56;
		} else if (this.color == "Amarillo") {
			casDest = 5;
		} else {
			casDest = 39;
		}
		if (lC.getCas(casDest).estaLlena()) {
			return true;
		} else {
			return false;
		}
	}
	
}
