import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RippleSpotMenu implements ActionListener {
    
    private FinalFrame frame; 
    private Spot selected; 
    JPopupMenu  menu;

    public RippleSpotMenu(FinalFrame fr, Spot s) {
    	
    	frame = fr; 
    	selected = s; 
    	menu = new JPopupMenu("Menu"); 

    	JMenuItem value1 = new JMenuItem("1");
    	menu.add(value1); 
    	value1.addActionListener(new RippleSpotListener(frame, selected, 1)); 

    	JMenuItem value2 = new JMenuItem("2"); 
    	menu.add(value2); 
    	value2.addActionListener(new RippleSpotListener(frame, selected, 2)); 
	
    	JMenuItem value3 = new JMenuItem("3"); 
    	menu.add(value3); 
    	value3.addActionListener(new RippleSpotListener(frame, selected, 3)); 

    	JMenuItem clear = new JMenuItem("Clear box"); 
    	menu.add(clear); 
    	clear.addActionListener(new RippleSpotListener(frame, selected, 0)); 
    	
    }

    public void actionPerformed(ActionEvent e) { 
	
    	menu.show(selected,selected.getWidth()/2,selected.getHeight()/2);
    	
    }
}