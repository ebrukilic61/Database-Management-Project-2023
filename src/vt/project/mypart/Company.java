package vt.project.mypart;

/**
 *
 * @author Sevda Karahan
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Company {
    public void insertUpdateDeleteCompany(char operation, String company_id, String company_name, String konum, String iletisim) throws SQLException, IOException {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps;
        String query;
        
        if(operation == 'i') { // i for insert
            query = "INSERT INTO company(company_id, company_name, konum, iletisim) VALUES(?, ?, ?, ?)";
            JOptionPane.showMessageDialog(null, "sirket_id_kontrol_trigger tetiklendi.");
            // Set values using PreparedStatement
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(company_id));
            ps.setString(2, company_name);
            ps.setString(3, konum);
            ps.setString(4, iletisim);
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Yeni Şirket Eklendi!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Şirket ID eşsiz olmalıdır!");
            }
        }
        
        if(operation == 'u') { // u for update
            query = "UPDATE company SET company_name = ?, konum = ?, iletisim = ? WHERE company_id = ?";
            
            // Set values using PreparedStatement
            ps = conn.prepareStatement(query);
            ps.setString(1, company_name);
            ps.setString(2, konum);
            ps.setString(3, iletisim);
            ps.setInt(4, Integer.parseInt(company_id));
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Şirket Bilgisi Güncellendi!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Hata!");
            }
        }
        
        if(operation == 'd') { // d for delete
            query = "DELETE FROM company WHERE company_id = ?";
            
            // Set values using PreparedStatement
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(company_id));
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Şirket Silindi!");
            }
        }
    }
    
    public void fillCompanyJTable(JTable table, String valueToSearch) throws SQLException, IOException {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps;
        String query = "SELECT * FROM company WHERE company_id::text || company_name || konum || iletisim ILIKE ?";
        
        ps = conn.prepareStatement(query);
        ps.setString(1, "%" + valueToSearch + "%");
        
        ResultSet rs = ps.executeQuery();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        Object[] row;
        
        while(rs.next()){
            row = new Object[4];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            
            model.addRow(row);
        }
    }
}
