package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.PrecipitationDao;
import ua.lviv.iot.model.Precipitation;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class PrecipitationDaoImpl implements PrecipitationDao {
  @Override
  public List<Precipitation> findAll() {
    List<Precipitation> precipitations;
    try (Session session = SessionManager.getSession()) {
      precipitations = session.createQuery("from Precipitation ").list();
      return precipitations;
    }
  }

  @Override
  public Precipitation findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(Precipitation.class, id);
    }
  }

  @Override
  public int create(Precipitation entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
    return 1;
  }

  @Override
  public int update(Precipitation entity) {
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
      int rowsDeleted = session.createQuery("DELETE FROM Precipitation where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
