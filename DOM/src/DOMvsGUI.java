import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

public class DOMvsGUI extends JFrame implements ActionListener, MouseListener {
	private JTextField txtCountry, txtCapital, txtPop;
	private JButton badd, bclear, bupdate, bdelete, bsearch;
	private JTable table;
	private DefaultTableModel tableModel;
//	private CountryManager loC;
//	private Database database;

	public DOMvsGUI() {
		
//		loC = new CountryManager();
//		database = new Database();
		
		setTitle("DOM");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		createGui();	
		
//		try {
//			loadDatabase();
//		} catch (Exception e) {
//		}
//	}

//	private void loadDatabase() throws Exception {
//		loC = null;
//		loC = (CountryManager)database.readFile("data.dat");
//		for (Country c : loC.getLoC()) {
//			String[] row = { c.getCountry(), c.getCapital(), c.getPopulation()+"", c.isDemocracy()+""};
//			tableModel.addRow(row);
//		}
	}

	private void createGui() {
		Container con = getContentPane();
		JPanel northP = new JPanel();
		JLabel lblTt = new JLabel("");
		lblTt.setFont(new Font("Ariel", Font.BOLD, 24));
		northP.add(lblTt);
		con.add(northP, BorderLayout.NORTH);

		JPanel centerP = new JPanel();
		centerP.setLayout(new BorderLayout());
		Box boxConten = Box.createVerticalBox();
		Box b1, b2, b3, b4;
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();

		
		
		JLabel lblCountry = new JLabel("Enter country: ");
		txtCountry = new JTextField();
		b1.add(lblCountry);
		b1.add(txtCountry);
		
		JLabel lblCapital = new JLabel("Enter capital: ");
		txtCapital= new JTextField();
		b2.add(lblCapital);
		b2.add(txtCapital);
		
		JLabel lblPop = new JLabel("Enter population: ");
		txtPop= new JTextField();
		b3.add(lblPop);
		b3.add(txtPop);

		JLabel lblDemocracy= new JLabel("Select democracy: ");
		b4.add(lblDemocracy);
		b4.add(Box.createHorizontalStrut(10));
		JComboBox chosePB = new JComboBox();
		chosePB.addItem("true");
		chosePB.addItem("false");
		b4.add(chosePB);
		

//		boxConten.add(b1);		boxConten.add(Box.createVerticalStrut(10));
//		boxConten.add(b2);		boxConten.add(Box.createVerticalStrut(10));
//		boxConten.add(b3);		boxConten.add(Box.createVerticalStrut(10));
//		boxConten.add(b4);		boxConten.add(Box.createVerticalStrut(10));

		String[] col = { "ID", "Name", "Manufacture", "Description", "a"};
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		TableColumn pbCol = table.getColumnModel().getColumn(3);
		JCheckBox check = new JCheckBox();
		pbCol.setCellEditor(new DefaultCellEditor(check));

		centerP.add(boxConten, BorderLayout.NORTH);
		centerP.add(new JScrollPane(table), BorderLayout.CENTER);
		con.add(centerP, BorderLayout.CENTER);

		JSplitPane southP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel eastSP = new JPanel();
		eastSP.setBorder(BorderFactory.createLoweredBevelBorder());

		eastSP.add(badd = new JButton("Add"));
		eastSP.add(bclear = new JButton("Clear"));
		eastSP.add(bupdate= new JButton("Update"));
		eastSP.add(bdelete = new JButton("Delete"));
		eastSP.add(bsearch = new JButton("Search"));
		southP.add(eastSP);

		con.add(southP, BorderLayout.SOUTH);

		badd.addActionListener(this);
		bclear.addActionListener(this);
		bupdate.addActionListener(this);
		bdelete.addActionListener(this);
		bsearch.addActionListener(this);
		table.addMouseListener(this);
		
		txtCountry.setEditable(false);
		txtCapital.setEditable(false);
		txtPop.setEditable(false);
	}

	public static void main(String[] args) {
		new DOMvsGUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(bclear)) {
			clear();
		} else if (o.equals(bupdate)) {
			if (txtCountry.getText().equals(""))
				focus(txtCountry);
			else if (txtCapital.getText().equals(""))
				focus(txtCapital);
			else if (txtPop.getText().equals(""))
				focus(txtPop);
			else {
				try {
					luu();
				} catch (Exception ex) {
					// TODO: handle exception
				}
				clear();
			}
		} else if (o.equals(bdelete)) {
			try {
				int qes = JOptionPane.showConfirmDialog(this, "Xác nhận xoá?", "qs", JOptionPane.YES_NO_OPTION);
				if (qes == JOptionPane.YES_OPTION) {
//					loC.deleteVT(table.getSelectedRow());
					tableModel.removeRow(table.getSelectedRow());
//					loC.saveFile("Nhanvien.dat",ds);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Xoá?");
			}
		} else if (o.equals(badd)) {
			if (badd.getText().equals("Add")) {
				txtCountry.setEnabled(true);
				txtCapital.setEnabled(true);
				txtPop.setEnabled(true);
				txtCountry.requestFocus();
				bdelete.setEnabled(false);
				badd.setText("Cancel");
			} else {
				bdelete.setEnabled(true);
				badd.setText("Add");
				clear();
			}
		} 
	}

	private void clear() {
		txtCountry.setText("");
		txtCapital.setText("");
		txtPop.setText("");

	}

	private void luu() throws Exception {
		String manv = txtCountry.getText();
		String ho = txtCapital.getText();
		String ten = txtPop.getText();
		String democracy = "";
		
//		NhanVien nv = new NhanVien(manv, ho, ten, phongBan);
//		if (ds.addNV(nv)) {
//			JOptionPane.showMessageDialog(this, "Lưu thành công");
//			String[] row = { manv, ho, ten, phongBan};
//			tableModel.addRow(row);
//			db.saveFile("Nhanvien.dat", ds);
//		} else {
//			JOptionPane.showMessageDialog(this, "Id tồn tại");
//		}
		this.badd.setText("Add");
		bdelete.setEnabled(true);
	}

	private boolean isInt(JTextField txt) {
		try {
			Integer.parseInt(txt.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isdouble(JTextField txt) {
		try {
			Double.parseDouble(txt.getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void focus(JTextField txt) {
		JOptionPane.showMessageDialog(null, "?");
		txt.selectAll();
		txt.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

