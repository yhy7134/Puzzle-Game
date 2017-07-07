import java.awt.event.*; 

public class KakurasuSwitcher implements ActionListener {

    private FinalFrame frame; 

    public KakurasuSwitcher(FinalFrame fr) {
    	frame = fr; 
    }

    public void actionPerformed(ActionEvent e) {
    	frame.getContentPane().removeAll(); 
    	frame.initKak(); 
    	frame.pack();
    	frame.validate(); 
    	frame.repaint(); 
    }

}