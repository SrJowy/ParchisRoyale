package Parchis;
//import java.util.*;

public class Ficha {
	private String color;
	private boolean base;
	private boolean pasillo;
	private boolean meta;
	private int casAct;
	
	public Ficha(String pColor) {
		this.color = pColor;
		this.base = true;
		this.pasillo = false;
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
	
	public void setPasillo(boolean b) {
		this.pasillo = b;
	}
	
	public boolean getPasillo() {
		return this.pasillo;
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
	
	public int getCasilla(ListaCasillas lC) {
		Casilla c = lC.buscarCasilla(this);
		return c.getNumCasilla();
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
	
	public void moverFicha(int pNum, ListaCasillas lC, ListaFichas lF) { //sacar ficha esta hecho (faltan casos criticos)
		if (this.comprobarCasLlena(lC, pNum)) {
			System.out.println("Esa ficha no se puede elegir, elige otra.");
			lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
		} else {
			if (lF.hayAlgunaEnCasa(lC)) {
				if (this.base) {
					if (pNum == 5) {
						this.sacarFicha(lC);
						System.out.println("                                                                           ");
						System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
						this.base = false;
					} else {
						System.out.println("Esa ficha no se puede elegir, elige otra.");
						lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
					}
				} else if (!this.base && pNum == 5) {
					System.out.println("Esa ficha no se puede elegir, elige otra.");
					lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
				} else {
					lC.moverFicha(pNum, this);
					System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
				}
			}
		}
	}
	
	public void sacarFicha(ListaCasillas lC) {
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
	
	public boolean comprobarCasLlena(ListaCasillas lC, int pNum) {
		//Hay que tener en cuenta a la hora de entrar a los pasillos(Ya deberia estar)
		int casDest = 0;
		if (this.casAct != 0) {
			while (pNum > 0) {
				if (this.casAct == 68 && this.color!="Amarillo") {
					casDest = 1;
				} else if(this.casAct == 17 && this.color == "Azul") {
					casDest = 69;
				} else if (this.casAct == 34 && this.color == "Rojo" ) {
					casDest = 77;
				} else if (this.casAct == 51 && this.color == "Verde") {
					casDest = 85;
				} else if (this.casAct == 68 && this.color == "Amarillo") {
					casDest = 93;
				} else {
					casDest = this.casAct+1;
				}
				pNum = pNum - 1;
			}
		}
		if (lC.getCas(casDest).estaLlena()) {
			return true;
		} else {
			return false;
		}
	}
	
}
