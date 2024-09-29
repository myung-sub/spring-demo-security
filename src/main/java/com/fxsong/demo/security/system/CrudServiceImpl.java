package com.fxsong.demo.security.system;

import org.springframework.data.repository.CrudRepository;

public class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    protected final CrudRepository<T, ID> repo;

    public CrudServiceImpl(CrudRepository<T, ID> repo) {
        this.repo = repo;
    }

    @Override
    public T create(T entity) {
        return repo.save(entity);
    }

    @Override
    public T modify(ID id, T entity) {
        return repo.save(entity);
    }

    @Override
    public void remove(ID id) {
        repo.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return repo.findById(id).orElse(null);
    }

}
