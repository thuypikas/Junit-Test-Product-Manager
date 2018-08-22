package model;


import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Product;

public class ProductDAO {
	public boolean insertProduct(Product product) {
		Session session = HibernateUtil.getSession(Product.class);
		try {
			
			if(product.getBrand().length()>10 || product.getPrice() >= 10000000000.0) {
				return false;
			}
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void updateProduct(Product product) {
		Session session = HibernateUtil.getSession(Product.class);
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Product product) {
		Session session = HibernateUtil.getSession(Product.class);
		try {
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllProduct(){
		Session session = HibernateUtil.getSession(Product.class);
		try {
			session.beginTransaction();
			String hql = "delete from Product";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
