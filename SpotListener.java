import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpotListener implements ActionListener {

    private Spot selected; 
    private FinalFrame frame; 

    public SpotListener (FinalFrame fr, Spot s) {
    	frame = fr; 
    	selected = s; 
    }

   public void actionPerformed(ActionEvent e) { 
       if (!selected.getFilled()) {
    	   selected.setBackground(Color.PINK);
    	   selected.setFilled(true); 
    	   selected.setValue(1); 
       }
       else {
    	   selected.setBackground(null); 
    	   selected.setFilled(false);
    	   selected.setValue(0); 
       }
       frame.validate(); 
       frame.repaint(); 
   }

}