import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class CheckListener implements ActionListener {

	private FinalFrame frame;
	private Solver game;
	private Spot[][] spot;
	private JLabel checked;
	
	public CheckListener (FinalFrame fr, Solver g, Spot[][] s, JLabel ch){
		frame = fr;
		game = g;
		spot = s;
		checked = ch;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		boolean correct = game.checkAllConstraints(spot);
		if (correct)
			checked.setText("Correct");
		else
			checked.setText("Incorrect");
		
		frame.validate();
		frame.repaint();	
	}

}
