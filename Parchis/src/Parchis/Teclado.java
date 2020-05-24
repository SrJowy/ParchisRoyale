package Parchis;
import java.util.*;

public class Teclado {
	private static Teclado miTeclado = null;
	private Scanner sc;
	
	private Teclado() {}
	
	public static Teclado getTeclado() {
		if (Teclado.miTeclado == null) {
			Teclado.miTeclado = new Teclado();
		}
		return Teclado.miTeclado;
	}
	
	public int elegirValor() {
		int valor;
		sc = new Scanner(System.in);
		valor = sc.nextInt();
		return valor;
	}
	
	public int elegirNumeroJugadores() {
		int jug = 0;
		do {
			try {
				sc = new Scanner(System.in);
				jug = sc.nextInt();
				if (jug < 2 || jug > 4) {
					throw new ErrorValorException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un valor del 2 al 4");
			} catch (ErrorValorException e) {
				System.out.println("Introduce un valor del 2 al 4");
			}
			
		} while(jug < 2 || jug > 4);
		
		return jug;
	}
	
	public void pulsaCualquierTeclaParaContinuar() {
		sc = new Scanner(System.in);
		System.out.println("Pulsa intro para continuar...");
		sc.nextLine();
		System.out.println(" ");
	}
	
	public int pedirNFicha() {
		int ficha = 0;
		do {
			try {
				sc = new Scanner(System.in);
				ficha = sc.nextInt();
				if (ficha < 1 || ficha > 4) {
					throw new ErrorValorException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un valor del 1 al 4");
			} catch (ErrorValorException e) {
				System.out.println("Introduce un valor del 1 al 4");
			}
		} while(ficha < 1 || ficha > 4);
		
		return ficha;
	}
	
	public int pasar() {
		boolean bien = false;
		int c = 2;
		do {
			try {
				sc = new Scanner(System.in);
				c = sc.nextInt();
				if (c != 1 && c != 2) {
					throw new ErrorValorException();
				} else {
					bien = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce 1 si quieres continuar o 2 si quieres pasar");
			} catch (ErrorValorException e) {
				System.out.println("Introduce 1 si quieres continuar o 2 si quieres pasar");
			}
		} while(!bien);
		return c;
	}
	
}
