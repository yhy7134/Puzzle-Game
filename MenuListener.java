import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
	
	private FinalFrame frame;
	
	public MenuListener(FinalFrame fr){
		frame = fr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll(); 
    	frame.init(); 
    	frame.pack();
    	frame.validate(); 
    	frame.repaint(); 
	}

}
