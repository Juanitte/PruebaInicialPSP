package DAO;

import java.util.List;

public interface DAO<T> extends AutoCloseable {

    List<T> findAll() throws Exception;
    T findByName(String dni) throws Exception;
    T save(T entity) throws Exception;
    void delete(T entity) throws Exception;

}
