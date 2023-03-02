import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;import javax.swing.text.AttributeSet.ColorAttribute;

public class Button extends JFrame implements ActionListener{

	JButton btn1, btn2;
	JPanel jp;
	
	public Button() {
		super("Button test with Handling!");
		jp = new JPanel();
		jp.add(btn1 = new JButton("RED"));
		jp.add(btn2 = new JButton("BLUE"));
		add(jp);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setVisible(true);
		setSize(300,300);
		
		
	}
	public static void main(String[] args) {
		new Button();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src.equals(btn1))
			jp.setBackground(Color.red);
		else if (src.equals(btn2)) {
			jp.setBackground(Color.blue);
		}
	}
}
