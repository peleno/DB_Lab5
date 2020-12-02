package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.DailyForecastDaoImpl;
import ua.lviv.iot.model.DailyForecast;

import java.util.List;

public class DailyForecastService {
  public List<DailyForecast> findAll() {
    return new DailyForecastDaoImpl().findAll();
  }

  public DailyForecast findById(Integer id) {
    return new DailyForecastDaoImpl().findById(id);
  }

  public int create(DailyForecast entity) {
    return new DailyForecastDaoImpl().create(entity);
  }

  public int update(DailyForecast entity) {
    return new DailyForecastDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new DailyForecastDaoImpl().delete(id);
  }
}
