package CRUD;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class LaptopRepo {
  private SqlSessionFactory factory;

  public LaptopRepo() throws IOException {
    Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    factory = new SqlSessionFactoryBuilder().build(reader);
  }

  public void add(Laptop laptop) {
    SqlSession session = factory.openSession();
    session.insert("Laptop.insert", laptop);
    session.commit();
    session.close();
  }
  public Laptop read(int id){
      SqlSession session = factory.openSession();
      Laptop laptop= (Laptop) session.selectOne("Laptop.getById",id);
      session.close();
      return laptop;
  }

  public void update(Laptop laptop){
    SqlSession session = factory.openSession();
    session.update("Laptop.update",laptop);
    session.commit();
    session.close();
  }
    public void delete(int id){
        SqlSession session = factory.openSession();
        session.delete("Laptop.deleteById", id);
        session.commit();
        session.close();
    }

}
