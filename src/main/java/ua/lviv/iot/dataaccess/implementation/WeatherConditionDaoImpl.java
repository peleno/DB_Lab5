package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.WeatherConditionDao;
import ua.lviv.iot.model.WeatherCondition;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class WeatherConditionDaoImpl implements WeatherConditionDao {
  @Override
  public List<WeatherCondition> findAll() {
    List<WeatherCondition> weatherConditions;
    try (Session session = SessionManager.getSession()) {
      weatherConditions = session.createQuery("from WeatherCondition ").list();
      return weatherConditions;
    }
  }

  @Override
  public WeatherCondition findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(WeatherCondition.class, id);
    }
  }

  @Override
  public int create(WeatherCondition entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
    return 1;
  }

  @Override
  public int update(WeatherCondition entity) {
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
      int rowsDeleted = session.createQuery("DELETE FROM WeatherCondition where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
