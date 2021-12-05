/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Function1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.HoKhauModel;
import models.NhanKhauModel;
import utilities.MysqlConnection;

/**
 *
 * @author Loc Nguyen
 */
public class CapNhatController {

    public void capNhatNK(int id, NhanKhauModel nhanKhau) {
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "UPDATE nhankhau SET hoten = ?, bidanh = ?, tongiao = ?, quoctich = ?, nghenghiep = ?, "
                        + "noilamviec = ?, cmnd = ?, ngaycap = ?, noicap = ?, ngaychuyendi = ?, noiden = ?, tinhtrang = ?, "
                        + "tungay = ?, denngay = ?, dchiennay = ? WHERE id = " + id;
                try ( PreparedStatement st = connection.prepareStatement(query)) {

                    st.setString(1, nhanKhau.getHoTen());
                    st.setString(2, nhanKhau.getBiDanh());
                    st.setString(3, nhanKhau.getTonGiao());
                    st.setString(4, nhanKhau.getQuocTich());
                    st.setString(5, nhanKhau.getNgheNghiep());
                    st.setString(6, nhanKhau.getNoiLamViec());
                    st.setString(7, nhanKhau.getCmnd());
                    if (nhanKhau.getNgayCap() != null) {
                        Date ngayCap = new Date(nhanKhau.getNgayCap().getTime());
                        st.setDate(8, ngayCap);
                    } else {
                        st.setDate(8, null);
                    }
                    st.setString(9, nhanKhau.getNoiCap());
                    if (nhanKhau.getNgayChuyenDi() != null) {
                        Date ngayChuyenDi = new Date(nhanKhau.getNgayChuyenDi().getTime());
                        st.setDate(10, ngayChuyenDi);
                    } else {
                        st.setDate(10, null);
                    }
                    st.setString(11, nhanKhau.getNoiDen());
                    st.setString(12, nhanKhau.getTinhTrang());
                    if (nhanKhau.getTuNgay() != null) {
                        Date tuNgay = new Date(nhanKhau.getTuNgay().getTime());
                        st.setDate(13, tuNgay);
                    } else {
                        st.setDate(13, null);
                    }
                    if (nhanKhau.getDenNgay() != null) {
                        Date denNgay = new Date(nhanKhau.getDenNgay().getTime());
                        st.setDate(14, denNgay);
                    } else {
                        st.setDate(14, null);
                    }
                    st.setString(15, nhanKhau.getDcHienNay());

                    st.execute();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void capNhatHK(int id, HoKhauModel hoKhau) {
        try {
            try ( Connection connection = MysqlConnection.getMysqlConnection()) {
                String query = "UPDATE hokhau SET tinhtrang = ?, ngaychuyendi = ? WHERE id = " + id;
                try ( PreparedStatement st = connection.prepareStatement(query)) {

                    st.setString(1, hoKhau.getTinhTrang());
                    if (hoKhau.getNgayChuyenDi()!= null) {
                        Date ngayChuyenDi = new Date(hoKhau.getNgayChuyenDi().getTime());
                        st.setDate(2, ngayChuyenDi);
                    } else {
                        st.setDate(2, null);
                    }
                    
                    st.execute();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }
}
