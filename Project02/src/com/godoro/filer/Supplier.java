package com.godoro.filer;

public class Supplier {
    private long supplierId;
    private String supplierName;
    private double totalCredit;

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Supplier() {
    }

    public Supplier(long supplierId, String supplierName, double totalCredit) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.totalCredit = totalCredit;
    }

}
