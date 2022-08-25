package com.godoro.filer;

import java.util.List;

public class TestLoad2 {
    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\Sabri\\Desktop\\workspace\\Customers.txt";
            CustomerFiler customerFiler = new CustomerFiler(path);
            List<Customer> customerList = customerFiler.load();
            for (Customer customer : customerList) {
                System.out.println(customer.getCustomerId() + " "
                        + customer.getCustomerName() + " "
                        + customer.getTotalDebit());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
