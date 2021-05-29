package logika;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import graficni.Panel;
import splosno.Koordinati;

public class Igra {
	
	public static char[][] board;
	protected int dim;
	public static Set<Koordinati> moznePoteze;
	protected final static char PRAZNO = '.';
	public static Igra igra;
	public static int poteza = 0;
	
	
	public Igra(int dim) {
		this.dim = dim;
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
	
	public static void zacni () {
		igra = new Igra ();
		
	}
	
	public static boolean odigrajPotezo(Koordinati k) {
		if (moznePoteze.contains(k)) {
			moznePoteze.remove(k);
			System.out.println(moznePoteze);
			if (Panel.poteza % 2 == 0) {
				board[k.getX()][k.getY()] = 'X' ;
			}
			else if (Panel.poteza % 2 == 0) board[k.getX()][k.getY()] = 'O' ;
			return true;
		}
		return false;
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
	
	
	

}
