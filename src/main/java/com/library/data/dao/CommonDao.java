package com.library.data.dao;

import java.util.List;

public interface CommonDao<T> {
    void add(T t);

    List<T> getAll();

    T findById(Integer id);
}
