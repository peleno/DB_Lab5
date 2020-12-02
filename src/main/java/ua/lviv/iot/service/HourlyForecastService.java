package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.HourlyForecastDaoImpl;
import ua.lviv.iot.model.HourlyForecast;

import java.util.List;

public class HourlyForecastService {
  public List<HourlyForecast> findAll() {
    return new HourlyForecastDaoImpl().findAll();
  }

  public HourlyForecast findById(Integer id) {
    return new HourlyForecastDaoImpl().findById(id);
  }

  public int create(HourlyForecast entity) {
    return new HourlyForecastDaoImpl().create(entity);
  }

  public int update(HourlyForecast entity) {
    return new HourlyForecastDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new HourlyForecastDaoImpl().delete(id);
  }
}
