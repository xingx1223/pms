package com.ujiuye.cus.service;


import com.ujiuye.cus.bean.Customer;
import com.ujiuye.cus.bean.CustomerExample;
import com.ujiuye.cus.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getCustomerList() {
        CustomerExample example=new CustomerExample();
        return customerMapper.selectByExample(example);
    }

    @Override
    public Customer getCustomerDetail(Integer cid) {
        Customer customer =customerMapper.selectByPrimaryKey(cid);
        return customer;
    }

    @Override
    public void update(Customer customer) {
        int i = customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public boolean batchDel(Integer[] ids) {

        List<Integer> list = Arrays.asList(ids);
        CustomerExample example=new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        int i = customerMapper.deleteByExample(example);
        boolean b=ids.length==i;
        System.out.println(b);
        return b;
    }

    @Override
    public List<Customer> search(Integer cid, String keyword, Integer orderby) {
        CustomerExample example=new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        //判断
        if (cid==0){
            criteria.andComnameLike("%"+keyword+"%");
            CustomerExample.Criteria criteria1 = example.createCriteria();

            criteria1.andCompanypersonLike("%"+keyword+"%");
            example.or(criteria1);
        }else if (cid==1){
            criteria.andComnameLike("%"+keyword+"%");
        }else {
            criteria.andCompanypersonLike("%"+keyword+"%");
        }

        if (orderby==1){
            example.setOrderByClause("id desc");
        }
        List<Customer> customers = customerMapper.selectByExample(example);
        return customers;
    }

    public int insert(Customer customer) {
        customer.setAddtime(new Date());
        return customerMapper.insert(customer);
    }
}
