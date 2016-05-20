package com.nihilent.dao;

import org.springframework.stereotype.Repository;

import com.nihilent.common.dao.GenericDAOImpl;
import com.nihilent.model.Customer;

@Repository
public class CustomerDaoImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDao {

}
