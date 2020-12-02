package ua.lviv.iot.dataaccess.implementation;

import org.hibernate.Session;
import ua.lviv.iot.dataaccess.WorldPartDao;
import ua.lviv.iot.model.WorldPart;
import ua.lviv.iot.persistent.SessionManager;

import java.util.List;

public class WorldPartDaoImpl implements WorldPartDao {


  @Override
  public List<WorldPart> findAll() {
    List<WorldPart> worldParts;
    try (Session session = SessionManager.getSession()) {
      worldParts = session.createQuery("from WorldPart ").list();
      return worldParts;
    }
  }

  @Override
  public WorldPart findById(Integer id) {
    try (Session session = SessionManager.getSession()) {
      return session.get(WorldPart.class, id);
    }
  }

  @Override
  public int create(WorldPart entity) {
    try (Session session = SessionManager.getSession()) {
      session.beginTransaction();
      session.save(entity);
      session.getTransaction().commit();
      return 1;
    }

  }

  @Override
  public int update(WorldPart entity) {
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
      int rowsDeleted = session.createQuery("DELETE FROM WorldPart where id = :id").setParameter("id", id).executeUpdate();
      session.getTransaction().commit();
      return rowsDeleted;
    }
  }
}
