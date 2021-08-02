package org.example.emusicstore.service;

import org.example.emusicstore.model.CustomerOrder;

public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(long cartId);
}
