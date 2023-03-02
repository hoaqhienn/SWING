package source_codes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class demo extends JFrame {
	private static final long serialVerionUID = 1L;
	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		jf.setTitle("^_^");
		jf.setSize(600, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		JPanel jpN = new JPanel();
		add(BorderLayout.NORTH, jpN);
		JLabel title = new JLabel("QUAN LY NHAN VIEN");
		jpN.add(title);
		
		JPanel jpC = new JPanel();
		jf.add(jpC,BorderLayout.CENTER);
		JLabel fname = new JLabel("Ten nhan vien: ");
		jpN.add(fname);
	}
}
