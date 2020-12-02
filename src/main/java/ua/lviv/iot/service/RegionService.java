package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.RegionDaoImpl;
import ua.lviv.iot.model.Region;

import java.util.List;

public class RegionService {
  public List<Region> findAll() {
    return new RegionDaoImpl().findAll();
  }

  public Region findById(Integer id) {
    return new RegionDaoImpl().findById(id);
  }

  public int create(Region entity) {
    return new RegionDaoImpl().create(entity);
  }

  public int update(Region entity) {
    return new RegionDaoImpl().update(entity);
  }

  public int delete(Integer id) {
    return new RegionDaoImpl().delete(id);
  }
}
