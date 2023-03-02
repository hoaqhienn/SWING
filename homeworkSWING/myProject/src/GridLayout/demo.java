package GridLayout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class demo extends JFrame{
	public demo() {
		setTitle("GridLayout");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridLayout(10,5,10,10)); //row=7, column=3, h=5, v=5
		for (int i = 1; i <=34; i++) {
			add(new JButton("Button "+i));
		}
	}
	public static void main(String[] args) {
		new demo().setVisible(true);
	}
}