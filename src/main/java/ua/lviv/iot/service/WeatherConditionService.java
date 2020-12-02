package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.WeatherConditionDaoImpl;
import ua.lviv.iot.model.WeatherCondition;

import java.util.List;

public class WeatherConditionService {
  public List<WeatherCondition> findAll() {
    return new WeatherConditionDaoImpl().findAll();
  }

  public WeatherCondition findById(Integer id) {
    return new WeatherConditionDaoImpl().findById(id);
  }

  public int create(WeatherCondition entity) {
    return new WeatherConditionDaoImpl().create(entity);
  }

  public int update(WeatherCondition entity) {
    return new WeatherConditionDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new WeatherConditionDaoImpl().delete(id);
  }
}
