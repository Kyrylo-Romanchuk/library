package com.library.data.dao;

import java.util.List;

public interface CommonDao<T> {
    void add(T t);

    void delete(Integer id);

    void save(T t);

    List<T> getAll();

    T findById(Integer id);
}
