package graficni;

import logika.Igra;

public class Glavna {

	public static void main(String[] args) {
		
		
		Frame frame = new Frame();
		frame.pack();
		frame.setVisible(true);
		
		Igra.zacni(frame);


	}

}
