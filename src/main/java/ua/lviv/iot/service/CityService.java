package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.CityDaoImpl;
import ua.lviv.iot.model.City;

import java.util.List;

public class CityService {
  public List<City> findAll() {
    return new CityDaoImpl().findAll();
  }

  public City findById(Integer id) {
    return new CityDaoImpl().findById(id);
  }

  public int create(City entity) {
    return new CityDaoImpl().create(entity);
  }

  public int update(City entity) {
    return new CityDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new CityDaoImpl().delete(id);
  }
}
