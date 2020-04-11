package Parchis;

public class Tablero {
	private ListaJugadores listaJ;
	private ListaCasillas listaC;
	private static Tablero miTablero;
	private int turno = -1;
	private static Tablero instancia = new Tablero();
	
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
	
	public void contarNum(int pNum) {
		this.turno++;
		int res = pNum;
		Jugador pJugador = this.listaJ.elegirJugador(this.turno);
		System.out.println("");
		System.out.println("Elige ficha y cuenta " + pNum);
		System.out.println("");
		Ficha pFicha = pJugador.elegirFicha(res);
		pFicha.moverFicha(res, pJugador.getListaFichas());
	}
	
	public void volverATirar() {
		this.turno--;
		System.out.println("Vuelve a tirar");
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
	
	public void anadirJugador(Jugador pJugador) {
		this.listaJ.anadirJugador(pJugador);
	}
	
	public boolean comprobarCasLlena(int pNum, Ficha pFicha) {
		return this.listaC.comprobarCasLlena(pNum, pFicha);
	}
	
	public boolean comprobarCasSalidaLlena(Ficha pFicha) {
		return this.listaC.casSalidaLlena(pFicha);
	}
	
	public static void main(String[]args) {
		instancia.jugarPartida();
	}
	
	public void jugarPartida() {
		
		boolean win = false;
		System.out.println("Bienvenido al Parchis Royale!");
		System.out.println("Por favor, introduce el numero de jugadores");
		int num = Teclado.getTeclado().elegirNumeroJugadores();
		this.listaJ.elegirNJugadores(num);
		
		while (!win) {
			this.turno++;
			Jugador pJugador = this.listaJ.elegirJugador(this.turno);
			int aux = this.turno+1;
			System.out.println("Es tu turno jugador " + aux + ", " + pJugador.getColor());
			System.out.println("                                                       ");
			int res = this.lanzarDado(pJugador.getListaFichas());
			Ficha pFicha = pJugador.elegirFicha(res);
			if (pFicha != null) {
				pFicha.moverFicha(res, pJugador.getListaFichas());
			} else {
				System.out.println("Le toca al siguiente.");
				System.out.println("------------------------------------------------------");	
			}
			System.out.println("                                                      ");
			Teclado.getTeclado().pulsaCualquierTeclaParaContinuar();
			
			if (pJugador.comprobarWin()) {
				win = true;
				System.out.println("Ha ganado el jugador " + aux + ", " + pJugador.getColor());
			} else {
				if (this.listaJ.hemosLlegadoAlFinal(this.turno)) {
					this.turno = -1;
				}
			}
		}
		
	}
}
