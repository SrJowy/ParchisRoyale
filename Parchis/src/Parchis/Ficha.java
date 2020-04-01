package Parchis;
import java.util.*;

public class Ficha {
	private String color;
	private boolean base;
	private boolean pasillo;
	private boolean meta;
	
	public Ficha(String pColor) {
		this.color = pColor;
		this.base = true;
		this.pasillo = false;
		this.meta = false;
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
	
	public void esta(int i, ListaCasillas lC) { //arreglar esto para que no haga falta el atributo casilla
		
		i = i+1;
		if (this.base == true) {
			System.out.println("La ficha numero " + i + " esta en la base");
		} else {
			Casilla pCas = lC.buscarCasilla(this);
			System.out.println("La ficha numero " + i + " esta en la casilla " + pCas.getNumCasilla() + " que es un/a " + pCas.getTipo());
		}
	}
	
	public void moverFicha(int pNum, ListaCasillas lC, ListaFichas lF) { //sacar ficha esta hecho (faltan casos criticos)
		//System.out.println("xdddddd");
		if (lF.hayAlgunaEnCasa(lC)) {
			if (this.base == true) {
				if (pNum == 5) {
					this.sacarFicha(lC);
					System.out.println("                                                                           ");
					System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
					this.base = false;
				} else {
					System.out.println("Esa ficha no se puede elegir, elige otra.");
					lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
				}
			} else if (this.base == false && pNum == 5) {
				System.out.println("Esa ficha no se puede elegir, elige otra.");
				lF.elegirFicha(-1).moverFicha(pNum, lC, lF);
			} else {
				lC.moverFicha(pNum, this);
				System.out.println("Ahora tu ficha esta en la casilla " + lC.buscarCasilla(this).getNumCasilla());
			}
		}
	}
	
	public void sacarFicha(ListaCasillas lC) {
		if (this.color == "Azul") {
			lC.sacarFicha(this, 22);
		} else if (this.color == "Amarillo") {
			lC.sacarFicha(this, 5);
		} else if (this.color == "Rojo") {
			lC.sacarFicha(this, 39);
		} else {
			lC.sacarFicha(this, 56);
		}
	}
	
	public boolean colorDiferente(Ficha pFicha) {
		if (this.color!=pFicha.color) {
			return true;
		}
		return false;
	}
	
}
