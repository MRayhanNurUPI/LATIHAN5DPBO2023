/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daftarmahasiswa;

// Import
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sekar and modified by Muhammad Rayhan Nur (2100192)
 */
public class Menu extends javax.swing.JFrame {

    // Properties
    private DefaultTableModel dtm;
    private Boolean isUpdate = false;
    private int selectedID = -1;
    private ArrayList<Mahasiswa> listMhs;

    /**
     * Creates new form Menu
     */
    public Menu() {
        // Constructor
        initComponents();
        listMhs = new ArrayList<>();
        
        // Dummy
        listMhs.add(new Mahasiswa("2100192", "Muhammad Rayhan Nur", "Laki-laki", "C1", "A"));
        listMhs.add(new Mahasiswa("2101926", "Bintang Fajar", "Laki-laki", "C2", "B"));
        listMhs.add(new Mahasiswa("2100121", "Rafi Arsalan", "Laki-laki", "Pilkom A", "C"));
        
        // Set Table
        tblMhs.setModel(setTable());
        
        // Hide Delete button
        btnDelete.setVisible(false);
    }

    public final DefaultTableModel setTable() {
        // Column Title
        Object[] column = {"NIM", "Nama", "Jenis Kelamin", "Kelas", "Nilai"};
        DefaultTableModel dataTabel = new DefaultTableModel(null, column) {
            // To make table cant be editable with double clicked on any column (So update data only able with input from textfield form)
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Get Cell Value
        for(int i = 0; i < listMhs.size(); i++) {
            Object[] row = new Object[5];
            row[0] = listMhs.get(i).getNim();
            row[1] = listMhs.get(i).getNama();
            row[2] = listMhs.get(i).getJenisKelamin();
            row[3] = listMhs.get(i).getKelas();
            row[4] = listMhs.get(i).getNilai();
            
            dataTabel.addRow(row);
        }

        return dataTabel;
    }

    public void insertData() {
       
         // Validation for empty value in form
                if (fieldNim.getText().equals("") || fieldNama.getText().equals("") || fieldNilai.getText().equals("") ||  !(rdLaki.isSelected() | rdPerempuan.isSelected())) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh ada yang kosong!");
        } else {
            // Get Data from Form
            String nim = fieldNim.getText();
            String nama = fieldNama.getText();
            String jenisKelamin = "";
            if (rdLaki.isSelected()){
                 jenisKelamin = rdLaki.getText();
            }else{
                 jenisKelamin = rdPerempuan.getText();
            }
            String kelas = comboBoxKelas.getSelectedItem().toString();
            String nilai = fieldNilai.getText();

            
            // Add New Data
            listMhs.add(new Mahasiswa(nim, nama, jenisKelamin, kelas, nilai));

            // Reset Form
            resetForm();

            //Update Table
            tblMhs.setModel(setTable());

            // Show Information
            System.out.println("Insert Success!");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");   
        }
    }

    public void updateData() {
        
         // Validation for empty value in form
        if (fieldNim.getText().equals("") || fieldNama.getText().equals("") || fieldNilai.getText().equals("") ||  !(rdLaki.isSelected() | rdPerempuan.isSelected())) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh ada yang kosong!");
            
            // Reset Form
            resetForm();
            
        } else {
            // Get Data from Form
            String nim = fieldNim.getText();
            String nama = fieldNama.getText();
            String jenisKelamin = "";
            if (rdLaki.isSelected()){
                 jenisKelamin = rdLaki.getText();
            }else{
                 jenisKelamin = rdPerempuan.getText();
            }
            String kelas = comboBoxKelas.getSelectedItem().toString();
            String nilai = fieldNilai.getText();
            
            // set Data to Object
            listMhs.get(selectedID).setNim(nim);
            listMhs.get(selectedID).setNama(nama);
            listMhs.get(selectedID).setJenisKelamin(jenisKelamin);
            listMhs.get(selectedID).setKelas(kelas);
            listMhs.get(selectedID).setNilai(nilai);


            // Reset Form
            resetForm();

            // Update Table
            tblMhs.setModel(setTable());

            // Show Information
            System.out.println("Update Success!");
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        }
    }

    public void deleteData() {
        // Remove Data from List
        listMhs.remove(selectedID);
        
        // Update Table
         tblMhs.setModel(setTable());
         
        // Reset Form
        resetForm();
        
        // Show Information
        System.out.println("Delete Success!");
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
    }
    
    public void resetForm() {
        // Set All Value Form to Empty
        fieldNim.setText("");
        fieldNama.setText("");
        fieldNilai.setText("");
        genderGroup.clearSelection();
        comboBoxKelas.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        fieldNim = new javax.swing.JTextField();
        lblNim = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        fieldNama = new javax.swing.JTextField();
        lblNilai = new javax.swing.JLabel();
        fieldNilai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMhs = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rdLaki = new javax.swing.JRadioButton();
        rdPerempuan = new javax.swing.JRadioButton();
        lblKelas = new javax.swing.JLabel();
        comboBoxKelas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Latihan 5 DPBO - 2100192 - Muhammad Rayhan Nur");

        jPanel1.setBackground(new java.awt.Color(126, 136, 176));
        jPanel1.setPreferredSize(new java.awt.Dimension(563, 600));

        lblTitle.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Daftar Nilai Mahasiswa Kemakom");

        btnAdd.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        fieldNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNimActionPerformed(evt);
            }
        });

        lblNim.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNim.setForeground(new java.awt.Color(255, 255, 255));
        lblNim.setText("NIM");

        lblNama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Nama");

        fieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNamaActionPerformed(evt);
            }
        });

        lblNilai.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNilai.setForeground(new java.awt.Color(255, 255, 255));
        lblNilai.setText("Nilai");

        fieldNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNilaiActionPerformed(evt);
            }
        });

        tblMhs.setAutoCreateRowSorter(true);
        tblMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblMhs.setUpdateSelectionOnSort(false);
        tblMhs.setVerifyInputWhenFocusTarget(false);
        tblMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMhs);

        btnDelete.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gender");

        genderGroup.add(rdLaki);
        rdLaki.setForeground(new java.awt.Color(255, 255, 255));
        rdLaki.setText("Laki-laki");
        rdLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLakiActionPerformed(evt);
            }
        });

        genderGroup.add(rdPerempuan);
        rdPerempuan.setForeground(new java.awt.Color(255, 255, 255));
        rdPerempuan.setText("Perempuan");
        rdPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdPerempuanActionPerformed(evt);
            }
        });

        lblKelas.setForeground(new java.awt.Color(255, 255, 255));
        lblKelas.setText("Kelas");

        comboBoxKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C1", "C2", "Pilkom A", "Pilkom B" }));
        comboBoxKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxKelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNilai)
                                        .addComponent(jLabel1)
                                        .addComponent(lblKelas)
                                        .addComponent(lblNama))
                                    .addGap(37, 37, 37))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblNim)
                                    .addGap(55, 55, 55)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldNim)
                                .addComponent(fieldNama)
                                .addComponent(fieldNilai)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBoxKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rdLaki))
                                    .addGap(28, 28, 28)
                                    .addComponent(rdPerempuan)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd)
                                .addComponent(btnDelete)
                                .addComponent(btnCancel)))
                        .addComponent(lblTitle)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNim)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNama)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNilai)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdLaki)
                    .addComponent(rdPerempuan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKelas)
                    .addComponent(comboBoxKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNimActionPerformed

    private void fieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaActionPerformed

    private void fieldNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNilaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNilaiActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        // If Add (data not clicked)
        if (isUpdate == false) {
            insertData();
        } else {
            updateData();
            btnAdd.setText("Add");
            btnDelete.setVisible(false);
            this.isUpdate = false;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMhsMouseClicked
        // TODO add your handling code here:
        // If data clicked
        this.isUpdate = true;

        //Get Selected Data
        int row = tblMhs.getSelectedRow();
        String selectedNim = (tblMhs.getModel().getValueAt(row, 0).toString());
        String selectedNama = (tblMhs.getModel().getValueAt(row, 1).toString());
        String selectedJenisKelamin = (tblMhs.getModel().getValueAt(row, 2).toString());
        String selectedKelas = (tblMhs.getModel().getValueAt(row, 3).toString());
        String selectedNilai = (tblMhs.getModel().getValueAt(row, 4).toString());


        // Search Data
        for(int i = 0; i < listMhs.size(); i++) {
            if(selectedNim.equals(listMhs.get(i).getNim())) {
                selectedID = i;
                break;
            }
        }

        // Set Form Value
        fieldNim.setText(selectedNim);
        fieldNama.setText(selectedNama);
        fieldNilai.setText(selectedNilai);
        if(selectedJenisKelamin.equals("Laki-laki")) {
            rdLaki.setSelected(true);
        } else {
            rdPerempuan.setSelected(true);
        }
        
        for (int i = 0; i < comboBoxKelas.getItemCount(); i++)
        {
            if (comboBoxKelas.getItemAt(i).toString().equals(selectedKelas))
            {
                comboBoxKelas.setSelectedIndex(i);
                break;
            }
        }

        btnAdd.setText("Update");
        btnDelete.setVisible(true);
    }//GEN-LAST:event_tblMhsMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int confirmation = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirmation==JOptionPane.YES_OPTION) {
            if (isUpdate == true) {
                deleteData();
                btnAdd.setText("Add");
                btnDelete.setVisible(false);
                this.isUpdate = false;
            } 
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        // Cancel Input Form
        btnAdd.setText("Add");
        btnDelete.setVisible(false);
        this.isUpdate = false;
        
        // Reset Form
        resetForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void rdPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdPerempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdPerempuanActionPerformed

    private void rdLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdLakiActionPerformed

    private void comboBoxKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxKelasActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> comboBoxKelas;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNilai;
    private javax.swing.JTextField fieldNim;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKelas;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNilai;
    private javax.swing.JLabel lblNim;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rdLaki;
    private javax.swing.JRadioButton rdPerempuan;
    private javax.swing.JTable tblMhs;
    // End of variables declaration//GEN-END:variables
}
