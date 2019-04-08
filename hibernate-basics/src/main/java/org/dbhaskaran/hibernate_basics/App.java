package org.dbhaskaran.hibernate_basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(45);
		p1.setFirstName("Sam");
		p1.setLastName("Tolety");
		p1.setCountry("Italy");

		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		session.save(p1);
		txn.commit();
	}
}
