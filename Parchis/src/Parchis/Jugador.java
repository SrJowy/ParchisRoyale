package Parchis;

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
		this.lista.esta();
		if (this.lista.estanTodasEnCasa() && pRes !=5) {
			System.out.println("                                                ");
			System.out.println("No puedes mover tu ficha, porque no puedes sacar");
			return null;
		} else {
			System.out.println("                                                 ");
			System.out.println("Elige la ficha que quieres mover");
			int i = Teclado.getTeclado().pedirNFicha();
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
