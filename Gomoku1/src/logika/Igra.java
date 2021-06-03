package logika;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import graficni.Frame;
import graficni.Panel;
import splosno.Koordinati;

public class Igra {
	
	public static char[][] board;
	public static int dim;
	public static Set<Koordinati> moznePoteze;
	public final static char PRAZNO = '.';
	public static Igra igra;
	public static int poteza = 0;
	public static char zmagovalec;
	
	public Igra(int dim) {
		this.dim = dim;
		zmagovalec = PRAZNO;
		board = new char[dim][dim];
		moznePoteze = new HashSet<Koordinati>();
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				board[i][j] = PRAZNO;
				Koordinati k = new Koordinati(i,j);
				moznePoteze.add(k);
			}
		}
	}
	
	public Igra() {
		this(15);
		
	}
	
	public static void zacni (Frame okvircek) {
		igra = new Igra ();
	}
	
	public static boolean odigrajPotezo(Koordinati k) {
		if (moznePoteze.contains(k)) {
			moznePoteze.remove(k);
			if (Panel.poteza % 2 == 0) {
				board[k.getX()][k.getY()] = 'X' ;
			}
			else if (Panel.poteza % 2 == 0) board[k.getX()][k.getY()] = 'O' ;
			return true;
		}
		return false;
	}
	
	public static char preveriZmago(Koordinati k) {
		java.util.List<Character> polja = Arrays.asList(ZmagaVrstica(k), ZmagaStolpec(k), ZmagaDiagonala(k)); 
		for (Character i : polja) {
			if (!i.equals(PRAZNO)) {
				igra.zmagovalec = 'X';
				return 'X';
			}
		}
		return PRAZNO;
	}
	
	public static Koordinati racunalnikPoteza() {
		Set<Koordinati> moznePoteze = igra.moznePoteze;
		int size = moznePoteze.size();
		int j = new Random().nextInt(size);
		int i = 0;
		Koordinati poteza = null; //na nekaj nastavimo
		for(Koordinati k : moznePoteze)
		{
			if (i == j) {
				poteza = k;
				return poteza;

				
			}
				
			i++;
		}
		Igra.odigrajPotezo(poteza);
		return poteza;

	}
	// to je zmaga stolpec?
	public static char ZmagaVrstica(Koordinati k) {
		int i = 0;
		for (char c : board[k.getX()]) {
			if (c == 'X') {
				i++;
				if (i >= 5) {
					return 'X';
				}
			}
			else {
				i = 0;
			}
		}
		return PRAZNO;
	}
	
	public static char ZmagaStolpec(Koordinati k) {
		int j = 0;
		for (int i = 0; i< dim; i++) {
			if (board[i][k.getY()] == 'X') {
				j++;
				if (j >= 5) {
					return 'X';
				}
			}
			else {
				j = 0;
			}
		}
		return PRAZNO;
	}
	public static char ZmagaDiagonala(Koordinati k) {
		return PRAZNO;
		/*int j = 0;
		int zacetek = Math.min(k.getX(),k.getY());
		int konec = dim - Math.max(k.getX(),k.getY()) + 1;
		for (int i = zacetek; i< konec; i++) {
			if (board[k.getX() - i][k.getY() - i] == 'X') {
				j++;
				if (j >= 4) {
					return 'X';
				}
			}
			else {
				j = 0;
			}
		}
		return PRAZNO;   */
	}
	
	
	

}
