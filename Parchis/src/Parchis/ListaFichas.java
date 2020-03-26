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
	
	public void esta(ListaCasillas lC) {
		Ficha unaFicha;
		int i = -1;
		Iterator <Ficha> itr = this.getIterador();
		while (itr.hasNext()) {
			i++;
			unaFicha = itr.next();
			unaFicha.esta(i, lC);
		}
	}
	
	public Ficha elegirFicha(int pInd) {
		if (pInd < 0 || pInd > 3) {
			if (pInd != -1) {
				System.out.println("Por favor, ingresa un numero valido");
			}
			Scanner scan = new Scanner(System.in);
			int i = scan.nextInt();
			i = i-1;
			return this.elegirFicha(i);
		} else {
			return this.listaF.get(pInd);
		}
	}
	
	public boolean estanTodasEnCasa(ListaCasillas lC) {
		boolean estan = true;
		Ficha unaFicha;
		Iterator <Ficha> itr = this.getIterador();
		while (itr.hasNext() && estan) {
			unaFicha = itr.next();
			if (unaFicha.getBase() != 0) {
				estan = false;
			}
		}
		return estan;
	}
	
	public boolean hayAlgunaEnCasa(ListaCasillas lC) {
		boolean hay = false;
		Ficha unaFicha;
		Iterator <Ficha> itr = this.getIterador();
		while (itr.hasNext() && !hay) {
			unaFicha = itr.next();
			if (unaFicha.getBase() == 0) {
				hay = true;
			}
		}
		return hay;
	}
	
	public void anadirFicha( Ficha pFicha) {
		this.listaF.add(pFicha);
	}
}
