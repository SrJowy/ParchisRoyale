package Parchis;

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
	
	public Casilla getCasilla(int cas) {
		return this.listaC.getCas(cas);
	}
	
	public void sacarFicha(Ficha pFicha, int pCas) {
		this.listaC.sacarFicha(pFicha, pCas);
	}
	
	public Casilla buscarCasilla (Ficha pFicha) {
		return this.listaC.buscarCasilla(pFicha);
	}
	
	public void moverFicha (int pNum, Ficha pFicha) {
		this.listaC.moverFicha(pNum, pFicha);
	}
	
	public int lanzarDado(ListaFichas l1) {
		int res = Dado.getDado().lanzarDado();
		if (l1.estanTodasFuera() && res == 6) {
			res++;
		}
		return res;
	}
	
	public boolean comprobarCasLlena(int pNum, Ficha pFicha) {
		return this.listaC.comprobarCasLlena(pNum, pFicha);
	}
	
	public boolean comprobarCasSalidaLlena(Ficha pFicha) {
		return this.listaC.casSalidaLlena(pFicha);
	}
	
	public void jugarPartida() {
		
		boolean win = false;
		System.out.println("Bienvenido al Parchis Royale!");
		System.out.println("Por favor, introduce el numero de jugadores");
		int num = Teclado.getTeclado().elegirNumeroJugadores();
		this.listaJ.elegirNJugadores(num);
		int i = -1;
		
		while (!win) {
			i++;
			Jugador pJugador = this.listaJ.elegirJugador(i);
			int aux = i+1;
			System.out.println("Es tu turno jugador " + aux + ", " + pJugador.getColor());
			System.out.println("                                                       ");
			int res = this.lanzarDado(pJugador.getListaFichas());
			Ficha pFicha = pJugador.elegirFicha(res, this.listaC);
			if (pFicha != null) {
				pFicha.moverFicha(res, pJugador.getListaFichas());
				System.out.println("                                                      ");
				Teclado.getTeclado().pulsaCualquierTeclaParaContinuar();
			} else {
				System.out.println("Le toca al siguiente.");
				System.out.println("------------------------------------------------------");
				System.out.println("                                                      ");
			    Teclado.getTeclado().pulsaCualquierTeclaParaContinuar();
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
