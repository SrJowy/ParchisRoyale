package Parchis;

public class Tablero {
	private ListaJugadores listaJ;
	private ListaCasillas listaC;
	private static Tablero miTablero = null;
	private int turno = -1;
	private boolean trucos = true;
	
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
		int res = pNum;
		System.out.println("");
		System.out.println("Elige ficha y cuenta " + pNum);
		System.out.println("");
		Ficha pFicha = this.listaJ.elegirJugador(this.turno).elegirFicha(res);
		pFicha.moverFicha(res, this.listaJ.elegirJugador(this.turno).getListaFichas());
	}
	
	public void setTurno(int pNum) {
		this.turno = pNum;
	}
	
	public void limpiarTablero() {
		this.listaC.limpiarTablero();
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
			System.out.println("Se ha sumado uno al resultado del dado por tener todas las fichas fuera");
		}
		System.out.println("--> Has sacado un " + res);
		
		return res;
	}
	
	public void anadirJugadores(int pNum) {
		this.listaJ.elegirNJugadores(pNum);
	}
	
	public Jugador getJugador(int pNum) {
		return this.listaJ.elegirJugador(pNum);
	}
	
	public boolean comprobarCasLlena(int pNum, Ficha pFicha) {
		return this.listaC.comprobarCasLlena(pNum, pFicha);
	}
	
	public boolean comprobarCasSalidaLlena(Ficha pFicha) {
		return this.listaC.casSalidaLlena(pFicha);
	}
	
	public static void main(String[]args) {
		Tablero.getTablero().jugarPartida();
	}
	
	public void jugarPartida() {
		
		int res;
		boolean win = false;
		System.out.println("Bienvenido al Parchis Royale Master!");
		System.out.println("Por favor, introduce el numero de jugadores");
		int num = Teclado.getTeclado().elegirNumeroJugadores();
		this.listaJ.elegirNJugadores(num);
		
		while (!win) {
			this.turno++;
			Jugador pJugador = this.listaJ.elegirJugador(this.turno);
			int aux = this.turno+1;
			System.out.println("Es tu turno jugador " + aux + ", " + pJugador.getColor());
			System.out.println("");
			
			if (this.trucos) {
				System.out.println("Elige un valor");
				res = Teclado.getTeclado().elegirValor();
			} else {
				res = this.lanzarDado(pJugador.getListaFichas());
			}
			
			Ficha pFicha = pJugador.elegirFicha(res);
			if (pFicha != null) {
				pFicha.moverFicha(res, pJugador.getListaFichas());
			} else {
				System.out.println("Le toca al siguiente.");
				System.out.println("------------------------------------------------------");	
			}
			System.out.println("                                                      ");
			Teclado.getTeclado().pulsaCualquierTeclaParaContinuar();
			System.out.println("------------------------------------------------------");
			
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
