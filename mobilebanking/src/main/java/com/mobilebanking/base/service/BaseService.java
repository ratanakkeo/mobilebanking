package com.mobilebanking.base.service;

import com.mobilebanking.base.model.BaseModel;
import com.mobilebanking.base.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseService<T extends BaseModel> {

    protected BaseRepository<T> repository;

    @Autowired
    public void setRepository(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
