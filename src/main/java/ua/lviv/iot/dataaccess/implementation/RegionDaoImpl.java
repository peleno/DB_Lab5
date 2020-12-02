package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.RegionDao;
import ua.lviv.iot.model.Region;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class RegionDaoImpl implements RegionDao {


  @Override
  public List<Region> findAll() {
    List<Region> regions;
    try (Session session = SessionManager.getSession()) {
      regions = session.createQuery("from Region ").list();
      return regions;
    }
  }

  @Override
  public Region findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(Region.class, id);
    }
  }

  @Override
  public int create(Region entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
    }
    return 1;
  }

  @Override
  public int update(Region entity) {
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
      int rowsDeleted = session.createQuery("DELETE FROM Region where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
