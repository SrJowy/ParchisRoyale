package Parchis;
import java.util.*;

public class Dado {
	private static Dado miDado;
	Random al;
	
	private Dado() {
		al = new Random();
	}
	
	public static Dado getDado() {
		if (Dado.miDado == null) {
			Dado.miDado = new Dado();
		}
		return Dado.miDado;
	}
	
	public int lanzarDado(ListaFichas lF, ListaCasillas lC) {
		int n = al.nextInt(6) + 1;
		if (lF.estanTodasFuera(lC) && n == 6) {
			n++;
		}
		System.out.println("--> Has sacado un " + n);
		
		return n;
	}
}
