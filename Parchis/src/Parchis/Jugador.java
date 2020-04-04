package Parchis;
import java.util.*;

public class Jugador {
	private ListaFichas lista;
	private String color;
	private int id;
	
	public Jugador(String pColor, int pId) {
		this.lista = new ListaFichas();
		this.color = pColor;
		this.id = pId;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Ficha elegirFicha(int pRes, ListaCasillas lC) {
		System.out.println("Tus fichas estan en:");
		this.lista.esta(lC);
		if (this.lista.estanTodasEnCasa(lC) && pRes !=5) {
			System.out.println("                                                 ");
			System.out.println("No puedes mover tu ficha, porque no puedes sacar");
			return null;
		} else {
			System.out.println("                                                 ");
			System.out.println("Elige la ficha que quieres mover");
			Scanner scan = new Scanner(System.in);
			int i = scan.nextInt();
			i = i-1;
			return this.lista.elegirFicha(i);
		}
	}
	
	public ListaFichas getListaFichas() {
		return this.lista;
	}
	
	public boolean comprobarWin() {
		return this.lista.comprobarWin();
	}
}
