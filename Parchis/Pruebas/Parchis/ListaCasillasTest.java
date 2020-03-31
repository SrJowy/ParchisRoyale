package Parchis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaCasillasTest {
	ListaCasillas l1;
	Ficha f,f2;
	@Before
	public void setUp() throws Exception {
		l1 = new ListaCasillas();
		f = new Ficha("Azul");
		f2 = new Ficha("Amarillo");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		/*l1.sacarFicha(f, 66);
		assertEquals(66, l1.buscarCasilla(f).getNumCasilla());
		l1.moverFicha(6, f);
		assertEquals(4, l1.buscarCasilla(f).getNumCasilla());*/
		
		l1.sacarFicha(f, 13);
		l1.sacarFicha(f2,14);
		l1.moverFicha(2, f);
	}

}
