/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package appkasir;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Transaksi extends javax.swing.JFrame {
  Koneksi con = new Koneksi();
    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
         initComponents();
        setTitle("Menu Kasir");
//        setSize(577, 429);
        setLocationRelativeTo(null);
        kasir.setText("Kasir : " + Koneksi.username);
        notrx.setText(noFaktur());

        // Timer untuk memperbarui waktu setiap menit (60000 ms)
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menggunakan method jam() untuk mendapatkan tanggal dan waktu saat ini
                time.setText(jam());
            }
        });
        timer.start();  // Memulai timer
        time.setText(jam());
    }
    
        public String noFaktur() {
        String faktur = "TSK001";
        con.config();

        String sql = "SELECT no_transaksi FROM transaksi ORDER BY no_transaksi DESC LIMIT 1";
        try {
            ResultSet rs = con.stm.executeQuery(sql);
            if (rs.next()) {
                String noTransaksi = rs.getString("no_transaksi");

                // Pisahkan prefix dan bagian angka dari nomor transaksi terakhir
                String prefix = noTransaksi.substring(0, 3);
                int numberPart = Integer.parseInt(noTransaksi.substring(3)) + 1;

                // Buat nomor faktur baru dengan prefix dan angka yang di-increment
                faktur = prefix + String.format("%03d", numberPart);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(faktur);
        return faktur;
    }

    public String jam() {
        // Mengambil tanggal dan waktu saat ini
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Format tanggal dan waktu dalam pola "dd/MM/yyyy HH:mm"
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        // Mengembalikan waktu dan tanggal dengan pemisah baris \n
        return "<html>" + currentDateTime.format(timeFormatter) + "<br>" + currentDateTime.format(dateFormatter) + "</html>";
    }

    public void clear() {
        kodebrg.setText("");
        total1.setText("");
        bayar.setText("");
        kembali.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        notrx = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        total1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        kembali = new javax.swing.JTextField();
        add1 = new javax.swing.JButton();
        add2 = new javax.swing.JButton();
        kasir = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kodebrg = new javax.swing.JTextField();
        time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        p.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CODEMART");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TRANSAKSI");

        home.setBackground(new java.awt.Color(0, 0, 0));
        home.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("HOME KASIR");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(292, 292, 292)
                .addComponent(home)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        notrx.setBackground(new java.awt.Color(255, 255, 255));
        notrx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        notrx.setForeground(new java.awt.Color(0, 0, 0));
        notrx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notrxActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Kode Barang");

        tbl.setBackground(new java.awt.Color(255, 255, 255));
        tbl.setForeground(new java.awt.Color(0, 0, 0));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Harga", "QTY", "Jumlah"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        total1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        total1.setForeground(new java.awt.Color(0, 0, 0));
        total1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total1.setText("Rp. 0");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Bayar");

        bayar.setBackground(new java.awt.Color(255, 255, 255));
        bayar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bayar.setForeground(new java.awt.Color(0, 0, 0));
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bayarKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Kembali");

        kembali.setBackground(new java.awt.Color(255, 255, 255));
        kembali.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kembali.setForeground(new java.awt.Color(0, 0, 0));
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        add1.setBackground(new java.awt.Color(0, 204, 0));
        add1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add1.setForeground(new java.awt.Color(0, 0, 0));
        add1.setText("BAYAR");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        add2.setBackground(new java.awt.Color(255, 204, 51));
        add2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add2.setForeground(new java.awt.Color(0, 0, 0));
        add2.setText("LIST BARANG");
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });

        kasir.setBackground(new java.awt.Color(0, 0, 0));
        kasir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kasir.setForeground(new java.awt.Color(0, 0, 0));
        kasir.setText("Nama Kasir");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("No.Transaksi");

        kodebrg.setBackground(new java.awt.Color(255, 255, 255));
        kodebrg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        kodebrg.setForeground(new java.awt.Color(0, 0, 0));
        kodebrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodebrgActionPerformed(evt);
            }
        });

        time.setBackground(new java.awt.Color(0, 0, 0));
        time.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        time.setForeground(new java.awt.Color(0, 0, 0));
        time.setText("Waktu");

        javax.swing.GroupLayout pLayout = new javax.swing.GroupLayout(p);
        p.setLayout(pLayout);
        pLayout.setHorizontalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notrx, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kodebrg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(add2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pLayout.createSequentialGroup()
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pLayout.createSequentialGroup()
                                        .addComponent(time)
                                        .addGap(409, 409, 409)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(pLayout.createSequentialGroup()
                                        .addComponent(kasir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addGap(29, 29, 29)))
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pLayout.setVerticalGroup(
            pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(notrx, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kodebrg)
                            .addComponent(add2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(total1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(kasir))
                        .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(pLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(time))))
                    .addGroup(pLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void updateQty(){
        con.config();
        
    }
     
    private void addData(String productId) {
        con.config();
        DefaultTableModel tabel = (DefaultTableModel) tbl.getModel();
//        tabel.setRowCount(0);

        String sql = "SELECT * FROM barang WHERE kode_barang = " + productId + " LIMIT 1;";
        try (ResultSet rs = con.stm.executeQuery(sql)) {
            if (rs.next()) {
                String nama = rs.getString("nama_barang");
                int harga = rs.getInt("harga_jual");
                int qty = 1;

                int jumlah = harga * qty;


                Integer currentQuantity = 0;
                boolean productExists = false;
                for (int i = 0; i < tabel.getRowCount(); i++) {
                    // Corrected here
                    System.out.println(tabel.getValueAt(i, 0));

                    if (tabel.getValueAt(i, 0).equals(nama)) {

                        currentQuantity = (int) tbl.getValueAt(i, 2);
                        tabel.setValueAt(currentQuantity + 1, i, 2);  // Update quantity
                        tabel.setValueAt((currentQuantity + 1) * harga, i, 3);  // Update total price
                        productExists = true;
//                        System.out.println(productExists);
                        break;
                    }
                }
                // If the product does not exist, add it as a new row
                if (!productExists) {
                    tabel.addRow(new Object[]{nama, harga, qty, jumlah});
                }

                System.out.println(productExists);
                updateTotal();
            } else {
                JOptionPane.showMessageDialog(null, "Produk tidak ditemukan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        MainKasir.main(null);
        dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void notrxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notrxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notrxActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
         int updateRow = tbl.getSelectedRow();

        int harga = Integer.parseInt(tbl.getValueAt(updateRow, 1).toString());
        int qty = Integer.parseInt(tbl.getValueAt(updateRow, 2).toString());
        tbl.setValueAt(qty, updateRow, 2);

//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        int jumlah = harga * qty;

        tbl.setValueAt(jumlah, updateRow, 3);
        updateTotal();
//        }
    }//GEN-LAST:event_tblMouseClicked

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembaliActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
         con.config();
        String totalString = total1.getText().replace("Rp. ", "").trim();
        String petugas = kasir.getText().replace("Kasir : ", "").trim();
        String waktu = time.getText().replace("<html>", "").replace("<br>", " | ").replace("</html>", "").trim();
        long total = Integer.parseInt(totalString);
        try {
            String sql = "INSERT INTO transaksi (no_transaksi, petugas_kasir, total, waktu_transaksi) VALUES  ('"
                    + notrx.getText() + "', '" + petugas + "', '" + total + "', '" + waktu
                    + "' );";

            int i = con.stm.executeUpdate(sql);
            if (i > 0) {
                DefaultTableModel refresh = (DefaultTableModel) tbl.getModel();
                JOptionPane.showMessageDialog(null, "<html> Transaksi Berhasil <br>"+ waktu +"<br> KEMBALIAN : Rp. "+kembali.getText()+"</html>");
                clear();
                refresh.setNumRows(0);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        // TODO add your handling code here:
        KSListBarang.main(null);
        dispose();
        
    }//GEN-LAST:event_add2ActionPerformed

    private void kodebrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodebrgActionPerformed
        // TODO add your handling code here:
         String productId = kodebrg.getText();
        addData(productId);
        kodebrg.setText(" ");
        kodebrg.requestFocusInWindow();
    }//GEN-LAST:event_kodebrgActionPerformed

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed
          int updateRow = tbl.getSelectedRow();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int harga = Integer.parseInt(tbl.getValueAt(updateRow, 1).toString());
            int qty = Integer.parseInt(tbl.getValueAt(updateRow, 2).toString());
            tbl.setValueAt(qty, updateRow, 2);

            int jumlah = harga * qty;

            tbl.setValueAt(jumlah, updateRow, 3);
            updateTotal();
        }
    }//GEN-LAST:event_tblKeyPressed

    private void bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyPressed
        // TODO add your handling code here:
         // Menghapus "Rp. " dan spasi dari string
        String totalString = total1.getText().replace("Rp. ", "").trim();
        String bayarString = bayar.getText();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                // Konversi dari string ke int setelah membersihkan string dari prefix
                int total = Integer.parseInt(totalString);
                int bayar = Integer.parseInt(bayarString);

                int kembalian = bayar - total;

                // Konversi kembalian menjadi string dan set ke text field
                String hasil = String.valueOf(kembalian);
                kembali.setText(hasil);
            } catch (NumberFormatException e) {
                // Menangani kesalahan jika string tidak bisa dikonversi menjadi angka
                System.out.println("Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_bayarKeyPressed

     private void updateTotal() {
        int rowCount = tbl.getRowCount();
        Integer total = 0;
        for (int i = 0; i < rowCount; i++) {
            total += Integer.parseInt(tbl.getValueAt(i, 3).toString());
        }
        
        total1.setText("Rp. " + total.toString());
       
//        txtTotal.setText(total.toString());
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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
    private javax.swing.JButton add2;
    private javax.swing.JTextField bayar;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kasir;
    private javax.swing.JTextField kembali;
    private javax.swing.JTextField kodebrg;
    private javax.swing.JTextField notrx;
    private javax.swing.JPanel p;
    private javax.swing.JTable tbl;
    private javax.swing.JLabel time;
    private javax.swing.JLabel total1;
    // End of variables declaration//GEN-END:variables
}
