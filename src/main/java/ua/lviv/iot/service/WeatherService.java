package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.WeatherDaoImpl;
import ua.lviv.iot.model.Weather;

import java.util.List;

public class WeatherService {
  public List<Weather> findAll() {
    return new WeatherDaoImpl().findAll();
  }

  public Weather findById(Integer id) {
    return new WeatherDaoImpl().findById(id);
  }

  public int create(Weather entity) {
    return new WeatherDaoImpl().create(entity);
  }

  public int update(Weather entity) {
    return new WeatherDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new WeatherDaoImpl().delete(id);
  }
}
