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
	
	public int elegirNumeroJugadores() {
		int jug = 0;
		do {
			try {
				sc = new Scanner(System.in);
				jug = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Introduce un valor del 2 al 4");
			}
		} while(jug < 2 || jug > 4);
		
		return jug;
	}
	
	public void pulsaCualquierTeclaParaContinuar() {
		sc = new Scanner(System.in);
		System.out.println("Pulsa intro para continuar...");
		sc.nextLine();
		System.out.println("                                        ");
	}
	
	public int pedirNFicha() {
		int ficha = 0;
		do {
			try {
				sc = new Scanner(System.in);
				ficha = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Introduce un valor del 1 al 4");
			}
		} while(ficha < 1 || ficha > 4);
		
		return ficha;
	}
	
}
