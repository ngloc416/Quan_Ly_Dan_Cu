/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays.Function1Manager;

import displays.MainFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.GiaDinhModel;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.ThanhVienModel;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class HoKhau_Info extends javax.swing.JFrame {

    /**
     * Creates new form HoKhau_Info
     */
    HoKhauModel hoKhau;
    private List<ThanhVienModel> listTV = new ArrayList<>();
    private DefaultTableModel tableModel;
    
    public HoKhau_Info(HoKhauModel hoKhau) {
        initComponents();
        this.hoKhau = hoKhau;
        this.tableModel = (DefaultTableModel) table.getModel();
        
        txtMaHK.setText(hoKhau.getMaHoKhau());
        txtCmnd.setText(hoKhau.getCmndChuHo());
        txtHoTen.setText(hoKhau.getHoTenChuHo());
        txtDc.setText(hoKhau.getDiaChi());
        txtNgayTao.setText(hoKhau.getNgayLap().toString()); 
        
        listTV = find();
        showMember();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng?", "Warning!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
        });
    }

    private void close() {
        MainFrame.it.setEnabled(true);
        dispose();
    }
    
    private void showMember() {
        tableModel.setRowCount(0);

        listTV.forEach(item -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.nhanKhau.getCmnd(), item.nhanKhau.getHoTen(),
                item.nhanKhau.getNgaySinh(), item.nhanKhau.getGioiTinh(), item.giaDinh.getQhChuHo(), 
                (("cập nhật".equals(item.nhanKhau.getTinhTrang().trim())) || ("chuyển đi".equals(item.nhanKhau.getTinhTrang().trim())))
                ? "sinh sống" : item.nhanKhau.getTinhTrang()});
        });
    }

    private List<ThanhVienModel> find() {
        List<ThanhVienModel> list = new ArrayList<>();
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT *  FROM nhankhau INNER JOIN "
                        + "(SELECT idnhankhau, mahokhau, quanhechuho, idhokhau, giadinh.id AS idgiadinh FROM giadinh "
                        + "INNER JOIN hokhau ON hokhau.id = giadinh.idhokhau WHERE mahokhau LIKE '" + hoKhau.getMaHoKhau() + "') "
                        + "AS A ON nhankhau.id = A.idnhankhau "
                        + "WHERE tinhtrang LIKE 'sinh sống' "
                        + "OR (tinhtrang LIKE 'tạm vắng' AND tungay <= curdate() AND denngay >= curdate()) "
                        + "OR (tinhtrang LIKE 'chuyển đi' AND ngaychuyendi > curdate()) "
                        + "OR (tinhtrang LIKE 'cập nhật' AND tungay > curdate()) ";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        NhanKhauModel nhanKhau = new NhanKhauModel();
                        GiaDinhModel giaDinh = new GiaDinhModel();
                        
                        nhanKhau.setId(rs.getInt("id"));
                        nhanKhau.setMaHoKhau(rs.getString("mahokhau"));
                        nhanKhau.setHoTen(rs.getString("hoten"));
                        nhanKhau.setBiDanh(rs.getString("bidanh"));
                        nhanKhau.setNgaySinh(rs.getDate("ngaysinh"));
                        nhanKhau.setGioiTinh(rs.getString("gioitinh"));
                        nhanKhau.setNoiSinh(rs.getString("noisinh"));
                        nhanKhau.setNguyenQuan(rs.getString("nguyenquan"));
                        nhanKhau.setDcHienNay(rs.getString("dchiennay"));
                        nhanKhau.setDanToc(rs.getString("dantoc"));
                        nhanKhau.setTonGiao(rs.getString("tongiao"));
                        nhanKhau.setQuocTich(rs.getString("quoctich"));
                        nhanKhau.setNgheNghiep(rs.getString("nghenghiep"));
                        nhanKhau.setNoiLamViec(rs.getString("noilamviec"));
                        nhanKhau.setCmnd(rs.getString("cmnd"));
                        nhanKhau.setNgayCap(rs.getDate("ngaycap"));
                        nhanKhau.setNoiCap(rs.getString("noicap"));
                        nhanKhau.setNgayChuyenDen(rs.getDate("ngaychuyenden"));
                        nhanKhau.setNoiTruocChuyenDen(rs.getString("noitruocchuyenden"));
                        nhanKhau.setNgayChuyenDi(rs.getDate("ngaychuyendi"));
                        nhanKhau.setNoiDen(rs.getString("noiden"));
                        nhanKhau.setTinhTrang(rs.getString("tinhtrang"));
                        nhanKhau.setTuNgay(rs.getDate("tungay"));
                        nhanKhau.setDenNgay(rs.getDate("denngay"));
                        nhanKhau.setNgayLap(rs.getDate("ngaylap"));
                        
                        giaDinh.setId(rs.getInt("idgiadinh"));
                        giaDinh.setIdHoKhau(rs.getInt("idhokhau"));
                        giaDinh.setIdNhanKhau(rs.getInt("idnhankhau"));
                        giaDinh.setQhChuHo(rs.getString("quanhechuho"));
                        
                        ThanhVienModel tvm = new ThanhVienModel(nhanKhau, giaDinh);

                        list.add(tvm);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return list;
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
        jLabel45 = new javax.swing.JLabel();
        txtMaHK = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtCmnd = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtDc = new javax.swing.JTextField();
        btnDoiChuHo = new javax.swing.JButton();
        btnTachHo = new javax.swing.JButton();
        btnChuyenDi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin chi tiết");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Mã hộ khẩu:");

        txtMaHK.setEditable(false);
        txtMaHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHKActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Họ tên chủ hộ:");

        txtNgayTao.setEditable(false);
        txtNgayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayTaoActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Ngày tạo:");

        txtHoTen.setEditable(false);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Số CCCD/CMT chủ hộ:");

        txtCmnd.setEditable(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Địa chỉ:");

        txtDc.setEditable(false);

        btnDoiChuHo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDoiChuHo.setText("Đổi chủ hộ");

        btnTachHo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTachHo.setText("Tách hộ ");

        btnChuyenDi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChuyenDi.setText("Chuyển đi");
        btnChuyenDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDoiChuHo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTachHo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnChuyenDi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtDc)
                                .addComponent(txtMaHK, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCmnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDoiChuHo)
                    .addComponent(btnTachHo)
                    .addComponent(btnChuyenDi))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin chi tiết");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thành viên trong gia đình");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số CMT/CCCD", "Họ tên", "Ngày sinh", "Giới tính", "QH với chủ hộ", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(22);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(30);
            table.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHKActionPerformed

    private void txtNgayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayTaoActionPerformed

    private void btnChuyenDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenDiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDi;
    private javax.swing.JButton btnDoiChuHo;
    private javax.swing.JButton btnTachHo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextField txtDc;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaHK;
    private javax.swing.JTextField txtNgayTao;
    // End of variables declaration//GEN-END:variables
}
