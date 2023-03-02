import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class JMenuDemo extends JFrame {
	JMenuBar mnubar;
    	JMenu mnuFile, mnuEdit, mnuHelp;
    	JMenuItem mnuFileNew, mnuFileOpen, mnuFileSave, mnuFileSaveAs, mnuFileExit;
    	JMenuItem mnuEditCut, mnuEditCopy, mnuEditPaste, mnuEditOption;
	public JMenuDemo()	{
		mnubar = new JMenuBar();
		setJMenuBar(mnubar);

		mnuFile = new JMenu("File"); mnubar.add(mnuFile);		
		mnuEdit = new JMenu("Edit"); mnubar.add(mnuEdit);
		mnuHelp = new JMenu("Help"); mnubar.add(mnuHelp);
		
		// menu File		
			mnuFileNew = new JMenuItem("New");				mnuFile.add(mnuFileNew);
     		mnuFileOpen = new JMenuItem("Open");    		mnuFile.add(mnuFileOpen);
     		mnuFileSave = new JMenuItem("Save");    		mnuFile.add(mnuFileSave);
     		mnuFileSaveAs = new JMenuItem("Save As...");    mnuFile.add(mnuFileSaveAs);
     		mnuFile.addSeparator();
     		mnuFileExit = new JMenuItem("Exit", 'x');    	mnuFile.add(mnuFileExit);
     		
     		mnuEditCut 		= 	new JMenuItem("Cut", new ImageIcon("cut.gif"));
     		mnuEditCopy 	= 	new JMenuItem("Copy", new ImageIcon("copy.gif"));
     		mnuEditPaste 	= 	new JMenuItem("Paste", new ImageIcon("paste.gif"));
     		mnuEditOption 	=	new JMenu("Options");     	
     		mnuEdit.add(mnuEditCut);
     		mnuEdit.add(mnuEditCopy);
     		mnuEdit.add(mnuEditPaste);
     		mnuEdit.addSeparator();
    		mnuEdit.add(mnuEditOption);     	
     	    	//…	   		
	   	setLocation(200, 200);
		setSize(500, 400);
	  	setVisible(true);
	  	
	}  
   	public static void main(String[] args)  	{  
      		new JMenuDemo();      
   	}
}
