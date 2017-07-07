import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RippleSpotListener implements ActionListener {

    private FinalFrame frame; 
    private Spot spot; 
    private int value; 

    public RippleSpotListener(FinalFrame fr, Spot s, int v) {
    	frame = fr; 
    	spot = s; 
    	value = v; 

    }

    public void actionPerformed(ActionEvent e) {
	
    	if (value != 0) {
    		spot.setValue(value); 
    		if (!spot.getFilled())
    			spot.setFilled(true); 
    		spot.setText(value + ""); 
    	}
	
    	else {
    		spot.setValue(0); 
    		spot.setFilled(false); 
    		spot.setText(null); 
    	}

    	frame.validate(); 
    	frame.repaint(); 

    }

}