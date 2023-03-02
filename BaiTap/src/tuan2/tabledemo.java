package tuan2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class tabledemo extends JFrame implements ActionListener{

	JButton btn1, btn2, btn3;
	JTextField t1, t2;
	DefaultTableModel model;
	JTable jt;
	
	public tabledemo() {
		super("^_^");
		String[] cols = {"Ho Sinh Vien", "Ten Sinh Vien"};
		model = new DefaultTableModel(cols,0);
		jt = new JTable(model);
		JScrollPane pane = new JScrollPane(jt);
		JPanel p1 = new JPanel();
		p1.add(new JLabel("Ho"));
		t1 = new JTextField(20);
		p1.add(t1);
		p1.add(new JLabel("Ten"));
		t2 = new JTextField(20);
		p1.add(t2);
		
		JPanel p2 = new JPanel();
		btn1 = new JButton("Them");
		btn2 = new JButton("Xoa");
		btn3 = new JButton("Thoat");
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		
		JPanel pT, pB;
		pT = new JPanel();
		this.add(p1, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		pack();
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btn1)) {
			if( t1.getText().equals("") || t2.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Yeu cau nhap du lieu");
			else {
				Object[] obj = new Object[2];
				obj[0] = t1.getText();
				obj[1] = t2.getText();
				model.addRow(obj);
				this.t1.setText("");
				this.t2.setText("");
			}
		}
		else if (o.equals(btn2)) {
			if (jt.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Chon dong can xoa");
			else {
				if (JOptionPane.showConfirmDialog(this, "Dong Y?", "Canh Bao!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					model.removeRow(jt.getSelectedRow());
			}
		}
		else if (o.equals(btn3)) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new tabledemo();
	}
}
