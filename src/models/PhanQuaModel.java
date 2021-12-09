/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author louis
 */
public class PhanQuaModel {
    private String dip;
    private int thanhTien;
    
    public PhanQuaModel(){
    }

    public PhanQuaModel(String dip, int thanhTien) {
        this.dip = dip;
        this.thanhTien = thanhTien;
    }

    public String getDip() {
        return dip;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
