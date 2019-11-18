package com.ujiuye.cus.service;

import com.ujiuye.cus.bean.Customer;

import java.util.List;

public interface CustomerService {

    int insert(Customer customer);

    List<Customer> getCustomerList();

    Customer getCustomerDetail(Integer cid);

    void update(Customer customer);

    boolean batchDel(Integer[] ids);

    List<Customer> search(Integer cid, String keyword, Integer orderby);
}
