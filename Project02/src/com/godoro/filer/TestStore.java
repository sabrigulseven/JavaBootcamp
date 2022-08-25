package com.godoro.filer;

import java.util.ArrayList;
import java.util.List;

public class TestStore {
    public static void main(String[] args) {
        try {
            List<Supplier> supplierList = new ArrayList<>();
            supplierList.add(new Supplier(601,"Cem Karaca", 3356));
            supplierList.add(new Supplier(602,"Barış Manço", 6662));
            supplierList.add(new Supplier(603,"Erkin Koray", 2321));

            String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Suppliers.txt";
            SupplierFiler supplierFiler = new SupplierFiler(path);
            supplierFiler.store(supplierList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
