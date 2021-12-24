/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Function5;

import com.mysql.cj.jdbc.Blob;
import displays.Function5Manager.QuanLyQua;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.PhanQuaModel;
import models.TangQuaModel;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class TangQuaController {

    public PhanQuaModel getPhanQua(String tenDip) {
        PhanQuaModel phanQua = new PhanQuaModel();

        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT *  FROM phanqua WHERE dip LIKE '" + tenDip + "' "
                        + "AND tinhtrang LIKE 'đang tặng'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                try ( ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        phanQua.setId(rs.getInt("id"));
                        phanQua.setThoiGian(rs.getDate("thoigian"));
                        phanQua.setDip(rs.getString("dip"));
                        phanQua.setGiaTri(rs.getInt("giatri"));
                        phanQua.setTongQua(rs.getInt("tongqua"));
                        phanQua.setTongGiaTri(rs.getInt("tonggiatri"));
                        phanQua.setTaoDS(rs.getString("taods"));
                        phanQua.setTinhTrang(rs.getString("tinhtrang"));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phanQua;
    }

    public List<TangQuaModel> getListTangQua(int id) {
        List<TangQuaModel> list = new ArrayList<>();

        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT *  FROM tangqua WHERE idphanqua = " + id + " ";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                try ( ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        TangQuaModel tq = new TangQuaModel();

                        tq.setId(rs.getInt("id"));
                        tq.setIdPhanQua(rs.getInt("idphanqua"));
                        tq.setMaHoKhau(rs.getString("mahokhau"));
                        tq.setHoTen(rs.getString("hoten"));
                        tq.setNgaySinh(rs.getDate("ngaysinh"));
                        tq.setGioiTinh(rs.getString("gioitinh"));
                        tq.setSoLuong(rs.getInt("soluong"));
                        try {
                            Blob blob = (Blob) rs.getBlob("minhchung");
                            InputStream inputStream = blob.getBinaryStream();
                            tq.setMinhChung(inputStream);
                        } catch (NullPointerException ex) {
                        }

                        list.add(tq);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void themTangQua(TangQuaModel tq) {
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "INSERT INTO tangqua(idphanqua, mahokhau, hoten, gioitinh, ngaysinh, soluong, minhchung) "
                        + "VALUES (?,?,?,?,?,?,?)";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    st.setInt(1, tq.getIdPhanQua());
                    st.setString(2, tq.getMaHoKhau());
                    st.setString(3, tq.getHoTen());
                    st.setString(4, tq.getGioiTinh());
                    Date ngaySinh = new Date(tq.getNgaySinh().getTime());
                    st.setDate(5, ngaySinh);
                    st.setInt(6, tq.getSoLuong());
                    st.setBlob(7, tq.getMinhChung());

                    st.execute();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<TangQuaModel> thongKeTheoHK(int id) {
        List<TangQuaModel> list = new ArrayList<>();

        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT tangqua.mahokhau, B.hoten, SUM(soluong) AS sl FROM tangqua INNER JOIN "
                        + "(SELECT mahokhau, hoten  FROM hokhau INNER JOIN "
                        + "(SELECT DISTINCT cmnd, hoten FROM nhankhau) AS A "
                        + "ON hokhau.cmndchuho = A.cmnd) AS B "
                        + "ON tangqua.mahokhau = B.mahokhau "
                        + "WHERE idphanqua = " + id + " "
                        + "GROUP BY tangqua.mahokhau";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                try ( ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        TangQuaModel tq = new TangQuaModel();

                        tq.setMaHoKhau(rs.getString("tangqua.mahokhau"));
                        tq.setHoTen(rs.getString("B.hoten"));
                        tq.setSoLuong(rs.getInt("sl"));

                        list.add(tq);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void capNhatSoLuongTQ(TangQuaModel tq, int id, String maHK, String hoTen) {
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "UPDATE tangqua SET soluong = ? WHERE idphanqua = " + id + " "
                        + "AND mahokhau LIKE '" + maHK + "' AND hoten LIKE '" + hoTen + "'";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    st.setInt(1, tq.getSoLuong());

                    st.execute();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void capNhatMinhChungTQ(TangQuaModel tq, int id, String maHK, String hoTen) {
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "UPDATE tangqua SET minhchung = ? WHERE idphanqua = " + id + " "
                        + "AND mahokhau LIKE '" + maHK + "' AND hoten LIKE '" + hoTen + "'";
                try ( PreparedStatement st = connection.prepareStatement(query)) {
                    st.setBlob(1, tq.getMinhChung());

                    st.execute();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void capNhatPQ(PhanQuaModel tq, int id) {
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "UPDATE phanqua SET giatri = ?, tongqua = ?, tonggiatri = ?, taods = ? WHERE id = " + id;
                try ( PreparedStatement st = connection.prepareStatement(query)) {

                    st.setInt(1, tq.getGiaTri());
                    st.setInt(2, tq.getTongQua());
                    st.setInt(3, tq.getTongGiaTri());
                    st.setString(4, tq.getTaoDS());

                    st.execute();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<TangQuaModel> findByCondition(int id, String key) {
        if (key.isEmpty()) {
            return this.getListTangQua(id);
        }
        List<TangQuaModel> list = new ArrayList<>();

        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "SELECT *  FROM tangqua WHERE idphanqua = " + id + " AND hoten LIKE '%" + key + "%'";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                try ( ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        TangQuaModel tq = new TangQuaModel();

                        tq.setId(rs.getInt("id"));
                        tq.setIdPhanQua(rs.getInt("idphanqua"));
                        tq.setMaHoKhau(rs.getString("mahokhau"));
                        tq.setHoTen(rs.getString("hoten"));
                        tq.setNgaySinh(rs.getDate("ngaysinh"));
                        tq.setGioiTinh(rs.getString("gioitinh"));
                        tq.setSoLuong(rs.getInt("soluong"));
                        try {
                            Blob blob = (Blob) rs.getBlob("minhchung");
                            InputStream inputStream = blob.getBinaryStream();
                            tq.setMinhChung(inputStream);
                        } catch (NullPointerException ex) {
                        }

                        list.add(tq);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLyQua.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
