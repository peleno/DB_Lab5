package ua.lviv.iot.service;

import ua.lviv.iot.dataaccess.implementation.WorldPartDaoImpl;
import ua.lviv.iot.model.WorldPart;

import java.util.List;

public class WorldPartService {
  public List<WorldPart> findAll() {
    return new WorldPartDaoImpl().findAll();

  }

  public WorldPart findById(Integer id) {
    return new WorldPartDaoImpl().findById(id);

  }

  public int create(WorldPart worldPart) {
    return new WorldPartDaoImpl().create(worldPart);
  }

  public int update(WorldPart worldPart) {
    return new WorldPartDaoImpl().update(worldPart);

  }

  public int delete(Integer id) {
    return new WorldPartDaoImpl().delete(id);

  }
}
