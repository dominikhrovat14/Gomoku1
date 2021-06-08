package graficni;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import logika.Igra;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	
	
	protected Panel panel;
	private JMenuItem menuVelikost;
	private JMenuItem menuIme;
	private JMenuItem menuClovek;
	private JMenuItem menuBarva;
	private JMenuItem menuCas;
	private int height = 500;
	private int width = 500;
	
	private JLabel aktivnaBarvaLabel;
	static Color barva;
	public static int velikost;
	
	public Igra igra;
	
	public Frame(Igra igra) {
		
		super();
		setTitle("Gomoku1");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel(height, width, 15, 15, igra); //panel = new Panel(800, 800, panel.cols, panel.rows)
		add(panel);
		setSize(width, height);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu menuIgra = dodajMenu(menubar, "Lastnosti igre");
		JMenu menuIgralec = dodajMenu(menubar, "Lastnosti igralca");
		JMenu menuNastavitve = dodajMenu(menubar, "Lastnosti grafičnega vmesnika");
		
		menuVelikost = dodajMenuItem(menuIgra,"Velikost");
		menuIme = dodajMenuItem(menuIgralec,"Ime");
		menuClovek = dodajMenuItem(menuIgralec,"Človek ali računalnik");
		menuBarva = dodajMenuItem(menuNastavitve,"Barva kovanca");
		menuCas = dodajMenuItem(menuNastavitve,"Čas poteze");
		
		
		Color aktivnaBarva = Color.RED;
		aktivnaBarvaLabel = new JLabel(" ");
		aktivnaBarvaLabel.setOpaque(true);
		aktivnaBarvaLabel.setBackground(aktivnaBarva);
		setBarva(aktivnaBarva);
		
		
}

	public JMenu dodajMenu(JMenuBar menubar, String naslov) {
		JMenu menu = new JMenu(naslov);
		menubar.add(menu);
		return menu;
	}
	
	public JMenuItem dodajMenuItem(JMenu menu, String naslov) {
		JMenuItem menuitem = new JMenuItem(naslov);
		menu.add(menuitem);
		menuitem.addActionListener(this);
		return menuitem;
	}
	
	public void setBarva(Color barva) {
		this.barva = barva;
		}
	
	public Color getBarva(Color barva) {
		this.barva = barva;
		return this.barva;
		}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == menuVelikost) {
			velikost = Integer.parseInt(JOptionPane.showInputDialog(this, "Velikost okna: "));
			Panel.dimenzije();
			panel.setSize(velikost,velikost);
			setSize(velikost, velikost);
		}
		if (source == menuIme) {
			String ime = JOptionPane.showInputDialog(this, "Ime igralca: ");
		
		}
		if (source == menuClovek) {
			
		}
		
		if (source == menuBarva) {
			Color novaBarva = JColorChooser.showDialog(this,
					"Izberite barvo", getBarva(barva));
					if (novaBarva != null) {
					setBarva(novaBarva);
					aktivnaBarvaLabel.setBackground(novaBarva);
			
					}
			}
		
	}
	
		
}


