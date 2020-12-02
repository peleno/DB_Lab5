package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.PrecipitationDaoImpl;
import ua.lviv.iot.model.Precipitation;

import java.util.List;

public class PrecipitationService {
  public List<Precipitation> findAll() {
    return new PrecipitationDaoImpl().findAll();
  }

  public Precipitation findById(Integer id) {
    return new PrecipitationDaoImpl().findById(id);
  }

  public int create(Precipitation entity) {
    return new PrecipitationDaoImpl().create(entity);
  }

  public int update(Precipitation entity) {
    return new PrecipitationDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new PrecipitationDaoImpl().delete(id);
  }
}
