package org.dbhaskaran.hibernate_basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(45);
		p1.setFirstName("Emily");
		p1.setLastName("McDowell");
		p1.setCountry("Spain");

		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		session.save(p1);
		txn.commit();
	}
}
