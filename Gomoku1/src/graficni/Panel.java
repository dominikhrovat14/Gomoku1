package graficni;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

import javax.swing.JPanel;

import logika.Igra;
import splosno.Koordinati;



public class Panel extends JPanel implements MouseListener {
	
	
	
	  int width, height;

	  int rows;

	  int cols;
	  
	  public int x, y;
	  public static Koordinati clovekPoteza;
	  public static int poteza;
	  public static Igra igra;
	  public static Set<Koordinati> moznePoteze = igra.moznePoteze;
	  
	public Panel(int sirina, int visina, int rows, int cols) {
		super(); 
		setPreferredSize(new Dimension(sirina, visina));
		GridsCanvas(sirina, visina, rows, cols);
		
		addMouseListener(this);
		
	}

		
		
		public void GridsCanvas(int w, int h, int r, int c) {
		    setSize(width = w, height = h);
		    rows = r;
		    cols = c;
		    
		  }

	
	  public void paint(Graphics g) {
		    int i;
		    width = getSize().width;
		    height = getSize().height;
		    
		    // narisi vrtice
		    int rowHt = height / (rows);
		    for (i = 0; i < rows; i++)
		      g.drawLine(0, i * rowHt, width, i * rowHt);

		    // narisi stolpce
		    int rowWid = width / (cols);
		    for (i = 0; i < cols; i++) {
		      g.drawLine(i * rowWid, 0, i * rowWid, height);
		    }
		    
		    if (poteza % 2 == 0) {
			    if (igra.moznePoteze.contains(clovekPoteza)) {
			    	Igra.preveriZmago(clovekPoteza);
			    	if (igra.zmagovalec == Igra.PRAZNO) {
				    	Igra.odigrajPotezo(clovekPoteza);
					    g.setColor(Color.red);
					    g.fillOval(CentralizirajX(x, 15, 500), CentralizirajY(y, 15, 500), 15, 15);
					    poteza ++;
			    	}
			    }
		    }
		    if (poteza % 2 != 0) {
		    	System.out.println(poteza + "POTEZA");
		    	Koordinati k = Igra.racunalnikPoteza();
		    	Igra.preveriZmago(k);
		    	if (igra.zmagovalec == Igra.PRAZNO) {
			    	g.setColor(Color.blue);
				    g.fillOval(CentralizirajX(pretvoriRacunalnik(k.getX(), 15, 500),15,500), CentralizirajY(pretvoriRacunalnik(k.getY(), 15, 500),15,500), 15, 15);
				    Igra.odigrajPotezo(k);
				    poteza ++;
		    	}
		    }
		    
		    

		  }
	
	  //postavi zeton na sredino kvadratka
	public int CentralizirajX(int x, int rows, int h) {
		for (int i = 0; i < h; i = i + (h / rows)){
			if (x < i) {
				x = (int)Math.round((i + (i - (h / rows) )) / 2); //x premaknemo v sredino

				return x-7;
		}
			
	}
		return 0;
		}
	
	public int CentralizirajY(int y, int cols, int w) {
		for (int i = 0; i < w; i = i + (int)Math.round(w / cols)){
			if (y < i) {
				y = (int)Math.round((i + (i - (w / cols) )) / 2); //x premaknemo v sredino
				return y-7;

		}
	}
		return 0;
		}
	
	//pretvori koordinate v koordinate od 0 do dim
	
	public int pretvoriKoordinatoX(int x, int rows, int h) {
		int j = -2;
		for (int i = 0; i < h; i = i + (h / rows)){
			j = j + 1;
			if (x < i) {
				return j;
				
		}
		
	}
		return 0;
		
}
	
	
	public int pretvoriKoordinatoY(int y, int cols, int w) {
		int j = -2;
		for (int i = 0; i < w; i = i + (w / cols)){
			j = j + 1;
			if (y < i) {
				return j;
				
		}
		
	}
		return 0;
		
}
	
	public int pretvoriRacunalnik(int x, int cols, int w) {
		for (int i = 0; i < cols; i++) {
			if (x < i) {
				x = ((2*i - 1) * (w / cols)) / 2;
				return x;
			}
		}
		return 0;
	}
	
	




	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		clovekPoteza = (new Koordinati((pretvoriKoordinatoX(x, 15, 500)), pretvoriKoordinatoY(y, 15, 500)));
		System.out.println(clovekPoteza);
		repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
