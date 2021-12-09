/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author louis
 */
public class QuyPhanThuongModel {
    private int soDu;
    private String moTa;
    private String thoiGian;

    public QuyPhanThuongModel() {
    }

    public QuyPhanThuongModel(int soDu, String moTa, String thoiGian) {
        this.soDu = soDu;
        this.moTa = moTa;
        this.thoiGian = thoiGian;
    }

    public int getSoDu() {
        return soDu;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setSoDu(int soDu) {
        this.soDu = soDu;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
    
    
}
