package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static Session getSession(Class<?> data) {
		SessionFactory fac = new Configuration().configure().addAnnotatedClass(data).buildSessionFactory();
		return fac.getCurrentSession();
	}
}
