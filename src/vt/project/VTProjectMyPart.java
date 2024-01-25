package vt.project;

import javax.swing.JFrame;

/**
 *
 * @author Sevda Karahan
 */
public class VTProjectMyPart {

    public static void main(String[] args) {
        AdminPanelForm APF = new AdminPanelForm();
        APF.setVisible(true);
        APF.pack();
        APF.setLocationRelativeTo(null);
        APF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
