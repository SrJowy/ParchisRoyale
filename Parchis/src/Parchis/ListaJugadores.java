package Parchis;
import java.util.*;

public class ListaJugadores {
	private ArrayList <Jugador> lista;
	private int minJug = 2;
	private int maxJug = 4;
	
	public ListaJugadores() {
		this.lista = new ArrayList <Jugador>();
	}
	
	public void elegirNJugadores(int pNum) {
		if (pNum < minJug || pNum > maxJug) {
			System.out.println("Numero de jugadores no valido");
			
		} else if (pNum == 2) {
			Jugador j1 = new Jugador("Azul",1);
			this.lista.add(j1);
			Ficha f1 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f1);
			Ficha f2 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f2);
			Ficha f3 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f3);
			Ficha f4 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f4);
			
			Jugador j2 = new Jugador("Amarillo",2);
			this.lista.add(j2);
			Ficha f12 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f12);
			Ficha f22 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f22);
			Ficha f32 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f32);
			Ficha f42 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f42);

			
		} else if (pNum == 3) {
			Jugador j1 = new Jugador("Azul",1);
			this.lista.add(j1);
			Ficha f1 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f1);
			Ficha f2 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f2);
			Ficha f3 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f3);
			Ficha f4 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f4);
			
			Jugador j2 = new Jugador("Amarillo",2);
			this.lista.add(j2);
			Ficha f12 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f12);
			Ficha f22 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f22);
			Ficha f32 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f32);
			Ficha f42 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f42);
			
			Jugador j3 = new Jugador("Rojo",3);
			this.lista.add(j3);
			Ficha f13 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f13);
			Ficha f23 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f23);
			Ficha f33 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f33);
			Ficha f43 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f43);
			
		} else {
			Jugador j1 = new Jugador("Azul",1);
			this.lista.add(j1);
			Ficha f1 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f1);
			Ficha f2 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f2);
			Ficha f3 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f3);
			Ficha f4 = new Ficha("Azul");
			j1.getListaFichas().anadirFicha(f4);
			
			Jugador j2 = new Jugador("Amarillo",2);
			this.lista.add(j2);
			Ficha f12 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f12);
			Ficha f22 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f22);
			Ficha f32 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f32);
			Ficha f42 = new Ficha("Amarillo");
			j2.getListaFichas().anadirFicha(f42);
			
			Jugador j3 = new Jugador("Rojo",3);
			this.lista.add(j3);
			Ficha f13 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f13);
			Ficha f23 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f23);
			Ficha f33 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f33);
			Ficha f43 = new Ficha("Rojo");
			j3.getListaFichas().anadirFicha(f43);
			
			Jugador j4 = new Jugador("Verde",4);
			this.lista.add(j4);
			Ficha f14 = new Ficha("Verde");
			j4.getListaFichas().anadirFicha(f14);
			Ficha f24 = new Ficha("Verde");
			j4.getListaFichas().anadirFicha(f24);
			Ficha f34 = new Ficha("Verde");
			j4.getListaFichas().anadirFicha(f34);
			Ficha f44 = new Ficha("Verde");
			j4.getListaFichas().anadirFicha(f44);
		}
	}
	
	public Jugador elegirJugador(int i) {
		
		return this.lista.get(i);
	}
	
	public boolean hemosLlegadoAlFinal(int i) {
		if (i == this.lista.size()-1) {
			return true;
		}
		return false;
	}
	
	public void anadirJugador(Jugador pJugador) {
		String color;
		this.lista.add(pJugador);
		if (pJugador.getColor() == "Azul") {
			color = "Azul";
		} else if (pJugador.getColor() == "Rojo") {
			color = "Rojo";
		} else if (pJugador.getColor() == "Verde") {
			color = "Verde";
		} else {
			color = "Amarillo";
		}
		
		Ficha f1 = new Ficha(color);
		pJugador.getListaFichas().anadirFicha(f1);
		Ficha f2 = new Ficha(color);
		pJugador.getListaFichas().anadirFicha(f2);
		Ficha f3 = new Ficha(color);
		pJugador.getListaFichas().anadirFicha(f3);
		Ficha f4 = new Ficha(color);
		pJugador.getListaFichas().anadirFicha(f4);
	}
}
