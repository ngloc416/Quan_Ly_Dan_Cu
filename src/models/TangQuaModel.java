/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Loc Nguyen
 */
public class TangQuaModel {

    private int id;
    private int idPhanQua;
    private String maHoKhau;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private int soLuong;
    private int giaTri;
    private InputStream minhChung;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPhanQua() {
        return idPhanQua;
    }

    public void setIdPhanQua(int idPhanQua) {
        this.idPhanQua = idPhanQua;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public InputStream getMinhChung() {
        return minhChung;
    }

    public void setMinhChung(InputStream minhChung) {
        this.minhChung = minhChung;
    }
}
