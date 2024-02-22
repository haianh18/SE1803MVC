/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author laivu
 */
public class Shippers {
    private int IDENTITY;
    private String CompanyName, Phone;

    public Shippers() {
    }

    public Shippers(int IDENTITY, String CompanyName, String Phone) {
        this.IDENTITY = IDENTITY;
        this.CompanyName = CompanyName;
        this.Phone = Phone;
    }

    public int getIDENTITY() {
        return IDENTITY;
    }

    public void setIDENTITY(int IDENTITY) {
        this.IDENTITY = IDENTITY;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Shippers{" + "IDENTITY=" + IDENTITY + ", CompanyName=" + CompanyName + ", Phone=" + Phone + '}';
    }
    
}
