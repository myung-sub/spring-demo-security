package com.fxsong.demo.security.system;

public interface CrudService<T, ID> {
    T create(T entity);

    T modify(ID id, T entity);

    void remove(ID id);

    T findById(ID id);

}
