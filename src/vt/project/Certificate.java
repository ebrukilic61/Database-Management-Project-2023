package vt.project;

import java.io.IOException;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Certificate {
    /**
     * @wbp.parser.entryPoint
     */
    public void insertUpdateDeleteCertificate(char operation, String sertifika_id, String company_id, String sertifika_adi, String sertifika_tarihi) throws SQLException, IOException {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps;
        String query;
        
        if(operation == 'i') { // i for insert
            
            query = "INSERT INTO sertifika_programlari(company_id, sertifika_adi, sertifika_tarihi) VALUES(?, ?, ?)";
            JOptionPane.showMessageDialog(null, "sertifika_sirket_id_kontrol_trigger tetiklendi.");
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(company_id));
            ps.setString(2, sertifika_adi);
            java.sql.Date date = java.sql.Date.valueOf(sertifika_tarihi);
            ps.setDate(3, date);
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Bu Şirkete Ait Yeni Bir Sertifika Programı Eklendi!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Şirket ID kayıtlı değil!\nKayıtlı bir şirket ID ile sertifika programı ekleyebilirsiniz.!");
            }
        }
        
        if(operation == 'u') { // u for update
            query = "UPDATE sertifika_programlari SET company_id = ?, sertifika_adi = ?, sertifika_tarihi = ? WHERE sertifika_id = ?";
            
            // Set values using PreparedStatement
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(company_id));
            ps.setString(2, sertifika_adi);
            java.sql.Date date = java.sql.Date.valueOf(sertifika_tarihi);
            ps.setDate(3, date);
            ps.setInt(4, Integer.parseInt(sertifika_id));
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sertifika Programı Bilgisi Güncellendi!");
            }
        }
        
        if(operation == 'd') { // d for delete
            query = "DELETE FROM sertifika_programlari WHERE sertifika_id = ?";
            
            // Set values using PreparedStatement
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(sertifika_id));
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sertifika Programı Silindi!");
            }
        }
    }
    
    /**
     * @wbp.parser.entryPoint
     */
    public void fillCertificateJTable(JTable table, String valueToSearch) throws SQLException, IOException {
        Connection conn = MyConnection.getConnection();
        PreparedStatement ps;
        String query = "SELECT * FROM sertifika_programlari WHERE sertifika_id::text || company_id::text || sertifika_adi || sertifika_tarihi ILIKE ?";
        
        ps = conn.prepareStatement(query);
        ps.setString(1, "%" + valueToSearch + "%");
        
        ResultSet rs = ps.executeQuery();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        Object[] row;
        
        while(rs.next()){
            row = new Object[4];
            row[0] = rs.getInt(1);
            row[1] = rs.getInt(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            
            model.addRow(row);
        }
    }
}
