package test;

import gui.*;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class Test {
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        try {
	        	UIManager.setLookAndFeel(new FlatMacLightLaf());
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	        new LoginFrame().setVisible(true);;
	      }
	    });
	  }
}
