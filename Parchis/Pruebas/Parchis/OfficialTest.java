package Parchis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OfficialTest {
	Jugador j1,j2;
	Ficha f1,f2,f3,f4,f5,f6,f7,f8;

	@Before
	public void setUp() throws Exception {
		Tablero.getTablero().setTurno(0);
		Tablero.getTablero().anadirJugadores(2);
		j1 = Tablero.getTablero().getJugador(0);
		j2 = Tablero.getTablero().getJugador(1);
		f1 = j1.getFicha(1);
		f2 = j1.getFicha(2);
		f3 = j1.getFicha(3);
		f4 = j1.getFicha(4);
		f5 = j2.getFicha(1);
		f6 = j2.getFicha(2);
		f7 = j2.getFicha(3);
		f8 = j2.getFicha(4);
	}

	@After
	public void tearDown() throws Exception {
		Tablero.getTablero().limpiarTablero();
	}

	@Test
	public void casillaSalidaLlena() {
		System.out.println("TEST: casillaSalidaLLeno");
		f1.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(5, j1.getListaFichas());
		f3.moverFicha(5, j1.getListaFichas());
		System.out.println("");
		
	}
	
	@Test
	public void finalTablero() {
		System.out.println("TEST: finalTablero");
		f1.moverFicha(5, j1.getListaFichas());
		f1.moverFicha(44, j1.getListaFichas());
		f1.moverFicha(3, j1.getListaFichas());
		assertEquals(1,Tablero.getTablero().buscarCasilla(f1).getNumCasilla());
		System.out.println("");
	}
	
	@Test
	public void entrarPasillos() {
		System.out.println("TEST: entrarPasillos");
		f1.moverFicha(5, j1.getListaFichas());
		f1.moverFicha(63, j1.getListaFichas());
		f1.moverFicha(2, j1.getListaFichas());
		assertEquals(70, Tablero.getTablero().buscarCasilla(f1).getNumCasilla());
		System.out.println("");
		f5.moverFicha(5, j2.getListaFichas());
		f5.moverFicha(63, j2.getListaFichas());
		f5.moverFicha(2, j1.getListaFichas());
		assertEquals(94, Tablero.getTablero().buscarCasilla(f5).getNumCasilla());
		System.out.println("");
	}
	
	@Test
	public void noSalirseDePasillo() {
		System.out.println("TEST: noSalirseDelosPasillos");
		f1.moverFicha(5, j1.getListaFichas());
		f1.moverFicha(64, j1.getListaFichas());
		f1.moverFicha(8, j1.getListaFichas());
		System.out.println("");
		f5.moverFicha(5, j2.getListaFichas());
		f5.moverFicha(64, j1.getListaFichas());
		f5.moverFicha(8, j1.getListaFichas());
		System.out.println("");
	}
	
	@Test
	public void comerFichaYContar20() {
		System.out.println("TEST: comerFichaYContar20");
		f1.moverFicha(5, j1.getListaFichas());
		f5.moverFicha(5, j2.getListaFichas());
		assertEquals(22, Tablero.getTablero().buscarCasilla(f1).getNumCasilla());
		assertEquals(5, Tablero.getTablero().buscarCasilla(f5).getNumCasilla());
		f1.moverFicha(3, j1.getListaFichas());
		Tablero.getTablero().setTurno(1);
		f5.moverFicha(20, j1.getListaFichas());
		assertEquals(45, Tablero.getTablero().buscarCasilla(f5).getNumCasilla());
		System.out.println("");
	}
	
	@Test
	public void contar10AlLlegarACasa() {
		System.out.println("TEST: contar10AlLlegarACasa");
		f1.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(5, j1.getListaFichas());
		assertEquals(22, Tablero.getTablero().buscarCasilla(f1).getNumCasilla());
		assertEquals(22, Tablero.getTablero().buscarCasilla(f2).getNumCasilla());
		f1.moverFicha(71, j1.getListaFichas());
		assertEquals(32, Tablero.getTablero().buscarCasilla(f2).getNumCasilla());
		System.out.println("");
	}
	
	@Test
	public void noComerEnSegurosYEnSalidas() {
		System.out.println("TEST: noComerEnSegurosYEnSalidas");
		f1.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(7, j1.getListaFichas());
		f5.moverFicha(5, j2.getListaFichas());
		f5.moverFicha(17, j2.getListaFichas());
		assertEquals(Tablero.getTablero().buscarCasilla(f1).getNumCasilla(), Tablero.getTablero().buscarCasilla(f5).getNumCasilla());
		f5.moverFicha(7, j2.getListaFichas());
		assertEquals(Tablero.getTablero().buscarCasilla(f2).getNumCasilla(), Tablero.getTablero().buscarCasilla(f5).getNumCasilla());
		System.out.println("");
	}
	
	@Test
	public void SacarUn7SiTodasLasFichasFuera() {
		System.out.println("TEST: sacarUn7SiTodasLasFichasFuera");
		f1.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(20, j1.getListaFichas());
		f3.moverFicha(5, j1.getListaFichas());
		f3.moverFicha(10, j1.getListaFichas());
		f4.moverFicha(5, j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		Tablero.getTablero().lanzarDado(j1.getListaFichas());
		System.out.println("");
	}
	
	@Test
	public void SacarUn5Avanzar() {
		System.out.println("TEST: sacarUn5Avanzar");
		f1.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(20, j1.getListaFichas());
		f3.moverFicha(5, j1.getListaFichas());
		f3.moverFicha(10, j1.getListaFichas());
		f4.moverFicha(5, j1.getListaFichas());
		f1.moverFicha(5, j1.getListaFichas());
		assertEquals(27, Tablero.getTablero().buscarCasilla(f1).getNumCasilla());
		System.out.println("");
	}
	
	@Test
	public void noSePuedePasarSiBarrera() {
		System.out.println("TEST: noSePuedePasarSiBarrera");
		f1.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(5, j1.getListaFichas());
		f5.moverFicha(5, j2.getListaFichas());
		f5.moverFicha(20, j1.getListaFichas());
		assertEquals(5, Tablero.getTablero().buscarCasilla(f5).getNumCasilla());
		f1.moverFicha(1, j1.getListaFichas());
		assertEquals(23, Tablero.getTablero().buscarCasilla(f1).getNumCasilla());
		System.out.println("");
	}
	
	@Test
	public void comprobarVictoria() {
		System.out.println("TEST: comprobarVictoria");
		f1.moverFicha(5, j1.getListaFichas());
		f2.moverFicha(5, j1.getListaFichas());
		f1.moverFicha(71, j1.getListaFichas());
		assertEquals(76, Tablero.getTablero().buscarCasilla(f1).getNumCasilla());
		f3.moverFicha(5, j1.getListaFichas());
		f3.moverFicha(71, j1.getListaFichas());
		assertEquals(76, Tablero.getTablero().buscarCasilla(f3).getNumCasilla());
		f4.moverFicha(5, j1.getListaFichas());
		f4.moverFicha(71, j1.getListaFichas());
		assertEquals(76, Tablero.getTablero().buscarCasilla(f4).getNumCasilla());
		f2.moverFicha(41, j1.getListaFichas());
		assertEquals(76, Tablero.getTablero().buscarCasilla(f2).getNumCasilla());
		assertTrue(j1.comprobarWin());
		System.out.println("");
	}

}
