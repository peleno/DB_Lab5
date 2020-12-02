package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.CityDao;
import ua.lviv.iot.model.City;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class CityDaoImpl implements CityDao {

  @Override
  public List<City> findAll() {
    try (Session session = SessionManager.getSession()) {
      List<City> cities = session.createQuery("from City").list();
      return cities;
    }
  }

  @Override
  public City findById(Integer id) {
    City city;
    try (Session session = SessionManager.getSession()) {
      city = session.get(City.class, id);
      return city;
    }
  }


  @Override
  public int create(City entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
      return 1;
    }
  }

  @Override
  public int update(City entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.update(entity);
      session.getTransaction().commit();
      return 1;
    }
  }

  @Override
  public int delete(Integer id) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      int deleted = session.createQuery("DELETE FROM City WHERE id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return deleted;
    }
  }
}
