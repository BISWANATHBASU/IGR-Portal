package com.igr.hibernate.util;
import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.igr.commonUtility.CommonHelper;


 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
    /*private static final Logger log = Logger.getLogger(HibernateUtil.class);*/
    private static Logger log = Logger.getLogger(HibernateUtil.class);
    private static CommonHelper helper = new CommonHelper();
 
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Exception ex) {
        	log.fatal("Database Connection Hibernate File Exception---"+ex);
        	ex.printStackTrace();
        	log.fatal(helper.writeLogInUpperCase(ex));
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}