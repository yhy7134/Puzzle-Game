import java.awt.event.*; 

public class AkariSwitcher implements ActionListener {

    private FinalFrame frame; 

    public AkariSwitcher(FinalFrame fr) {
    	frame = fr; 
    }

    public void actionPerformed(ActionEvent e) {
    	frame.getContentPane().removeAll(); 
    	frame.initAkari(); 
    	frame.pack();
    	frame.validate(); 
    	frame.repaint(); 
    }

}