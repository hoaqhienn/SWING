package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.MouseExampleView;

public class MouseExampleController implements MouseListener, MouseMotionListener{
	private MouseExampleView mouseExampleView;
	
	
	public MouseExampleController(MouseExampleView mouseExampleView) {
		this.mouseExampleView = mouseExampleView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.mouseExampleView.click();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.mouseExampleView.enter();
		int x = e.getX();
		int y =  e.getY();
		this.mouseExampleView.update(x, y);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.mouseExampleView.exit();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.mouseExampleView.update(x, y);
	}

}