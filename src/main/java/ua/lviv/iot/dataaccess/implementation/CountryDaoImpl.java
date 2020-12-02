package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.CountryDao;
import ua.lviv.iot.model.Country;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;


public class CountryDaoImpl implements CountryDao {

  @Override
  public List<Country> findAll() {
    List<Country> countries;
    try (Session session = SessionManager.getSession()) {
      countries = session.createQuery("from Country ").list();
      return countries;
    }
  }

  @Override
  public Country findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(Country.class, id);
    }
  }

  @Override
  public int create(Country entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
      return 1;
    }
  }

  @Override
  public int update(Country entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
      return 1;
    }
  }

  @Override
  public int delete(Integer id) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      int rowsDeleted = session.createQuery("DELETE FROM Country where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
