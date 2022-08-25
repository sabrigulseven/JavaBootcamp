package com.godoro.filer;

import java.util.ArrayList;
import java.util.List;

public class TestStore2 {
    public static void main(String[] args) {
        try {
            List<Customer> customerList = new ArrayList<>();
            customerList.add(new Customer(601,"Cem Karaca", 3356));
            customerList.add(new Customer(602,"Barşı Manço", 6662));
            customerList.add(new Customer(603,"Erkin Koray", 2321));
            customerList.add(new Customer(604,"İlhan İrem", 3121));
            customerList.add(new Customer(605,"Özkan Uğur", 5412));

            String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Customers.txt";
            CustomerFiler customerFiler = new CustomerFiler(path);
            customerFiler.store(customerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
