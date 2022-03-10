package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelDraw extends JPanel{

	public JPanelDraw() {
		this.setBackground(Color.white);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawLine(15, 15, 50, 150);
		
		g.setColor(Color.RED);
		g.drawOval(250, 250, 100, 100);
		
		g.setColor(Color.green);
		g.drawRect(45, 150, 30, 90);
		
		g.setColor(Color.pink);
		g.fillOval(400, 300, 50, 50);
		
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(100, 100, 150, 150);
		
		g.setColor(Color.BLUE);
		g.drawString("HELLO I'M DAVI", 300, 300);	
		
	}
}
