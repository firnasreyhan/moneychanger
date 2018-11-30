/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rey
 */
public class Stok extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    String kurs_lama = null;

    public Stok() {
        initComponents();
        load_table();
        kosong();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tb_ratusan = new javax.swing.JTextField();
        tb_puluhan = new javax.swing.JTextField();
        tb_satuan = new javax.swing.JTextField();
        bt_edit_stok = new javax.swing.JButton();
        lb_satuan = new javax.swing.JLabel();
        lb_puluhan = new javax.swing.JLabel();
        lb_ratusan = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tb_matauang = new javax.swing.JTextField();
        bt_clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stok = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stok Pecahan", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Ratusan");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Puluhan");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Satuan");

        tb_ratusan.setText("0");
        tb_ratusan.setName("tb_ratusan"); // NOI18N
        tb_ratusan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_ratusanKeyTyped(evt);
            }
        });

        tb_puluhan.setText("0");
        tb_puluhan.setName("tb_puluhan"); // NOI18N
        tb_puluhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_puluhanKeyTyped(evt);
            }
        });

        tb_satuan.setText("0");
        tb_satuan.setName("tb_satuan"); // NOI18N
        tb_satuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tb_satuanKeyTyped(evt);
            }
        });

        bt_edit_stok.setText("Edit");
        bt_edit_stok.setName("bt_edit_stok"); // NOI18N
        bt_edit_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit_stokActionPerformed(evt);
            }
        });

        lb_satuan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lb_satuan.setForeground(new java.awt.Color(255, 0, 0));
        lb_satuan.setText("Masukkan Angka!");
        lb_satuan.setName("validation_satuan"); // NOI18N

        lb_puluhan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lb_puluhan.setForeground(new java.awt.Color(255, 0, 0));
        lb_puluhan.setText("Masukkan Angka!");
        lb_puluhan.setName("validation_puluhan"); // NOI18N

        lb_ratusan.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lb_ratusan.setForeground(new java.awt.Color(255, 0, 0));
        lb_ratusan.setText("Masukkan Angka!");
        lb_ratusan.setName("validation_ratusan"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Mata Uang");

        tb_matauang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_matauang.setEnabled(false);

        bt_clear.setText("Clear");
        bt_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tb_puluhan, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_puluhan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_satuan))
                    .addComponent(tb_matauang, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_edit_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tb_ratusan, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_ratusan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tb_matauang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_satuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tb_puluhan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_puluhan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tb_ratusan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_ratusan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_edit_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tbl_stok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mata Uang", "Satuan", "Puluhan", "Satuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_stok.setName("tbl_stok"); // NOI18N
        tbl_stok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stokMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_stok);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ratusanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_ratusanKeyTyped
        // TODO add your handling code here:
        try {
            int i = Integer.parseInt(tb_ratusan.getText());
            lb_ratusan.setVisible(false);
        } catch (NumberFormatException e) {
            lb_ratusan.setVisible(true);
        }

    }//GEN-LAST:event_tb_ratusanKeyTyped

    private void tb_satuanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_satuanKeyTyped
        // TODO add your handling code here:
        try {
            int i = Integer.parseInt(tb_satuan.getText());
            lb_satuan.setVisible(false);
        } catch (NumberFormatException e) {
            lb_satuan.setVisible(true);
        }
    }//GEN-LAST:event_tb_satuanKeyTyped

    private void tb_puluhanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_puluhanKeyTyped
        // TODO add your handling code here:
        try {
            int i = Integer.parseInt(tb_puluhan.getText());
            lb_puluhan.setVisible(false);
        } catch (NumberFormatException e) {
            lb_puluhan.setVisible(true);
        }
    }//GEN-LAST:event_tb_puluhanKeyTyped

    private void tbl_stokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stokMouseClicked
        // TODO add your handling code here:
        // menampilkan data kedalam form pengisian:
        int baris = tbl_stok.rowAtPoint(evt.getPoint());
        String matauang = tbl_stok.getValueAt(baris, 0).toString();
        tb_matauang.setText(matauang);
        String satuan = tbl_stok.getValueAt(baris, 1).toString();
        tb_satuan.setText(satuan);
        String puluhan = tbl_stok.getValueAt(baris, 2).toString();
        tb_puluhan.setText(puluhan);
        String ratusan = tbl_stok.getValueAt(baris, 3).toString();
        tb_ratusan.setText(ratusan);
        kurs_lama = matauang;
    }//GEN-LAST:event_tbl_stokMouseClicked

    private void bt_edit_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit_stokActionPerformed
        // TODO add your handling code here:
        // Edit Data
        if (kurs_lama != null) {
            try {
                String sql = "UPDATE stok SET satuan = '" + tb_satuan.getText() + "', puluhan = '" + tb_puluhan.getText() + "', ratusan = '" + tb_ratusan.getText() + "' WHERE id_kurs = '" + tb_matauang.getText() + "'";
                java.sql.Connection conn = (Connection) config.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Perubahan data gagal" + e.getMessage());
            }
            load_table();
            kosong();
        } else {
            JOptionPane.showMessageDialog(null, "Perubahan data gagal");
        }
    }//GEN-LAST:event_bt_edit_stokActionPerformed

    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_clearActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_bt_clearActionPerformed

    private void kosong() {
        tb_matauang.setText("");
        tb_satuan.setText("0");
        tb_puluhan.setText("0");
        tb_ratusan.setText("0");
        kurs_lama = null;
    }

    private void load_table() {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mata Uang");
        model.addColumn("Satuan");
        model.addColumn("Puluhan");
        model.addColumn("Ratusan");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "SELECT * FROM stok";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            tbl_stok.setModel(model);
        } catch (Exception e) {
        }
    }

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
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stok().setVisible(true);
                lb_satuan.setVisible(false);
                lb_puluhan.setVisible(false);
                lb_ratusan.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_edit_stok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lb_puluhan;
    private static javax.swing.JLabel lb_ratusan;
    private static javax.swing.JLabel lb_satuan;
    private javax.swing.JTextField tb_matauang;
    private javax.swing.JTextField tb_puluhan;
    private javax.swing.JTextField tb_ratusan;
    private javax.swing.JTextField tb_satuan;
    private javax.swing.JTable tbl_stok;
    // End of variables declaration//GEN-END:variables
}
