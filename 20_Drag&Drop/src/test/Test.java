package test;

import javax.swing.UIManager;

import view.*;


public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ViDu4();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
