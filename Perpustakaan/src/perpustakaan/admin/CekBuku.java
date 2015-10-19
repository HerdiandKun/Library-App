package perpustakaan.admin;
import app.data.ConnectionUtilities;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DEA
 */
public class CekBuku extends javax.swing.JFrame {
Connection con;
Statement st;
ResultSet rs;
private Object[][] dataTable = null;
private String[] header = {"ID Buku","Judul","Author","Penerbit","Rak","Stock"};
    /** Creates new form CariBuku */
   public CekBuku() {
        initComponents();
        open_db();
    }
private void open_db()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
         rs = st.executeQuery("select * from buku");
         baca_data();
        }catch(Exception e){
        System.out.println("Error : "+e);
        }
    }
private void baca_data(){
        try{
                ResultSetMetaData meta = rs.getMetaData();
                int col = meta.getColumnCount();
                int baris = 0;
                while(rs.next()) {
                    baris = rs.getRow();
                }
                dataTable = new Object[baris][col];
                int x = 0;
                rs.beforeFirst();
                while(rs.next()) {
                    dataTable[x][0] = rs.getString(1);
                    dataTable[x][1] = rs.getString(2);
                    dataTable[x][2] = rs.getString(3);
                    dataTable[x][3] = rs.getString(4);
                    dataTable[x][4] = rs.getString(5);
                    dataTable[x][5] = rs.getString(6);
                    x++;
                }
                jTable1.setModel(new DefaultTableModel(dataTable,header));
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form CekBuku
     */
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblcari = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Buku", "Judul Buku", "Pengarang", "Penerbit", "Rak", "Stock"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 630, 88));

        lblcari.setFont(new java.awt.Font("Comic Sans MS", 0, 36));
        lblcari.setForeground(new java.awt.Color(51, 153, 255));
        lblcari.setText("IDBuku");
        getContentPane().add(lblcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        jButton1.setFont(new java.awt.Font("Consolas", 1, 24));
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("CARI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 230, 110, 70));

        txtCari.setFont(new java.awt.Font("Consolas", 1, 36));
        txtCari.setForeground(new java.awt.Color(0, 153, 204));
        txtCari.setBorder(null);
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 510, 70));

        jComboBox1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 153, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IDBuku", "Judul", "Author", "Penerbit" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 410, 70));

        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 740, -1, -1));

        jButton3.setFont(new java.awt.Font("Consolas", 1, 18));
        jButton3.setForeground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Cetak Laporan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, -1, -1));

        jButton4.setFont(new java.awt.Font("Consolas", 1, 24));
        jButton4.setForeground(new java.awt.Color(0, 102, 204));
        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/master_pencarian_buku_admin.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
lblcari.setText(""+jComboBox1.getSelectedItem());// TODO add your handling code here:
}//GEN-LAST:event_jComboBox1ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 if(lblcari.getText().equalsIgnoreCase("Author")){
try{
    st = con.createStatement();
    rs = st.executeQuery("select * from buku where Author = '"+txtCari.getText()+"'");
    baca_data();
}catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
}
    else if(lblcari.getText().equalsIgnoreCase("Judul")){
try{
    st = con.createStatement();
    rs = st.executeQuery("select * from buku where Judul = '"+txtCari.getText()+"'");
    baca_data();
}catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
    }
    else if(lblcari.getText().equalsIgnoreCase("Penerbit")){
try{
    st = con.createStatement();
    rs = st.executeQuery("select * from buku where Penerbit = '"+txtCari.getText()+"'");
    baca_data();
}catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }// TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed
else if(lblcari.getText().equalsIgnoreCase("IDBuku")){
try{
    st = con.createStatement();
    rs = st.executeQuery("select * from buku where IDBuku = '"+txtCari.getText()+"'");
    baca_data();
}catch(SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
    }
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
new halamanutama().setVisible(true);
dispose();// TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try{
        String stream = "H:/Report Perpustakaan/buku.jrxml";
        
        JasperReport jasperReport = JasperCompileManager.compileReport(stream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, ConnectionUtilities.getConnection());
        JRViewer aViewer = new JRViewer(jasperPrint);
        
        JDialog viewer = new JDialog();
        viewer.setTitle(".: Jasper Report :.");
        viewer.setAlwaysOnTop(true);
        viewer.getContentPane().add(aViewer);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        viewer.setBounds(0,0,screenSize.width, screenSize.height);
        viewer.setVisible(true);
        
    }catch(JRException ex){
        Logger.getLogger(ManipulasiAnggota.class.getName()).log(Level.SEVERE, null, ex);
    }// TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
new halamanutama().setVisible(true);
dispose();// TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtCariActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CekBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CekBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CekBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CekBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CekBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblcari;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
