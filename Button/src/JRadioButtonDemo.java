import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JRadioButtonDemo extends JFrame  {
    JRadioButton radUnder, radGra, radPost, radDoc;	
    public JRadioButtonDemo()    {
	super("JRadioButton Demo");
     	setLayout(new GridLayout(6,1));
     	
     radUnder = new JRadioButton("Undergraduate");
	radGra = new JRadioButton("Graduate");
	radPost = new JRadioButton("Post Graduate");
	radDoc = new JRadioButton("Doctorate");	

	add(new JLabel("What's your primary qualification?" ));
	add(radUnder);
	add(radGra);
	add(radPost);
	add(radDoc);
	ButtonGroup group = new ButtonGroup();
    group.add (radUnder);
    group.add (radGra);
    group.add (radPost);
    group.add (radDoc);		
	setLocation(400, 300);
	setSize(250, 250);
	setVisible(true);
 } 	
 public static void main(String args[])   {
	new JRadioButtonDemo ();		
 }
} 
