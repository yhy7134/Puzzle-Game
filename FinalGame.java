import java.awt.*;

public class FinalGame {

    public static void main(String[] args) {
		
    	FinalFrame frame = new FinalFrame();
	
    	frame.init();	
    	frame.pack();
    	frame.setVisible(true);
    	frame.setPreferredSize(new Dimension(600,600));
    	frame.repaint();
		
    }
	
}