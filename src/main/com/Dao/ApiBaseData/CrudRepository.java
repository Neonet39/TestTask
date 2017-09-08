package Dao.ApiBaseData;

import java.util.List;

/**
 * Created by Evgeny on 08.09.2017.
 */
public interface CrudRepository<T> {
    int save(T entity);
    T findOne(int ID);
    List<T> getListTable();
    void delete(T entity);
}
