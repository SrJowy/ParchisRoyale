package Parchis;
import java.util.*;

public class Tablero {
	private ListaJugadores listaJ;
	private ListaCasillas listaC;
	private static Tablero miTablero;
	
	/*private*/public Tablero() {
		this.listaJ = new ListaJugadores();
		this.listaC = new ListaCasillas();
	}
	
	/*public Tablero getTablero() {
		
		if (Tablero.miTablero == null) {
			Tablero.miTablero = new Tablero();
		}
		
		return Tablero.miTablero;
	}*/
	
	public void jugarPartida() {
		
		
		
		boolean win = false;
		System.out.println("Bienvenido al Parchis Royale!");
		System.out.println("Por favor, introduce el numero de jugadores");
		Scanner entrada = new Scanner(System.in);
		int num = entrada.nextInt();
		this.listaJ.elegirNJugadores(num, this.listaC);
		int i = -1;
		
		while (!win) {
			i++;
			Jugador pJugador = this.listaJ.elegirJugador(i);
			int aux = i+1;
			System.out.println("Es tu turno jugador " + aux + ", " + pJugador.getColor());
			int res = Dado.getDado().lanzarDado();
			Ficha pFicha = pJugador.elegirFicha(res, this.listaC);
			if (pFicha != null) {
				pFicha.moverFicha(res, this.listaC, pJugador.getListaFichas());
			} else {
				System.out.println("Le toca al siguiente.");
				System.out.println("------------------------------------------------------");
				System.out.println("                                                      ");
			}
			if (this.listaJ.hemosLlegadoAlFinal(i)) {
				i = -1;
			}
			
		}
		
	}
}
