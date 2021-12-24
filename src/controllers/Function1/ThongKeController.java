/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Function1;

import displays.Function1Manager.NhanKhau_Info;
import displays.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.NhanKhauModel;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class ThongKeController {

    private JComboBox cbGioiTinh;
    private JComboBox cbTinhTrang;
    private JTextField txtTuTuoi;
    private JTextField txtDenTuoi;
    private JTextField txtTuNgay;
    private JTextField txtDenNgay;
    private JButton btnTimKiem;
    private String ngheNghiep;
    private DefaultTableModel tableModel;
    private List<NhanKhauModel> listNK = new ArrayList<>();

    public ThongKeController() {
    }

    public List<NhanKhauModel> ThongKeTQ(int tuTuoi, int denTuoi, String nghe) { //thong ke tang qua
        String s[] = {"Toàn bộ", "Sinh sống và có hộ khẩu tại đây"};
        this.cbGioiTinh = new JComboBox(s);
        this.cbGioiTinh.setSelectedItem("Toàn bộ");
        this.cbTinhTrang = new JComboBox(s);
        this.cbTinhTrang.setSelectedItem("Sinh sống và có hộ khẩu tại đây");
        this.txtTuTuoi = new JTextField();
        this.txtTuTuoi.setText("" + tuTuoi);
        this.txtDenTuoi = new JTextField();
        this.txtDenTuoi.setText("" + denTuoi);
        this.txtTuNgay = new JTextField();
        this.txtTuNgay.setText("");
        this.txtDenNgay = new JTextField();
        this.txtDenNgay.setText("");
        this.ngheNghiep = nghe.trim();

        return find();

    }

    public ThongKeController(JComboBox cbGioiTinh, JComboBox cbTinhTrang, JTextField txtTuTuoi,
            JTextField txtDenTuoi, JTextField txtTuNgay, JTextField txtDenNgay, JTable table, JButton btnTimKiem) {
        this.cbGioiTinh = cbGioiTinh;
        this.cbTinhTrang = cbTinhTrang;
        this.txtTuTuoi = txtTuTuoi;
        this.txtDenTuoi = txtDenTuoi;
        this.txtTuNgay = txtTuNgay;
        this.txtDenNgay = txtDenNgay;
        this.tableModel = (DefaultTableModel) table.getModel();
        this.ngheNghiep = "";
        this.btnTimKiem = btnTimKiem;

        this.btnTimKiem.addActionListener((ActionEvent e) -> {
            listNK = find();
            showNhanKhau();
        });

        //xu ly su kien khi nhay dup vao 1 hang trong bang
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    NhanKhauModel temp = listNK.get(table.getSelectedRow());
                    NhanKhau_Info info = new NhanKhau_Info(temp);
                    info.btn.setVisible(false);
                    MainFrame.it.setEnabled(false);
                    info.setLocationRelativeTo(null);
                    info.setVisible(true);
                }
            }

        });
    }

    private void showNhanKhau() {
        tableModel.setRowCount(0);

        listNK.forEach(item -> {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, item.getMaHoKhau(), item.getCmnd(),
                item.getHoTen(), item.getNgaySinh(), item.getGioiTinh(), item.getDcHienNay(),
                ("cập nhật".equals(item.getTinhTrang().trim())) ? "sinh sống" : item.getTinhTrang()});
        });
    }

    private List<NhanKhauModel> find() {
        List<NhanKhauModel> list = new ArrayList<>();
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT *  FROM nhankhau LEFT JOIN "
                        + "(SELECT idnhankhau, mahokhau FROM giadinh INNER JOIN hokhau ON hokhau.id = giadinh.idhokhau) AS A "
                        + "ON nhankhau.id = A.idnhankhau ";

                if (cbTinhTrang.getSelectedItem().toString().trim().equals("Toàn bộ")) {
                    query += "WHERE (tinhtrang LIKE 'sinh sống' "
                            + "OR (tinhtrang LIKE 'tạm trú' AND tungay <= curdate() AND denngay >= curdate()) "
                            + "OR (tinhtrang LIKE 'tạm vắng' AND tungay <= curdate() AND denngay >= curdate()) "
                            + "OR (tinhtrang LIKE 'chuyển đi' AND ngaychuyendi > curdate()) "
                            + "OR (tinhtrang LIKE 'cập nhật' AND tungay > curdate())) ";
                } else {
                    if (txtTuNgay.getText().trim().isEmpty() && txtDenNgay.getText().trim().isEmpty()) { //nếu tungay, denngay rỗng thì tìm tại thời điểm hiện tại
                        switch (cbTinhTrang.getSelectedItem().toString().trim()) {
                            case "Sinh sống và có hộ khẩu tại đây" ->
                                query += "WHERE ((tinhtrang LIKE 'sinh sống') "
                                        + "OR (tinhtrang LIKE 'cập nhật' AND tungay > curdate())) ";
                            case "Tạm trú" ->
                                query += "WHERE (tinhtrang LIKE 'tạm trú' AND tungay <= curdate() AND denngay >= curdate()) ";
                            case "Tạm vắng" ->
                                query += "WHERE (tinhtrang LIKE 'tạm vắng' AND tungay <= curdate() AND denngay >= curdate()) ";
                            case "Qua đời/Chuyển đi" ->
                                query += "WHERE ((tinhtrang LIKE 'đã mất') OR (tinhtrang LIKE 'chuyển đi')) ";
                            default -> {
                            }
                        }
                    } else {
                        if (txtTuNgay.getText().trim().isEmpty()) {
                            txtTuNgay.setText("1920-1-1");
                        }
                        if (txtDenNgay.getText().trim().isEmpty()) {
                            txtDenNgay.setText("3000-1-1");
                        }
                        switch (cbTinhTrang.getSelectedItem().toString().trim()) {
                            case "Sinh sống và có hộ khẩu tại đây" ->
                                query += "WHERE ((tinhtrang LIKE 'sinh sống' "
                                        + "OR tinhtrang LIKE 'chuyển đi' OR tinhtrang LIKE 'đã mất' "
                                        + "OR (tinhtrang LIKE 'cập nhật' AND tungay > '" + txtTuNgay.getText().trim() + "')) "
                                        + "AND ngaychuyenden <= '" + txtDenNgay.getText().trim() + "' "
                                        + "AND ngaychuyendi >= '" + txtTuNgay.getText().trim() + "') ";
                            case "Tạm trú" ->
                                query += "WHERE (tinhtrang LIKE 'tạm trú' AND tungay <= '" + txtDenNgay.getText().trim() + "' "
                                        + "AND denngay >= '" + txtTuNgay.getText().trim() + "') ";
                            case "Tạm vắng" ->
                                query += "WHERE (tinhtrang LIKE 'tạm vắng' AND tungay <= '" + txtDenNgay.getText().trim() + "' "
                                        + "AND denngay >= '" + txtTuNgay.getText().trim() + "') ";
                            case "Qua đời/Chuyển đi" ->
                                query += "WHERE (((tinhtrang LIKE 'đã mất') OR (tinhtrang LIKE 'chuyển đi')) "
                                        + "AND ngaychuyendi <= '" + txtDenNgay.getText().trim() + "' "
                                        + "AND ngaychuyendi >= '" + txtTuNgay.getText().trim() + "') ";
                            default -> {
                            }
                        }
                    }
                }

                if (!cbGioiTinh.getSelectedItem().toString().trim().equals("Toàn bộ")) {
                    query += "AND gioitinh LIKE '" + cbGioiTinh.getSelectedItem().toString().trim() + "' ";
                }

                if (!txtTuTuoi.getText().trim().isEmpty()) {
                    query += "AND ROUND(DATEDIFF(CURDATE(), ngaysinh) / 365, 0) >= " + txtTuTuoi.getText().trim() + " ";
                }

                if (!txtDenTuoi.getText().trim().isEmpty()) {
                    query += "AND ROUND(DATEDIFF(CURDATE(), ngaysinh) / 365, 0) <= " + txtDenTuoi.getText().trim() + " ";
                }

                if (!ngheNghiep.isEmpty()) {
                    query += "AND nghenghiep LIKE '" + ngheNghiep + "' ";
                }
                
                query += "ORDER BY mahokhau, ngaysinh";

                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        NhanKhauModel nhanKhau = new NhanKhauModel();

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

                        list.add(nhanKhau);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return list;
    }

}
