package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.MonthlyForecastDaoImpl;
import ua.lviv.iot.model.MonthlyForecast;
import ua.lviv.iot.model.MonthlyForecastPK;

import java.util.List;

public class MonthlyForecastService {
  public List<MonthlyForecast> findAll() {
    return new MonthlyForecastDaoImpl().findAll();
  }

  public MonthlyForecast findById(MonthlyForecastPK monthlyForecastPK) {
    return new MonthlyForecastDaoImpl().findById(monthlyForecastPK);
  }

  public int create(MonthlyForecast entity) {
    return new MonthlyForecastDaoImpl().create(entity);
  }

  public int update(MonthlyForecast entity) {
    return new MonthlyForecastDaoImpl().update(entity);
  }

  public int delete(MonthlyForecastPK monthlyForecastPK) {
    return new MonthlyForecastDaoImpl().delete(monthlyForecastPK);
  }
}
