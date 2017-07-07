import java.awt.event.*; 

public class RippleEffectSwitcher implements ActionListener {

    private FinalFrame frame; 

    public RippleEffectSwitcher(FinalFrame fr) {
    	frame = fr; 
    }

    public void actionPerformed(ActionEvent e) {
    	frame.getContentPane().removeAll(); 
    	frame.initRe(); 
    	frame.pack();
    	frame.validate(); 
    	frame.repaint(); 
    }

}