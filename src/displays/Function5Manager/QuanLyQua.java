/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays.Function5Manager;

import static displays.Function5Manager.QuanLyQuy.getSoDu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.PhanQuaModel;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class QuanLyQua extends javax.swing.JPanel {

    private List<PhanQuaModel> listPQHC;
    private List<PhanQuaModel> listPQLS;
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

    /**
     * Creates new form QuanLyQua
     */
    public QuanLyQua() {
        initComponents();
        listPQHC = findHienCo();
        listPQLS = findLichSu();
        hienThiPhanQuaHienCo();
        hienThiLichSu();

        tblHienCo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    PhanQuaModel temp = listPQHC.get(tblHienCo.getSelectedRow());
                    if (JOptionPane.showConfirmDialog(null, "Dịp tặng '" + temp.getDip() + "' đã kết thúc?", "Warning!", JOptionPane.YES_NO_OPTION) == 0) {
                        try {
                            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                                String query = "UPDATE phanqua SET tinhtrang = ? WHERE id = " + temp.getId();
                                try ( PreparedStatement st = connection.prepareStatement(query)) {
                                    st.setString(1, "kết thúc");
                                    st.execute();
                                }
                            }
                        } catch (ClassNotFoundException | SQLException ee) {
                            JOptionPane.showMessageDialog(null, ee.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                        }

                        String moTa = "- " + currencyVN.format(temp.getTongGiaTri()) + " VNĐ do tặng phần thưởng '" + temp.getDip() + "' ngày "
                                + temp.getThoiGian().toString();
                        int soDuCu = getSoDu();
                        int soDuMoi = soDuCu - temp.getTongGiaTri();

                        try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                            String query = "INSERT INTO quyphanthuong (sodu, mota) VALUES (?, ?)";
                            PreparedStatement preparedStatement = connection.prepareCall(query);
                            preparedStatement.setString(1, String.valueOf(soDuMoi));
                            preparedStatement.setString(2, moTa);
                            preparedStatement.execute();
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(QuanLyQuy.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        listPQHC = findHienCo();
                        listPQLS = findLichSu();
                        hienThiPhanQuaHienCo();
                        hienThiLichSu();
                    }
                }
            }

        });
    }

    private List<PhanQuaModel> findHienCo() {
        List<PhanQuaModel> res = new ArrayList<>();
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT *  FROM phanqua WHERE tinhtrang LIKE 'đang tặng' ORDER BY thoigian DESC";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                try ( ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        PhanQuaModel phanQua = new PhanQuaModel();

                        phanQua.setId(rs.getInt("id"));
                        phanQua.setThoiGian(rs.getDate("thoigian"));
                        phanQua.setDip(rs.getString("dip"));
                        phanQua.setGiaTri(rs.getInt("giatri"));
                        phanQua.setTongQua(rs.getInt("tongqua"));
                        phanQua.setTongGiaTri(rs.getInt("tonggiatri"));
                        phanQua.setTinhTrang(rs.getString("tinhtrang"));

                        res.add(phanQua);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private List<PhanQuaModel> findLichSu() {
        List<PhanQuaModel> res = new ArrayList<>();
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT *  FROM phanqua WHERE tinhtrang LIKE 'kết thúc'ORDER BY thoigian DESC";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                try ( ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        PhanQuaModel phanQua = new PhanQuaModel();

                        phanQua.setId(rs.getInt("id"));
                        phanQua.setThoiGian(rs.getDate("thoigian"));
                        phanQua.setDip(rs.getString("dip"));
                        phanQua.setGiaTri(rs.getInt("giatri"));
                        phanQua.setTongQua(rs.getInt("tongqua"));
                        phanQua.setTongGiaTri(rs.getInt("tonggiatri"));
                        phanQua.setTinhTrang(rs.getString("tinhtrang"));

                        res.add(phanQua);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    private void hienThiPhanQuaHienCo() {
        DefaultTableModel tableModel = (DefaultTableModel) tblHienCo.getModel();
        tableModel.setRowCount(0);

        listPQHC.forEach(item -> {
            tableModel.addRow(new Object[]{item.getThoiGian(), item.getDip(), currencyVN.format(item.getGiaTri()), item.getTongQua(),
                currencyVN.format(item.getTongGiaTri())});
        });
    }

    private void hienThiLichSu() {
        DefaultTableModel tableModel = (DefaultTableModel) tblLichSu.getModel();
        tableModel.setRowCount(0);

        listPQLS.forEach(item -> {
            tableModel.addRow(new Object[]{item.getThoiGian(), item.getDip(), currencyVN.format(item.getGiaTri()), item.getTongQua(),
                currencyVN.format(item.getTongGiaTri())});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHienCo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbTenDip = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));

        tblHienCo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thời gian", "Tên dịp", "Giá trị một phần quà", "Tổng phần quà", "Tổng giá trị"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHienCo.setRowHeight(22);
        jScrollPane1.setViewportView(tblHienCo);
        if (tblHienCo.getColumnModel().getColumnCount() > 0) {
            tblHienCo.getColumnModel().getColumn(3).setMinWidth(120);
            tblHienCo.getColumnModel().getColumn(3).setMaxWidth(120);
            tblHienCo.getColumnModel().getColumn(4).setMinWidth(120);
            tblHienCo.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Thêm dịp mới:");

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Các dịp hiện có:");

        cbTenDip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbTenDip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tết thiếu nhi 1/6", "Trung thu", "Thưởng học tập", "Tết Nguyên Đán", "Khác (Sửa tên dịp tại đây)" }));
        cbTenDip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenDipActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Lịch sử tặng quà:");

        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thời gian", "Tên dịp", "Giá trị một phần quà", "Tổng phần quà", "Tổng giá trị"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLichSu.setRowHeight(22);
        jScrollPane2.setViewportView(tblLichSu);
        if (tblLichSu.getColumnModel().getColumnCount() > 0) {
            tblLichSu.getColumnModel().getColumn(3).setMinWidth(120);
            tblLichSu.getColumnModel().getColumn(3).setMaxWidth(120);
            tblLichSu.getColumnModel().getColumn(4).setMinWidth(120);
            tblLichSu.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Nhấn đúp vào một dịp để chọn kết thúc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbTenDip, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTenDip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm không?", "Warning!", JOptionPane.YES_NO_OPTION) == 0) {

            String dip = cbTenDip.getSelectedItem().toString();

            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "INSERT INTO phanqua (dip, tinhtrang, taods) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareCall(query);
                preparedStatement.setString(1, dip);
                preparedStatement.setString(2, "đang tặng");
                preparedStatement.setString(3, "false");
                preparedStatement.execute();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
            }
            listPQHC = findHienCo();
            hienThiPhanQuaHienCo();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbTenDipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenDipActionPerformed
        if (cbTenDip.getSelectedItem().toString().trim().equals("Khác (Sửa tên dịp tại đây)")) {
            cbTenDip.setEditable(true);
        } else cbTenDip.setEditable(false);
    }//GEN-LAST:event_cbTenDipActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbTenDip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHienCo;
    private javax.swing.JTable tblLichSu;
    // End of variables declaration//GEN-END:variables
}
