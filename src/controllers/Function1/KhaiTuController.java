/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Function1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.NhanKhauModel;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class KhaiTuController {

    public KhaiTuController() {
    }

    //Kiem tra nhan khau da ton tai trong db voi tinh trang 'sinh song' hoac 'cap nhat' chua
    public boolean checkCmndSs_Cn(String cmnd) {
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT cmnd FROM nhankhau "
                        + "WHERE nhankhau.tinhtrang LIKE 'sinh sống' "
                        + "OR tinhtrang LIKE 'cập nhật' ";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        if (cmnd.equals(rs.getString("cmnd"))) {
                            return false;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    public List<NhanKhauModel> findByCondition(String key) {

        List<NhanKhauModel> list = new ArrayList<>();
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT * FROM nhankhau "
                        + "LEFT JOIN (SELECT idnhankhau, mahokhau FROM giadinh INNER JOIN hokhau ON hokhau.id = giadinh.idhokhau) AS A "
                        + "ON nhankhau.id = A.idnhankhau "
                        + "WHERE (cmnd LIKE '%" + key + "%' OR hoten LIKE '%" + key + "%') "
                        + "AND (tinhtrang LIKE 'sinh sống' "
                        + "OR tinhtrang LIKE 'cập nhật') "
                        + "ORDER BY mahokhau";
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

    /*public boolean checkQuanHe(int id1, int id2){
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT a.idnhankhau as id1, b.idnhankhau as id2 FROM giadinh as a INNER JOIN giadinh as b "
                        + "on a.idhokhau = b.idhokhau where a.idnhankhau <> b.idnhankhau";
                try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {
                        if (id1 == rs.getInt("id1") && id2 == rs.getInt("id2")) {
                            return true;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }*/
    
     
}
