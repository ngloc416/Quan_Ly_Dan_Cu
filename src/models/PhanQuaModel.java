/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author louis
 */
public class PhanQuaModel {
    private int id;
    private Date thoiGian;
    private String dip;
    private int giaTri;
    private int tongQua;
    private int tongGiaTri;
    private String taoDS;
    private String tinhTrang;

    public String getTaoDS() {
        return taoDS;
    }

    public void setTaoDS(String taoDS) {
        this.taoDS = taoDS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDip() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public int getTongQua() {
        return tongQua;
    }

    public void setTongQua(int tongQua) {
        this.tongQua = tongQua;
    }

    public int getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(int tongGiaTri) {
        this.tongGiaTri = tongGiaTri;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
