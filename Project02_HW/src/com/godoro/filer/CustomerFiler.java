package com.godoro.filer;

public class CustomerFiler extends BaseFiler<Customer> {
    public CustomerFiler(String filePath) {
        super(filePath);
    }

    protected String format(Customer customer) {
        StringBuilder builder = new StringBuilder();
        builder.append(customer.getCustomerId()).append(DELIMETER);
        builder.append(customer.getCustomerName()).append(DELIMETER);
        builder.append(customer.getTotalDebit());
        String line = builder.toString();
        return line;
    }

    protected Customer parse(String line) {
        String[] tokens = line.split(DELIMETER);
        Customer customer = new Customer();
        customer.setCustomerId(Long.parseLong(tokens[0]));
        customer.setCustomerName((tokens[1]));
        customer.setTotalDebit(Double.parseDouble(tokens[2]));
        return customer;
    }
}
