package Parchis;
import java.util.*;

public class Tablero {
	private ListaJugadores listaJ;
	private ListaCasillas listaC;
	private static Tablero miTablero;
	
	private Tablero() {
		this.listaJ = new ListaJugadores();
		this.listaC = new ListaCasillas();
	}
	
	public static Tablero getTablero() {
		
		if (Tablero.miTablero == null) {
			Tablero.miTablero = new Tablero();
		}
		
		return Tablero.miTablero;
	}
	
	public void pulsaCualquierTeclaParaContinuar() {
		String continuar;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Pulsa cualquier tecla para continuar...");
		continuar = teclado.nextLine();
	}
	
	public void jugarPartida() {
		
		boolean win = false;
		System.out.println("Bienvenido al Parchis Royale!");
		System.out.println("Por favor, introduce el numero de jugadores");
		Scanner entrada = new Scanner(System.in);
		int num = entrada.nextInt();
		this.listaJ.elegirNJugadores(num);
		int i = -1;
		
		while (!win) {
			i++;
			Jugador pJugador = this.listaJ.elegirJugador(i);
			int aux = i+1;
			System.out.println("Es tu turno jugador " + aux + ", " + pJugador.getColor());
			System.out.println("                                                       ");
			int res = Dado.getDado().lanzarDado(pJugador.getListaFichas(),listaC);
			Ficha pFicha = pJugador.elegirFicha(res, this.listaC);
			if (pFicha != null) {
				pFicha.moverFicha(res, this.listaC, pJugador.getListaFichas());
				System.out.println("                                                      ");
				this.pulsaCualquierTeclaParaContinuar();
			} else {
				System.out.println("Le toca al siguiente.");
				System.out.println("------------------------------------------------------");
				System.out.println("                                                      ");
			    this.pulsaCualquierTeclaParaContinuar();
			}
			
			if (pJugador.comprobarWin()) {
				win = true;
				System.out.println("Ha ganado el jugador " + aux + ", " + pJugador.getColor());
			} else {
				if (this.listaJ.hemosLlegadoAlFinal(i)) {
					i = -1;
				}
			}
		}
		
	}
}
