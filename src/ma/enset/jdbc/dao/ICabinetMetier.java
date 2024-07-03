package ma.enset.jdbc.dao;

import java.util.List;

public interface ICabinetMetier<T> {
   List<T> getAll();
   boolean delete(T o);


}
