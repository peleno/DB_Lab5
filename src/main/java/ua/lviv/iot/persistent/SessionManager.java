package ua.lviv.iot.persistent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory != null) {
      return sessionFactory;
    }
    System.out.println("create new session factory");
    Configuration configuration = new Configuration();
    configuration.configure();
    sessionFactory = configuration.buildSessionFactory();
    return sessionFactory;
  }

  public static Session getSession() {

    SessionFactory sessionFactory = getSessionFactory();
    return sessionFactory.openSession();

  }
}
