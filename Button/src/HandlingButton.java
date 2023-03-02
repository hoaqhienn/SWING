import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class HandlingButton implements ActionListener{
	JPanel jp;
	public HandlingButton(JPanel p) {
		jp = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jp.setBackground(Color.red);
		
	}
}
