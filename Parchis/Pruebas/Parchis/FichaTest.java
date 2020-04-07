package Parchis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FichaTest {

	ListaCasillas l1;
	Ficha f1,f2,f3,f4,f5;
	Jugador j1;
	@Before
	public void setUp() throws Exception {
		j1 = new Jugador("Azul", 1);
		l1 = new ListaCasillas();
		f1 = new Ficha("Azul");
		f2 = new Ficha("Azul");
		f3 = new Ficha("Amarillo");
		f4 = new Ficha("Azul");
		f5 = new Ficha("Azul");
		j1.getListaFichas().anadirFicha(f1);
		j1.getListaFichas().anadirFicha(f2);
		j1.getListaFichas().anadirFicha(f4);
		j1.getListaFichas().anadirFicha(f5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFicha() {
		/*l1.sacarFicha(f1, 2);
		f1.setCasAct(2);
		l1.sacarFicha(f2, 2);
		f3.setCasAct(2);
		assertEquals(2,l1.buscarCasilla(f1).getNumCasilla());
		assertEquals(2,l1.buscarCasilla(f2).getNumCasilla());
		assertTrue(l1.buscarCasilla(f1).estaLlena());
		l1.sacarFicha(f3, 67);
		f3.setCasAct(67);
		assertEquals(67, l1.buscarCasilla(f3).getNumCasilla());
		f3.moverFicha(3, l1, lF);
		assertEquals(67, l1.buscarCasilla(f3).getNumCasilla());*/
		
		//BASE LLENA
		/*f1.moverFicha(5, l1, j1.getListaFichas());
		f2.moverFicha(5, l1, j1.getListaFichas());
		assertEquals(l1.getCas(22).getNumCasilla(), 22);
		assertEquals(22, l1.buscarCasilla(f1).getNumCasilla());
		assertEquals(22, l1.buscarCasilla(f2).getNumCasilla());
		f4.moverFicha(5, l1, j1.getListaFichas());
		assertEquals(0, f4.getCasAct());
		assertEquals(0, f5.getCasAct());
		f1.moverFicha(5, l1, j1.getListaFichas());
		/*f1.setCasAct(15);
		f1.setBase(false);
		assertEquals(15, l1.buscarCasilla(f1).getNumCasilla());
		f1.moverFicha(3, l1, j1.getListaFichas());
		assertEquals(69, f1.getCasAct());
		assertEquals(69, l1.buscarCasilla(f1).getNumCasilla());*/
	}

	@Test
	public void testSetCasAct() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMeta() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMeta() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPasillo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPasillo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBase() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBase() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetColor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCasilla() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsta() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoverFicha() {
		fail("Not yet implemented");
	}

	@Test
	public void testSacarFicha() {
		fail("Not yet implemented");
	}

	@Test
	public void testColorDiferente() {
		fail("Not yet implemented");
	}

	@Test
	public void testComprobarCasLlena() {
		
	}

}
