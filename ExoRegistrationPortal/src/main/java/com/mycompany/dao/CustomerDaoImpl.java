package com.mycompany.dao;

import org.springframework.stereotype.Repository;

import com.mycompany.common.dao.GenericDAOImpl;
import com.mycompany.model.Customer;

@Repository
public class CustomerDaoImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDao {

}
