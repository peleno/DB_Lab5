package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.CountryDaoImpl;
import ua.lviv.iot.model.Country;

import java.util.List;

public class CountryService {
  public List<Country> findAll() {
    return new CountryDaoImpl().findAll();
  }

  public Country findById(Integer id) {
    return new CountryDaoImpl().findById(id);
  }

  public int create(Country entity) {
    return new CountryDaoImpl().create(entity);
  }

  public int update(Country entity) {
    return new CountryDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new CountryDaoImpl().delete(id);
  }
}
