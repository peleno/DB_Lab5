package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.DailyForecastDao;
import ua.lviv.iot.model.DailyForecast;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class DailyForecastDaoImpl implements DailyForecastDao {

  @Override
  public List<DailyForecast> findAll() {
    List<DailyForecast> dailyForecasts;
    try (Session session = SessionManager.getSession()) {
      dailyForecasts = session.createQuery("from DailyForecast").list();
      return dailyForecasts;
    }
  }

  @Override
  public DailyForecast findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(DailyForecast.class, id);
    }
  }

  @Override
  public int create(DailyForecast entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
    return 1;
  }

  @Override
  public int update(DailyForecast entity) {
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
      int rowsDeleted = session.createQuery("DELETE FROM DailyForecast where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
