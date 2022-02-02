/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tutorial.hbm.Event;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(new Event("Our very first event!", new Date()));
            session.save(new Event("A follow up event", new Date()));
            session.getTransaction().commit();
            session.close();

            session = sessionFactory.openSession();
            session.beginTransaction();
            List result = session.createQuery("from Event").list();
            for (Event event : (List<Event>) result) {
                System.out.println("Event (" + event.getDate() + ") : " + event.getTitle());
            }
            session.getTransaction().commit();
            session.close();
        }

        if (sessionFactory != null)
            sessionFactory.close();
    }
}
