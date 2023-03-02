import java.awt.event.*;
import javax.swing.*;
public class JMenuPopupDemo extends JFrame implements ActionListener {
	JPopupMenu popup;
	JMenuItem mnuEditCut, mnuEditCopy, mnuEditPaste;    
	public JMenuPopupDemo()	{
		popup = new JPopupMenu();		
     		mnuEditCut = new JMenuItem("Cut", new ImageIcon("cut.gif")); 
     		mnuEditCopy = new JMenuItem("Copy", new ImageIcon("copy.gif")); 
		 mnuEditPaste = new JMenuItem("Paste", new ImageIcon("paste.gif")); 
			     	
     		popup.add(mnuEditCut);
     		popup.add(mnuEditCopy);
     		popup.add(mnuEditPaste);
     	
		mnuEditCut.addActionListener(this); 			
		mnuEditCopy.addActionListener(this);
		mnuEditPaste.addActionListener(this);

     		JPanel panel = new JPanel();
      		panel.setComponentPopupMenu(popup);
      		panel.addMouseListener( new MouseAdapter() {} ); 		
		add(panel);
		setLocation(200, 200);
		setSize(500, 400);
	  	setVisible(true);
	}
  
  	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		System.out.println(((JMenuItem)o).getText() + " selected.");
	}
   	public static void main(String[] args)   	{  
      		new JMenuPopupDemo();      
   	}
}
