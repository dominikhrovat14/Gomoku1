package graficni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame implements ActionListener {
	
	
	protected Panel panel;
	
public Frame() {
		
		super();
		setTitle("Gomoku1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Panel(500, 500, 15, 15); //panel = new Panel(800, 800, panel.cols, panel.rows)
		add(panel);
		
		
}

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
