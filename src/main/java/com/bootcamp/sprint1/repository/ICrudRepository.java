package com.bootcamp.sprint1.repository;

import java.util.List;

public interface ICrudRepository <T,U>{
    T create(T t);
    List<T> findAll();
    T delete(U u);
    T findById(U u);
}
