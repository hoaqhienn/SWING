package BorderLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
public class demo extends JFrame{
	private JButton
	bn=new JButton("North"),
	bs=new JButton("South"),
	be=new JButton("East"),
	bw=new JButton("West"),
	bc=new JButton("Center");
	public demo() {
		setTitle("BorderLayout");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(BorderLayout.NORTH, bn);
		add(BorderLayout.SOUTH, bs);
		add(BorderLayout.EAST, be);
		add(BorderLayout.WEST, bw);
		add(BorderLayout.CENTER, bc);
		
		bn.setBackground(Color.WHITE);
		bn.setForeground(Color.BLACK);
		
		bc.setBackground(Color.YELLOW);
		bc.setForeground(Color.BLUE);
		
		bs.setBackground(Color.WHITE);
		bs.setForeground(Color.RED);
		
		bw.setBackground(Color.YELLOW);
		bw.setForeground(Color.RED);
		
		be.setBackground(Color.YELLOW);
		be.setForeground(Color.GREEN);

	}
	public static void main(String[] args) {
		new demo().setVisible(true);
	}
}
