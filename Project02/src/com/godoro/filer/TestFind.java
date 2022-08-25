package com.godoro.filer;

import java.util.ArrayList;
import java.util.List;

public class TestFind {
    private static Supplier find(List<Supplier> supplierList, long supplierId) {
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplierId() == supplierId) {
                return supplier;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Supplier> supplierList = new ArrayList<>();
        supplierList.add(new Supplier(601, "Cem Karaca", 3356));
        supplierList.add(new Supplier(602, "Barış Manço", 6662));
        supplierList.add(new Supplier(603, "Erkin Koray", 2321));
        
        System.out.println(find(supplierList, 602).getSupplierName()); 
    }
}
