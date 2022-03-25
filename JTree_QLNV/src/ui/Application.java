package ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import entity.*;
public class Application extends JFrame{
	
	private DefaultMutableTreeNode root;
	private JTree tree;
	private ArrayList<PhongBan> dspb;
	private ArrayList<NhanVien> dsnv;
	
	
	public Application(ArrayList<PhongBan> dspb) {
		
		
		setTitle("@hoaqhienn");
//		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(900,600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.dspb = dspb;
		this.dsnv = new ArrayList<NhanVien>();
		
		root = new DefaultMutableTreeNode("Danh Sách Phòng Ban");
		tree = new JTree(root);
		add(tree);
		tree.setShowsRootHandles(true);
		
		int soPhongBan = dspb.size();
		
		for(int i=0; i<soPhongBan; i++) {
			PhongBan pb = dspb.get(i);
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(pb);
			root.add(node);
		}
		
		add(new JScrollPane(tree), BorderLayout.CENTER);
		
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					DefaultMutableTreeNode x = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					if(x != null) {
						Object gt = x.getUserObject();
						if(gt instanceof PhongBan) {
//							JOptionPane.showMessageDialog(rootPane, "???");
							
							PhongBan pb  = (PhongBan) x.getUserObject();
							ArrayList<NhanVien> dsnv = pb.getDsnv();
							
							frmNhanvien gd = new frmNhanvien(dsnv, pb.toString());
							gd.show();
								
						}
					}
				}
				
			}
		});
	}

	public static void main(String[] args) {
	CongTy ct = new CongTy();
	
	PhongBan tc, kt, ns, dn, bh;
	ct.addPhongBan(tc = new PhongBan("TC","Phòng Tổ Chức"));
	ct.addPhongBan(kt = new PhongBan("KT", "Phòng Kỹ Thuật"));
	ct.addPhongBan(ns = new PhongBan("NS", "Phòng Nhân Sự"));
	ct.addPhongBan(dn = new PhongBan("DN", "Phòng Đối Ngoại"));
	ct.addPhongBan(bh = new PhongBan("BH", "Phòng Bán Hàng"));
	
	tc.themMoiNhanVien("01", "Le", "Hoang Hien", true, 20, 1000);
	tc.themMoiNhanVien("02", "Le", "Hoang Hien", true, 20, 3000);
	tc.themMoiNhanVien("03", "Le", "Hoang Hien", true, 20, 5000);
	kt.themMoiNhanVien("04", "Le", "Hoang Hien", true, 20, 2000);
	kt.themMoiNhanVien("05", "Le", "Hoang Hien", true, 20, 4000);
	
	ArrayList<PhongBan> dspb = ct.getDspb();
	new Application(dspb).setVisible(true);
	}
}
