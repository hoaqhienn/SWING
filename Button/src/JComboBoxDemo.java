import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JComboBoxDemo extends JFrame 
	                          implements ActionListener {   
   JComboBox faceCombo;
   JLabel label;
   public JComboBoxDemo()   {  
      	setTitle("JComboBox Demo");      
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, 12));
        add(label, BorderLayout.CENTER);

        // make a combo box
        faceCombo = new JComboBox();        
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
   	faceCombo.addItem("Monospaced");
    faceCombo.addItem("Dialog");
    faceCombo.addItem("DialogInput");
    faceCombo.addActionListener(this);

add(faceCombo, BorderLayout.SOUTH);      

    setSize(300, 200);     
    setVisible(true);
}

public void actionPerformed (ActionEvent e)   {
String fontName = (String)faceCombo.getSelectedItem();
	label.setFont (new Font(fontName, Font.PLAIN, 12));         
}
	
public static void main(String[] args)   {  
new JComboBoxDemo();      
}
}
