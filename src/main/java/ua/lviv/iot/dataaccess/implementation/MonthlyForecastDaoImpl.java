package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.MonthlyForecastDao;
import ua.lviv.iot.model.MonthlyForecast;
import ua.lviv.iot.model.MonthlyForecastPK;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class MonthlyForecastDaoImpl implements MonthlyForecastDao {
  @Override
  public List<MonthlyForecast> findAll() {
    List<MonthlyForecast> monthlyForecasts;
    try (Session session = SessionManager.getSession()) {
      monthlyForecasts = session.createQuery("from MonthlyForecast").list();
      return monthlyForecasts;
    }
  }

  @Override
  public MonthlyForecast findById(MonthlyForecastPK monthlyForecastPK) {
    try (Session session = SessionManager.getSession()) {
      return session.get(MonthlyForecast.class, monthlyForecastPK);
    }
  }

  @Override
  public int create(MonthlyForecast entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
      return 1;
    }

  }

  @Override
  public int update(MonthlyForecast entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
      return 1;
    }
  }

  @Override
  public int delete(MonthlyForecastPK monthlyForecastPK) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      int rowsDeleted = session
          .createQuery("DELETE FROM MonthlyForecast where year = :year AND month = :month")
          .setParameter("year", monthlyForecastPK.getYear())
          .setParameter("month", monthlyForecastPK.getMonth())
          .executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
