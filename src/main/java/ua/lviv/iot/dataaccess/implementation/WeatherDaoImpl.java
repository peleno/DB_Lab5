package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.WeatherDao;
import ua.lviv.iot.model.Weather;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class WeatherDaoImpl implements WeatherDao {
  @Override
  public List<Weather> findAll() {
    List<Weather> weathers;
    try (Session session = SessionManager.getSession()) {
      weathers = session.createQuery("from Weather").list();
      return weathers;
    }
  }

  @Override
  public Weather findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(Weather.class, id);
    }
  }

  @Override
  public int create(Weather entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
      return 1;
    }
  }

  @Override
  public int update(Weather entity) {
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
      int rowsDeleted = session.createQuery("DELETE FROM Weather where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
