package vt.project.mypart;
import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class BasvurularimPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable basvurularTable;

    private Object[][] getBasvurular() {
        Object[][] data = null;

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {

            String query = "SELECT b.basvuru_id, i.ilan_ismi, c.company_name, c.konum, bs.sonuc_durumu " +
                    "FROM basvurular b " +
                    "JOIN ilanlar i ON b.ilan_id = i.ilan_id " +
                    "JOIN company c ON i.company_id = c.company_id " +
                    "JOIN basvuru_sonuclari bs ON b.basvuru_id = bs.basvuru_id " +
                    "WHERE b.basvuran_id = ?";

            int userId = Session.getLoggedInUser().getUserId();

            try (PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                ps.setInt(1, userId);

                try (ResultSet rs = ps.executeQuery()) {
                    rs.last();
                    int rowCount = rs.getRow();
                    rs.beforeFirst();

                    data = new Object[rowCount][6];

                    int index = 0;
                    while (rs.next()) {
                        data[index][0] = rs.getInt("basvuru_id");
                        data[index][1] = rs.getString("ilan_ismi");
                        data[index][2] = rs.getString("company_name");
                        data[index][3] = rs.getString("konum");
                        data[index][4] = rs.getString("sonuc_durumu");

                        index++;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BasvurularimPanel basvurularimPanel = new BasvurularimPanel();
            basvurularimPanel.setVisible(true);
        });
    }

    public BasvurularimPanel() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(BasvurularimPanel.class.getResource("/images/yildiz.png")));
    	setResizable(false);
        setTitle("Başvurularım");
        setSize(672, 478);
        setBounds(600,200,672,478);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Başvuruları çek ve tabloya ekle
        Object[][] data = getBasvurular();
        String[] columnNames = {"Başvuru ID", "İlan İsmi", "Şirket Adı", "Şirket Yeri", "Başvuru Durumu", "Başvuru Sil"};

        // Use a custom table model to make the last column editable
        CustomTableModel model = new CustomTableModel(data, columnNames);
        basvurularTable = new JTable(model);

        // Set the custom renderer and editor for the "Sil" button column
        basvurularTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer(model));
        basvurularTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(model));

        // Set column names as table header
        basvurularTable.getTableHeader().setReorderingAllowed(false);
        basvurularTable.getTableHeader().setResizingAllowed(false);
        basvurularTable.getTableHeader().getColumnModel().getColumn(0).setHeaderValue(columnNames[0]);
        basvurularTable.getTableHeader().getColumnModel().getColumn(1).setHeaderValue(columnNames[1]);
        basvurularTable.getTableHeader().getColumnModel().getColumn(2).setHeaderValue(columnNames[2]);
        basvurularTable.getTableHeader().getColumnModel().getColumn(3).setHeaderValue(columnNames[3]);
        basvurularTable.getTableHeader().getColumnModel().getColumn(4).setHeaderValue(columnNames[4]);
        basvurularTable.getTableHeader().getColumnModel().getColumn(5).setHeaderValue(columnNames[5]);


        // Tabloyu bir JScrollPane içine yerleştir
        JScrollPane scrollPane = new JScrollPane(basvurularTable);

        // ScrollPane'i frame'e ekle
        getContentPane().add(scrollPane, BorderLayout.NORTH);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenuItem profilField = new JMenuItem("Profil");
        profilField.setBackground(UIManager.getColor("Slider.shadow"));
        profilField.setIcon(new ImageIcon(BasvurularimPanel.class.getResource("/images/profile.png")));
        menuBar.add(profilField);
        BasvurularimPanel current = this;
		profilField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ProfilDeneme profileWindow = new ProfilDeneme();
                profileWindow.getFrame().setVisible(true);
                current.setVisible(false);
            }
		});
        
        JMenuItem homeField = new JMenuItem("Home");
        homeField.setBackground(UIManager.getColor("Slider.shadow"));
        homeField.setIcon(new ImageIcon(BasvurularimPanel.class.getResource("/images/icons8-home-48.png")));
        menuBar.add(homeField);
        homeField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Menu homeArayuz = new Menu(null);
				homeArayuz.getFrame().setVisible(true);
                current.setVisible(false);
            }
		});
    }

 // Custom table model to make the last column editable
    private static class CustomTableModel extends AbstractTableModel {
        private final Object[][] data;
        private final String[] columnNames;
        private final boolean[] buttonPressed;

        public CustomTableModel(Object[][] data, String[] columnNames) {
            this.data = data;
            this.columnNames = columnNames;
            this.buttonPressed = new boolean[data.length];
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 5;
        }

        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            data[rowIndex][columnIndex] = value;
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        public boolean[] getButtonPressed() {
            return buttonPressed;
        }
    }

 // Custom cell renderer and editor for the "Sil" button column
    private class ButtonRenderer extends JButton implements TableCellRenderer {
        private final CustomTableModel model;

        public ButtonRenderer(CustomTableModel model) {
            this.model = model;
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }

            if (model.getButtonPressed()[row]) {
                setText("Silindi");
                setEnabled(false);
            } else {
                setText("Sil");
                setEnabled(true);
            }

            return this;
        }
    }

 // Custom cell renderer and editor for the "Sil" button column
    private class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
        private JButton button;
        private int clickedRow;
        private final CustomTableModel model;

        public ButtonEditor(CustomTableModel model) {
            this.model = model;
            this.button = new JButton();
            this.button.addActionListener(e -> {
                // Handle button click action here
                if (!model.getButtonPressed()[clickedRow]) {
                    // Perform deletion logic
                    System.out.println("Deleted row at index: " + clickedRow);
                    
                    int basvuruID = (int) model.getValueAt(clickedRow, 0); // Get the basvuru_id
                    // Delete from Basvuru_sonuclari table
                    deleteFromBasvuruSonuclari(basvuruID);

                    // Delete from Basvurular table
                    deleteFromBasvurular(basvuruID);

                   

                 // Update the button text and state
                    model.getButtonPressed()[clickedRow] = true;
                    model.fireTableCellUpdated(clickedRow, 5); // Update the cell to trigger repaint

                    // Inform the table that the cell value has changed
                    fireEditingStopped();
                }
            });
        }
        private void deleteFromBasvurular(int basvuruID) {
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
                String query = "DELETE FROM Basvurular WHERE basvuru_id = ?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setInt(1, basvuruID);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void deleteFromBasvuruSonuclari(int basvuruID) {
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbproje", "postgres", "12345")) {
                String query = "DELETE FROM Basvuru_sonuclari WHERE basvuru_id = ?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setInt(1, basvuruID);
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Object getCellEditorValue() {
            return button;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            clickedRow = row;
            button.setText("Sil");
            button.setEnabled(true);
            return button;
        }
    }
}