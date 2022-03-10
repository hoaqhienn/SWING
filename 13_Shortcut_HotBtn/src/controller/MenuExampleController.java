package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MenuExampleView;

public class MenuExampleController implements ActionListener{
	private MenuExampleView menuExampleView;
	
	
	
	public MenuExampleController(MenuExampleView menuExampleView) {
		this.menuExampleView = menuExampleView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.equals("Open")) {
			this.menuExampleView.setTextJLabel("Bạn đã click JmenuItem Open");
		}else if(button.equals("New")) {
			this.menuExampleView.setTextJLabel("Bạn đã click JmenuItem New");
		}else if(button.equals("Welcome")) {
			this.menuExampleView.setTextJLabel("Bạn đã click JmenuItem Welcome");
		}else if(button.equals("Help")) {
			this.menuExampleView.setTextJLabel("Bạn đã click Jmenu Help");
		}else if(button.equals("Exit")) {
			System.exit(0);
		}
	}

}