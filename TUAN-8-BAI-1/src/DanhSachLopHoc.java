import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DanhSachLopHoc {
	ArrayList<LopHoc> dslop;
	LopHoc lh;
	
	public DanhSachLopHoc() {
		dslop = new ArrayList<LopHoc>();
		lh = new LopHoc();
	}
	
	public ArrayList<LopHoc> docTuBang(){
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "SELECT * FROM lophoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma = rs.getString(1);
				String lop = rs.getString(2);
				String gvcn = rs.getString(3);
				
				LopHoc s = new LopHoc(ma, lop, gvcn);
				dslop.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dslop;
	}
	
	public boolean create(LopHoc p) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO lophoc VALUES(?,?,?");
			stmt.setString(1, p.getMaLop());
			stmt.setString(2, p.getTenLop());
			stmt.setString(3, p.getGiaoVienCN());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean update(LopHoc p) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE lophoc" + "SET TenLop = ?," + "SET GVCN = ?" + "WHERE MaLop = ?");
			stmt.setString(1, p.getTenLop());
			stmt.setString(2, p.getGiaoVienCN());
			stmt.setString(3, p.getMaLop());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String mlop) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM lophoc WHERE = ?");
			stmt.setString(1, mlop);
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
