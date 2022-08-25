package com.godoro.filer;

import java.io.IOException;
import java.util.List;

public class TestLoad {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Suppliers.txt";
        SupplierFiler supplierFiler = new SupplierFiler(path);
        List<Supplier> supplierList = supplierFiler.load();
        for (Supplier supplier : supplierList) {
            System.out.println(supplier.getSupplierId() + " " 
            + supplier.getSupplierName() + " " 
            + supplier.getTotalCredit());
        }
    }
}
