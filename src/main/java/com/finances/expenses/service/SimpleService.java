package com.finances.expenses.service;

import java.util.List;

public interface SimpleService<T> {

    T get(String id);
    List<T> getAll();
    void create(T body);
    void update(String id, T body);
    void delete(String id);
    void deleteAll();

}
