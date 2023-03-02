package Test;

import javax.swing.UIManager;

import view.*;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ThucDonView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
