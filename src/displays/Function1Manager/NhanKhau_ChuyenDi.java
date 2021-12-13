/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays.Function1Manager;

import controllers.Function1.CapNhatController;
import controllers.Function1.HoKhauController;
import controllers.Function1.HoKhau_InfoController;
import controllers.Function1.NhanKhauController;
import controllers.Function1.ThemMoiController;
import displays.MainFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.HoKhauModel;
import models.NhanKhauModel;
import models.ThayDoiHKModel;

/**
 *
 * @author Loc Nguyen
 */
public class NhanKhau_ChuyenDi extends javax.swing.JFrame {

    /**
     * Creates new form ThemMoi
     */
    ThemMoiController tmController = new ThemMoiController();
    NhanKhauController nkController = new NhanKhauController();
    HoKhauController hkController = new HoKhauController();
    CapNhatController cnController = new CapNhatController();
    HoKhauModel hoKhau = new HoKhauModel();
    NhanKhauModel nhanKhau = new NhanKhauModel();

    private boolean check = false; //check xem nhan nut 'kiem tra' chua

    public NhanKhau_ChuyenDi() {
        initComponents();

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

    private boolean checkNullInForm() {
        return !(txtCmnd.getText().trim().isEmpty()
                || txtNoiChuyenDen.getText().trim().isEmpty());
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
        jLabel2 = new javax.swing.JLabel();
        btnKiemTra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtQuocTich = new javax.swing.JTextField();
        dateNgayChuyenDi = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNoiThuongTru = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        txtCmnd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNoiChuyenDen = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Đăng ký chuyển đi nơi khác");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng ký chuyển đi nơi khác");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Số CMT/CCCD:");

        btnKiemTra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKiemTra.setText("Kiểm tra");
        btnKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Họ và tên:");

        txtHoTen.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nơi thường trú:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ngày chuyển đi:");

        txtQuocTich.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Giới tính:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Quốc tịch:");

        txtNoiThuongTru.setEditable(false);

        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Nơi chuyển đến:");

        txtGioiTinh.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTen)
                            .addComponent(txtQuocTich)
                            .addComponent(txtNoiThuongTru)
                            .addComponent(txtCmnd)
                            .addComponent(txtNoiChuyenDen)
                            .addComponent(dateNgayChuyenDi, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXacNhan)
                            .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKiemTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNoiThuongTru)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNoiChuyenDen, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNgayChuyenDi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy)
                    .addComponent(btnXacNhan))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraActionPerformed
        if (txtCmnd.getText().trim().length() != 8
                && txtCmnd.getText().trim().length() != 9
                && txtCmnd.getText().trim().length() != 12) {
            check = false;
            txtHoTen.setText("");
            txtGioiTinh.setText("");
            txtQuocTich.setText("");
            txtNoiChuyenDen.setText("");
            txtNoiThuongTru.setText("");
            dateNgayChuyenDi.setDate(new Date());
            dateNgaySinh.setDate(new Date());
            JOptionPane.showMessageDialog(rootPane, "Định dạng số CMT/CCCD không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else if (tmController.checkCmndSs(txtCmnd.getText().trim())) {
            check = false;
            txtHoTen.setText("");
            txtGioiTinh.setText("");
            txtQuocTich.setText("");
            txtNoiChuyenDen.setText("");
            txtNoiThuongTru.setText("");
            dateNgayChuyenDi.setDate(new Date());
            dateNgaySinh.setDate(new Date());
            JOptionPane.showMessageDialog(rootPane, "Số CMT/CCCD chưa có trong hệ thống hoặc đang tạm trú/tạm vắng!", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else {
            HoKhau_Info hkInfo = new HoKhau_Info();
            int countMember = 0;
            if (!hkController.findByCondition(txtCmnd.getText().trim()).isEmpty()) {
                hoKhau = hkController.findByCondition(txtCmnd.getText().trim()).get(0);
                hkInfo.hoKhau = hoKhau;
                countMember = hkInfo.findMember().size();
            } else {
                hoKhau = null;
            }
            if (hoKhau == null || countMember <= 1) {
                check = true;
                JOptionPane.showMessageDialog(rootPane, "Kiểm tra thành công!");

                nhanKhau = nkController.findByCondition(txtCmnd.getText().trim()).get(0);
                txtHoTen.setText(nhanKhau.getHoTen());
                dateNgaySinh.setDate(nhanKhau.getNgaySinh());
                txtGioiTinh.setText(nhanKhau.getGioiTinh());
                txtQuocTich.setText(nhanKhau.getQuocTich());
                txtNoiThuongTru.setText(nhanKhau.getDcHienNay());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Người này là chủ hộ " + hoKhau.getMaHoKhau()
                        + " và hộ này có nhiều hơn 1 thành viên. Bạn cần đổi chủ hộ trước!", "Warning!", JOptionPane.WARNING_MESSAGE);
                check = false;
                txtHoTen.setText("");
                txtGioiTinh.setText("");
                txtQuocTich.setText("");
                txtNoiChuyenDen.setText("");
                txtNoiThuongTru.setText("");
                dateNgayChuyenDi.setDate(new Date());
                dateNgaySinh.setDate(new Date());
            }
        }
    }//GEN-LAST:event_btnKiemTraActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng?", "Warning!", JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if (txtCmnd.getText().trim().length() != 8
                && txtCmnd.getText().trim().length() != 9
                && txtCmnd.getText().trim().length() != 12) {
            check = false;
            txtHoTen.setText("");
            txtGioiTinh.setText("");
            txtQuocTich.setText("");
            txtNoiChuyenDen.setText("");
            txtNoiThuongTru.setText("");
            dateNgayChuyenDi.setDate(new Date());
            dateNgaySinh.setDate(new Date());
            JOptionPane.showMessageDialog(rootPane, "Định dạng số CMT/CCCD không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else if (check && checkNullInForm()) {

            nhanKhau.setTinhTrang("chuyển đi");
            nhanKhau.setNgayChuyenDi(dateNgayChuyenDi.getDate());
            nhanKhau.setNoiDen(txtNoiChuyenDen.getText().trim());
            cnController.capNhatNK(nhanKhau.getId(), nhanKhau);

            HoKhau_InfoController hkInfoController = new HoKhau_InfoController();
            ThayDoiHKModel model = new ThayDoiHKModel();
            model.setMaHoKhau(nhanKhau.getMaHoKhau());
            model.setThongTinThayDoi("Xóa thành viên");
            model.setNoiDungThayDoi(nhanKhau.getHoTen() + " - " + nhanKhau.getCmnd());
            model.setGhiChu("Chuyển đến " + nhanKhau.getNoiDen());
            hkInfoController.themThayDoiHK(model);

            if (hoKhau != null) {
                hoKhau.setTinhTrang("chuyển đi");
                hoKhau.setNgayChuyenDi(dateNgayChuyenDi.getDate());
                cnController.capNhatHK(hoKhau.getId(), hoKhau);

                model.setMaHoKhau(nhanKhau.getMaHoKhau());
                model.setThongTinThayDoi("Chuyển đi");
                model.setNoiDungThayDoi("");
                model.setGhiChu("");
                hkInfoController.themThayDoiHK(model);
            }

            JOptionPane.showMessageDialog(rootPane, "Đăng ký chuyển đi thành công!");
            MainFrame.it.setEnabled(true);
            dispose();
        } else if (check == false) {
            JOptionPane.showMessageDialog(rootPane, "Chưa nhấn nút kiểm tra!", "Warning!", JOptionPane.WARNING_MESSAGE);
        } else if (!checkNullInForm()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền hết các trường!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JButton btnXacNhan;
    private com.toedter.calendar.JDateChooser dateNgayChuyenDi;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNoiChuyenDen;
    private javax.swing.JTextField txtNoiThuongTru;
    private javax.swing.JTextField txtQuocTich;
    // End of variables declaration//GEN-END:variables
}
