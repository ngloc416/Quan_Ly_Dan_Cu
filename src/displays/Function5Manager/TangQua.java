/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays.Function5Manager;

import controllers.Function1.ThongKeController;
import controllers.Function5.TangQuaController;
import displays.MainFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import models.PhanQuaModel;
import models.TangQuaModel;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class TangQua extends javax.swing.JPanel {

    /**
     * Creates new form LapDanhSach
     */
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    ThongKeController tkcontroller;
    TangQuaController tqController = new TangQuaController();
    PhanQuaModel phanQuaSelected;
    List<TangQuaModel> listTQ;

    int tongNg = 0, slgQua = 0;
    boolean check1 = false; //check xem an nut hien thi danh sach chua
    boolean check2 = false; //check xem an nut kiem tra chua

    public TangQua() {
        initComponents();
        fillDipComboBox();
        initAction();
        if (cbChonDip.getItemCount() != 0 && cbChonDip.getSelectedItem().toString().equals("Thưởng học tập")) {
            txtMC.setVisible(true);
        } else {
            txtMC.setVisible(false);
        }
        DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
        //xu ly su kien khi cap nhat bang
        tableModel.addTableModelListener((TableModelEvent e) -> {
            check2 = false;
            TangQuaModel tq = new TangQuaModel();
            int soHang = tableModel.getRowCount();
            for (int i = 0; i < soHang; i++) {
                tq.setIdPhanQua(phanQuaSelected.getId());
                tq.setMaHoKhau((String) tableModel.getValueAt(i, 1));
                tq.setHoTen((String) tableModel.getValueAt(i, 2));
                tq.setSoLuong((int) tableModel.getValueAt(i, 5));

                tqController.capNhatSoLuongTQ(tq, tq.getIdPhanQua(), tq.getMaHoKhau(), tq.getHoTen());
            }
        });

        //xu ly su kien khi nhay dup vao 1 hang trong bang
        tblDs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cbChonDip.getSelectedItem().toString().equals("Thưởng học tập")) {
                    if (e.getClickCount() > 1) {
                        TangQuaModel temp = listTQ.get(tblDs.getSelectedRow());
                        TangQua_MinhChung mc = new TangQua_MinhChung(temp);
                        MainFrame.it.setEnabled(false);
                        mc.setLocationRelativeTo(null);
                        mc.setVisible(true);
                    }
                    listTQ = tqController.findByCondition(phanQuaSelected.getId(), txtSearch.getText().trim());
                    showDS();
                }
            }
        });
    }

    private void fillDipComboBox() {
        cbChonDip.removeAllItems();

        try ( Connection connection = MysqlConnection.getMysqlConnection()) {
            String query = "select DISTINCT(dip), id, thoigian, giatri, tongqua, tonggiatri, tinhtrang"
                    + " from phanqua WHERE tinhtrang LIKE 'đang tặng'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try ( ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    cbChonDip.addItem(rs.getString("dip"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyQuy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initAction() {
        this.txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listTQ = tqController.findByCondition(phanQuaSelected.getId(), key);
                showDS();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listTQ = tqController.findByCondition(phanQuaSelected.getId(), key);
                showDS();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = txtSearch.getText();
                listTQ = tqController.findByCondition(phanQuaSelected.getId(), key);
                showDS();
            }
        });
    }

    private void showDS() {
        DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
        tableModel.setRowCount(0);
        listTQ.forEach(item -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.getMaHoKhau(), item.getHoTen(),
                item.getNgaySinh(), item.getGioiTinh(), item.getSoLuong()});
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

        jLabel5 = new javax.swing.JLabel();
        cbChonDip = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDs = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSoLg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTongNg = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnHienThiDs = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKiemTra = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMC = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Chọn dịp:");

        cbChonDip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChonDipActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Danh sách tặng:");

        tblDs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hộ khẩu", "Họ tên", "Ngày sinh", "Giới tính", "Số lượng quà"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDs);
        if (tblDs.getColumnModel().getColumnCount() > 0) {
            tblDs.getColumnModel().getColumn(0).setMinWidth(50);
            tblDs.getColumnModel().getColumn(0).setMaxWidth(50);
            tblDs.getColumnModel().getColumn(1).setMinWidth(80);
            tblDs.getColumnModel().getColumn(1).setMaxWidth(80);
            tblDs.getColumnModel().getColumn(3).setMinWidth(150);
            tblDs.getColumnModel().getColumn(3).setMaxWidth(150);
            tblDs.getColumnModel().getColumn(5).setMinWidth(80);
            tblDs.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Giá trị 1 phần quà:");

        txtGiaTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tổng số người:");

        txtSoLg.setEditable(false);

        txtTongNg.setEditable(false);
        txtTongNg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongNgActionPerformed(evt);
            }
        });

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hộ khẩu", "Họ tên chủ hộ", "Số lượng quà", "Giá trị"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(tblThongKe);
        if (tblThongKe.getColumnModel().getColumnCount() > 0) {
            tblThongKe.getColumnModel().getColumn(0).setMinWidth(50);
            tblThongKe.getColumnModel().getColumn(0).setMaxWidth(50);
            tblThongKe.getColumnModel().getColumn(1).setMinWidth(80);
            tblThongKe.getColumnModel().getColumn(1).setMaxWidth(80);
            tblThongKe.getColumnModel().getColumn(3).setMinWidth(80);
            tblThongKe.getColumnModel().getColumn(3).setMaxWidth(80);
            tblThongKe.getColumnModel().getColumn(4).setMinWidth(100);
            tblThongKe.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Thống kê theo hộ:");

        btnHienThiDs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHienThiDs.setText("Hiển thị danh sách");
        btnHienThiDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiDsActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLuu.setText("Lưu và thống kê");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKiemTra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKiemTra.setText("Kiểm tra quỹ");
        btnKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tổng giá trị:");

        txtTongTien.setEditable(false);
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tổng phần quà:");

        txtSearch.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tìm kiếm theo họ tên:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Nhấn đúp vào ô số lượng quà để thay đổi");

        txtMC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMC.setForeground(new java.awt.Color(255, 0, 0));
        txtMC.setText("Nhấn đúp vào ô họ tên để tải ảnh minh chứng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)
                        .addGap(78, 78, 78)
                        .addComponent(cbChonDip, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnHienThiDs))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTongNg, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSoLg, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMC)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChonDip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHienThiDs, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMC)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTongNg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLuu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tangLeTetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tangLeTetActionPerformed

    }//GEN-LAST:event_tangLeTetActionPerformed

    private void txtTongNgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongNgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongNgActionPerformed

    private void btnHienThiDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiDsActionPerformed
        if (cbChonDip.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Hiện tại chưa có dịp tặng nào!", "Warning!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        tongNg = 0;
        slgQua = 0;
        txtGiaTri.setText("");
        txtTongTien.setText("");
        DefaultTableModel tableModel2 = (DefaultTableModel) tblThongKe.getModel();
        tableModel2.setRowCount(0);

        phanQuaSelected = tqController.getPhanQua(cbChonDip.getSelectedItem().toString().trim());
        if (phanQuaSelected.getTaoDS().equals("false")) {
            if (!cbChonDip.getSelectedItem().toString().trim().equals("Thưởng học tập")) {
                List<NhanKhauModel> list;
                tkcontroller = new ThongKeController();
                list = tkcontroller.ThongKeTQ(0, 17, "");
                DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
                tableModel.setRowCount(0);
                list.forEach(item -> {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.getMaHoKhau(), item.getHoTen(),
                        item.getNgaySinh(), item.getGioiTinh(), 1});
                    tongNg++;
                    slgQua++;
                });
            } else {
                List<NhanKhauModel> list;
                tkcontroller = new ThongKeController();
                list = tkcontroller.ThongKeTQ(6, 20, "Học sinh");

                DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
                tableModel.setRowCount(0);
                list.forEach(item -> {
                    tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.getMaHoKhau(), item.getHoTen(),
                        item.getNgaySinh(), item.getGioiTinh(), 0});
                    tongNg++;
                    slgQua = 0;
                });
            }
            txtTongNg.setText("" + tongNg);
            txtSoLg.setText("" + slgQua);

            phanQuaSelected.setTaoDS("true");
            tqController.capNhatPQ(phanQuaSelected, phanQuaSelected.getId());

            TangQuaModel tq = new TangQuaModel();
            DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
            int soHang = tableModel.getRowCount();
            for (int i = 0; i < soHang; i++) {
                tq.setIdPhanQua(phanQuaSelected.getId());
                tq.setMaHoKhau((String) tableModel.getValueAt(i, 1));
                tq.setHoTen((String) tableModel.getValueAt(i, 2));
                tq.setNgaySinh((Date) tableModel.getValueAt(i, 3));
                tq.setGioiTinh((String) tableModel.getValueAt(i, 4));
                tq.setSoLuong((int) tableModel.getValueAt(i, 5));

                tqController.themTangQua(tq);
            }
            JOptionPane.showMessageDialog(null, "Hiển thị thành công! Vui lòng nhập giá trị 1 phần quà để tính toán!");
        } else {
            listTQ = tqController.getListTangQua(phanQuaSelected.getId());
            DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
            tableModel.setRowCount(0);
            listTQ.forEach(item -> {
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.getMaHoKhau(), item.getHoTen(),
                    item.getNgaySinh(), item.getGioiTinh(), item.getSoLuong()});
                tongNg++;
                slgQua += item.getSoLuong();
            });
            txtTongNg.setText("" + tongNg);
            txtSoLg.setText("" + slgQua);
            txtTongTien.setText("" + phanQuaSelected.getTongGiaTri());
            txtGiaTri.setText("" + phanQuaSelected.getGiaTri());
            JOptionPane.showMessageDialog(null, "Hiển thị thành công!");
        }
        check1 = true;
        txtSearch.setEditable(true);
    }//GEN-LAST:event_btnHienThiDsActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (!check2) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhấn nút kiểm tra trước!", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else {
            phanQuaSelected.setGiaTri(Integer.parseInt(txtGiaTri.getText().trim()));
            phanQuaSelected.setTongQua(Integer.parseInt(txtSoLg.getText().trim()));
            phanQuaSelected.setTongGiaTri(Integer.parseInt(txtTongTien.getText().trim()));
            tqController.capNhatPQ(phanQuaSelected, phanQuaSelected.getId());

            TangQuaModel tq = new TangQuaModel();
            DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
            int soHang = tableModel.getRowCount();
            for (int i = 0; i < soHang; i++) {
                tq.setIdPhanQua(phanQuaSelected.getId());
                tq.setMaHoKhau((String) tableModel.getValueAt(i, 1));
                tq.setHoTen((String) tableModel.getValueAt(i, 2));
                tq.setSoLuong((int) tableModel.getValueAt(i, 5));

                tqController.capNhatSoLuongTQ(tq, tq.getIdPhanQua(), tq.getMaHoKhau(), tq.getHoTen());
            }

            List<TangQuaModel> list = tqController.thongKeTheoHK(phanQuaSelected.getId());
            DefaultTableModel tableModel2 = (DefaultTableModel) tblThongKe.getModel();
            tableModel2.setRowCount(0);
            list.forEach(item -> {
                tableModel2.addRow(new Object[]{tableModel2.getRowCount() + 1, item.getMaHoKhau(), item.getHoTen(),
                    item.getSoLuong(), currencyVN.format(item.getSoLuong() * Integer.parseInt(txtGiaTri.getText().trim()))});
            });

            JOptionPane.showMessageDialog(null, "Lưu thành công!");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraActionPerformed
        if (!check1) {
            JOptionPane.showMessageDialog(null, "Vui lòng hiển thị danh sách trước!", "Warning!", JOptionPane.WARNING_MESSAGE);
            check2 = false;
        } else {
            if (txtGiaTri.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền 1 phần quà!", "Warning!", JOptionPane.WARNING_MESSAGE);
                check2 = false;
            } else {
                try {
                    int motPhanQua = Integer.parseInt(txtGiaTri.getText().trim());
                    slgQua = 0;
                    DefaultTableModel tableModel = (DefaultTableModel) tblDs.getModel();
                    int soHang = tableModel.getRowCount();
                    for (int i = 0; i < soHang; i++) {
                        slgQua += (int) tableModel.getValueAt(i, 5);
                    }
                    txtSoLg.setText("" + slgQua);
                    if (motPhanQua*slgQua > (QuanLyQuy.getSoDu() - QuanLyQua.tongTienQuaDuTinh + phanQuaSelected.getGiaTri()*phanQuaSelected.getTongQua())) {
                        JOptionPane.showMessageDialog(null, "Tiền thưởng vượt quá quỹ! Vui lòng nhập lại", "Warning!", JOptionPane.WARNING_MESSAGE);
                        check2 = false;
                    } else {
                        check2 = true;
                        txtTongTien.setText("" + motPhanQua * slgQua);
                        JOptionPane.showMessageDialog(null, "Kiểm tra thành công!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Định dạng số tiền nhập không đúng!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    txtGiaTri.setText("");
                    check2 = false;
                }
            }
        }
    }//GEN-LAST:event_btnKiemTraActionPerformed

    private void txtGiaTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaTriActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void cbChonDipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChonDipActionPerformed
        check1 = false;
        if (cbChonDip.getItemCount() != 0 && cbChonDip.getSelectedItem().toString().equals("Thưởng học tập")) {
            txtMC.setVisible(true);
        } else
            txtMC.setVisible(false);
    }//GEN-LAST:event_cbChonDipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThiDs;
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cbChonDip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDs;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JLabel txtMC;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLg;
    private javax.swing.JTextField txtTongNg;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
