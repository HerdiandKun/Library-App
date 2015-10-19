package perpustakaan.admin;

import app.data.bukumanager;
import app.data.pinjamManager;
import app.data.pinjam;
import app.data.Buku;
import app.data.ConnectionUtilities;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DEA
 */
public class Peminjaman extends javax.swing.JFrame {
    Connection conn;
      String url="jdbc:mysql://localhost:3306/",db="Perpustakaan",driver ="com.mysql.jdbc.Driver";
      private Statement stat;
      private ResultSet res;
      DefaultTableModel tabModel;
      Integer sisa;
    /**
     * Creates new form Peminjaman
     */
    Date dt = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    com.mysql.jdbc.PreparedStatement pst;
    
    public Peminjaman() {
        initComponents();
        
        pinjamManager pjm = new pinjamManager();
        pinjam p = new pinjam();
        
        GregorianCalendar now = new GregorianCalendar();
        
        Calendar cal = Calendar.getInstance();
        txtTglPinjam.setText((cal.get(Calendar.DATE)) + "-"+(cal.get(Calendar.MONTH)+1 +"-"+cal.get(Calendar.YEAR)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtIDBuku = new javax.swing.JTextField();
        txtTglPinjam = new javax.swing.JTextField();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTglJatuhTempo = new javax.swing.JTextField();
        btnCek = new javax.swing.JButton();
        bntPinjam = new javax.swing.JButton();
        jmlHari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtStock = new javax.swing.JTextField();
        btnStock = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jLabel1.setText("jLabel1");

        jLabel3.setText("jLabel3");

        jTextField4.setText("jTextField4");

        jLabel5.setText("jLabel5");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNim.setBorder(null);
        getContentPane().add(txtNim, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 290, 30));

        txtIDBuku.setBorder(null);
        getContentPane().add(txtIDBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 290, 30));

        txtTglPinjam.setForeground(new java.awt.Color(0, 102, 204));
        txtTglPinjam.setBorder(null);
        getContentPane().add(txtTglPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, 290, 20));
        getContentPane().add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 961, -1, -1));

        jLabel8.setText("Data Saved");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1639, 961, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1397, 11, 220, -1));

        txtTglJatuhTempo.setBorder(null);
        getContentPane().add(txtTglJatuhTempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 290, 20));

        btnCek.setFont(new java.awt.Font("Consolas", 1, 18));
        btnCek.setForeground(new java.awt.Color(0, 204, 255));
        btnCek.setText("Cek");
        btnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekActionPerformed(evt);
            }
        });
        getContentPane().add(btnCek, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, -1, -1));

        bntPinjam.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        bntPinjam.setForeground(new java.awt.Color(0, 204, 255));
        bntPinjam.setText("Pinjam");
        bntPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPinjamActionPerformed(evt);
            }
        });
        getContentPane().add(bntPinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, -1, -1));
        getContentPane().add(jmlHari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1345, 906, 39, -1));

        jButton1.setFont(new java.awt.Font("Consolas", 1, 18));
        jButton1.setForeground(new java.awt.Color(51, 204, 255));
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 480, -1, -1));

        txtStock.setBorder(null);
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 290, 20));

        btnStock.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnStock.setForeground(new java.awt.Color(0, 153, 204));
        btnStock.setText("Cek Stock");
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });
        getContentPane().add(btnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 250, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/peminjaman_buku_baru.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekActionPerformed
    Date h1;
      
    Long hari = Long.valueOf("5");
    Long selang=null;
    try{
    h1 = df.parse(txtTglPinjam.getText());
    selang = h1.getTime() + (hari *24*60*60*1000) ;
    Date h2 = new Date(selang);
    txtTglJatuhTempo.setText(String.valueOf(df.format(h2)));
        }catch (ParseException e){
        e.printStackTrace();
    }// TODO add your handling code here:
}//GEN-LAST:event_btnCekActionPerformed

private void bntPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPinjamActionPerformed
sisa=Integer.valueOf(txtStock.getText())-1;
    
    if((txtNim.getText().equals("")) || (txtIDBuku.getText().equals("")) || (txtTglPinjam.getText().equals(""))){
    JOptionPane.showMessageDialog(this, "Data Gagal Disimpan","Informasi", JOptionPane.INFORMATION_MESSAGE);
    }else{
    pinjamManager pjm = new pinjamManager();
    pinjam p = new pinjam();
    
    p.setNim(txtNim.getText());
    p.setIDBuku(txtIDBuku.getText());
    p.setTglPinjam(txtTglPinjam.getText());
    p.setTglJatuhTempo(txtTglJatuhTempo.getText());
   
    txtNim.requestFocus();
    txtIDBuku.requestFocus();
    pjm.Insert(p);
    String kode="update buku set stock='"+sisa+"' where IDBuku='"+txtIDBuku.getText()+"'"; 
    int edit;
            try {
                edit = stat.executeUpdate(kode);
            } catch (SQLException ex) {
                Logger.getLogger(Peminjaman.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan","Informasi", JOptionPane.INFORMATION_MESSAGE);
        txtIDBuku.setText("");
        txtNim.setText("");
        txtTglPinjam.setText("");
        txtTglJatuhTempo.setText("");
        txtStock.setText("");
    
    }
// TODO add your handling code here:
}//GEN-LAST:event_bntPinjamActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
new halamanutama().setVisible(true);
    dispose();// TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtStockActionPerformed

private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
ConnectionUtilities.getConnection();
    try{
        conn=DriverManager.getConnection(url+db,"root","");
        stat=conn.createStatement();
        res=stat.executeQuery("select * from buku where IDBuku='"+txtIDBuku.getText()+"'");
        ResultSetMetaData meta=res.getMetaData();
        res.beforeFirst();
        if(res.next()){
            txtStock.setText(res.getString("Stock"));
        }
        else {
           JOptionPane.showMessageDialog(this,"Gagal Ditemukan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(this,"ERORR DISINI "+e.getMessage(),"Informasi",JOptionPane.INFORMATION_MESSAGE);
    
    }// TODO add your handling code here:
}//GEN-LAST:event_btnStockActionPerformed

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
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntPinjam;
    private javax.swing.JButton btnCek;
    private javax.swing.JButton btnStock;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jmlHari;
    private javax.swing.JTextField txtIDBuku;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTglJatuhTempo;
    private javax.swing.JTextField txtTglPinjam;
    // End of variables declaration//GEN-END:variables
}