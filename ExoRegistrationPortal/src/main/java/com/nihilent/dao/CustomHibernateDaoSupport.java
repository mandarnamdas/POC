package com.nihilent.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

    Logger logger = Logger.getLogger(CustomHibernateDaoSupport.class);

    @Autowired
    public void setCustomSessionFactory(SessionFactory sessionFactory) {
        if (logger.isDebugEnabled()) {
            logger.debug("Initializing Session Factory");
        }
        setSessionFactory(sessionFactory);
    }
}
