package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.HourlyForecastDao;
import ua.lviv.iot.model.HourlyForecast;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class HourlyForecastDaoImpl implements HourlyForecastDao {

  @Override
  public List<HourlyForecast> findAll() {
    List<HourlyForecast> hourlyForecasts;
    try (Session session = SessionManager.getSession()) {
      hourlyForecasts = session.createQuery("from HourlyForecast").list();
      return hourlyForecasts;
    }
  }

  @Override
  public HourlyForecast findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(HourlyForecast.class, id);
    }
  }

  @Override
  public int create(HourlyForecast entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
      return 1;
    }
  }

  @Override
  public int update(HourlyForecast entity) {
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
      int rowsDeleted = session.createQuery("DELETE FROM HourlyForecast where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
