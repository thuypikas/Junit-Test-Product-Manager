package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Account;

public class AccountDAO {
	public boolean checkAccount(String user, String pass) {
		Session session = HibernateUtil.getSession(Account.class);
		try {
			if (user.equals(null) || pass.equals(null) || user.equals("") || pass.equals("") || pass.length() < 3) {
				return false;
			}
			session.beginTransaction();
			String hql = "from Account where username = '" + user + "' and pass = '" + pass + "'";
			Query<Account> query = session.createQuery(hql);
			ArrayList<Account> lst = (ArrayList<Account>) query.list();
			session.getTransaction().commit();
			if (lst.size() >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean insertAccount(Account account) {
		Session session = HibernateUtil.getSession(Account.class);
		try {
			if (account.getUsername().equals(null) || account.getPass().equals(null) || account.getUsername().equals("")
					|| account.getPass().equals("") || account.getPass().length() < 3) {
				return false;
			} else {
				Pattern pt = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9]{0,49}");
				Matcher mt = pt.matcher(account.getUsername());
				if (!mt.matches()) {
					return false;
				}
				session.beginTransaction();
				session.save(account);
				session.getTransaction().commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void updateAccount(Account account) {
		Session session = HibernateUtil.getSession(Account.class);
		try {
			session.beginTransaction();
			session.update(account);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAccount(Account account) {
		Session session = HibernateUtil.getSession(Account.class);
		try {
			session.beginTransaction();
			String hql = "delete from Account";
			Query query = session.createQuery(hql);
			session.delete(account);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAllAccount() {
		Session session = HibernateUtil.getSession(Account.class);
		try {
			session.beginTransaction();
			String hql = "delete from Account";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
