package com.fxsong.demo.security.system;

import org.springframework.web.bind.annotation.*;

public abstract class CrudController<T, ID> {

    protected final CrudService<T, ID> service;

    public CrudController(CrudService<T, ID> service) {
        this.service = service;
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    @GetMapping("{id}")
    public T findOne(@PathVariable ID id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public T modify(@PathVariable ID id, @RequestBody T entity) {
        return service.modify(id, entity);
    }

    @DeleteMapping("{id}")
    public void remove(ID id) {
        service.remove(id);
    }

}
