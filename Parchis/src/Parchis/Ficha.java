package Parchis;

public class Ficha {
	private String color;
	
	public Ficha(String pColor) {
		this.color = pColor;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void esta(int i) {
		i = i+1;
		if (Tablero.getTablero().buscarCasilla(this) == null) {
			System.out.println("La ficha numero " + i + " esta en la base");
		} else {
			Casilla pCas = Tablero.getTablero().buscarCasilla(this);
			System.out.println("La ficha numero " + i + " esta en la casilla " + pCas.getNumCasilla() + " que es un/a " + pCas.getTipo());
		}
	}
	
	public void moverFicha(int pNum, ListaFichas lF) {
			if (lF.hayAlgunaEnCasa()) {
				if (Tablero.getTablero().buscarCasilla(this) == null) {
					if (pNum == 5 && !Tablero.getTablero().comprobarCasSalidaLlena(this)) { //sacar ficha a menos que la casilla de salida este llena
						this.sacarFicha();
					} else {
						System.out.println("Esa ficha no se puede elegir; pulsa 1 para elegir otra o pulsa 2 para pasar"); 
						if (Teclado.getTeclado().pasar() == 2) {
							System.out.println("Has pasado tu turno");
							return;
						} else {
							System.out.println("Elige otra ficha");
							lF.elegirFicha(Teclado.getTeclado().pedirNFicha()).moverFicha(pNum, lF);
						}
					}
				} else if (pNum == 5 && !Tablero.getTablero().comprobarCasSalidaLlena(this)) { //no se puede mover la ficha porque hay hueco en la casilla de salida
					System.out.println("Esa ficha no se puede elegir; pulsa 1 para elegir otra o pulsa 2 para pasar");
					if (Teclado.getTeclado().pasar() == 2) {
						System.out.println("Has pasado tu turno");
						return;
					} else {
						System.out.println("Elige otra ficha");
						lF.elegirFicha(Teclado.getTeclado().pedirNFicha()).moverFicha(pNum, lF);
					}
					
				} else if (!Tablero.getTablero().comprobarCasLlena(pNum, this) || (Tablero.getTablero().comprobarCasSalidaLlena(this) && pNum == 5)){ //la casilla de destino esta vacia y se puede mover
					
					Tablero.getTablero().moverFicha(pNum, this);														   							//con 5 puesto que la casilla de salida esta llena

					//se puede mover puesto que la casilla de destino no esta llena
				} else {
					System.out.println("Esa ficha no se puede elegir; pulsa 1 para elegir otra o pulsa 2 para pasar"); 
					if (Teclado.getTeclado().pasar() == 2) {
						System.out.println("Has pasado tu turno");
						return;
					} else {
						System.out.println("Elige otra ficha");
						lF.elegirFicha(Teclado.getTeclado().pedirNFicha()).moverFicha(pNum, lF);
					}
				}
			} else if (!Tablero.getTablero().comprobarCasLlena(pNum, this)) {
				Tablero.getTablero().moverFicha(pNum, this);
				
			} else {
				System.out.println("Esa ficha no se puede elegir; pulsa 1 para elegir otra o pulsa 2 para pasar"); 
				if (Teclado.getTeclado().pasar() == 2) {
					System.out.println("Has pasado tu turno");
					return;
				} else {
					System.out.println("Elige otra ficha");
					lF.elegirFicha(Teclado.getTeclado().pedirNFicha()).moverFicha(pNum, lF);
				}
			}
		}
	
	private void sacarFicha() {
		if (this.color == "Azul") {
			Tablero.getTablero().sacarFicha(this, 22);
		} else if (this.color == "Amarillo") {
			Tablero.getTablero().sacarFicha(this, 5);
		} else if (this.color == "Rojo") {
			Tablero.getTablero().sacarFicha(this, 39);
		} else {
			Tablero.getTablero().sacarFicha(this, 56);
		}
	}
	
	public boolean colorDiferente(Ficha pFicha) {
		if (this.color!=pFicha.color) {
			return true;
		}
		return false;
	}
}
