package com.sdacademy.programcasierie.persistence.dao;

import com.sdacademy.programcasierie.persistence.model.Model;
import java.util.List;
import java.util.Optional;

public interface Dao<T extends Model> {

    List<T> getAll();

    Optional<T> findById(String id);

    void remove(String id);

    void add(T objectToBeAdded);
}
