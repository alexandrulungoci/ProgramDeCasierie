package com.sdacademy.programcasierie.persistence.dao;

import com.sdacademy.programcasierie.persistence.model.Model;

import java.util.List;
import java.util.Optional;

public abstract class ModelDao<T extends Model> implements Dao<T> {

    private String fileName;
    private ObjectFileScanner<T> genericFileReader = new ObjectFileScanner<T>();

    public ModelDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<T> getAll() {
        return genericFileReader.readFromFile(fileName);
    }

    @Override
    public Optional<T> findById(String id) {
        List<T> models = getAll();
        return findInList(models, id);
    }

    private Optional<T> findInList(List<T> models, String id) {
        if (models.isEmpty()) {
            return Optional.empty();
        }
        for (T model : models) {
            if (model.getId().equals(id)) {
                return Optional.of(model);
            }
        }
        return Optional.empty();
    }

    @Override
    public void remove(String id) {
        List<T> models = getAll();
        Optional<T> modelFound = findInList(models, id);
        if (modelFound.isPresent()) {
            Model modelToBeRemoved = modelFound.get();
            models.remove(modelToBeRemoved);
            genericFileReader.writeToFile(fileName, models);
        }
    }

    @Override
    public void add(T objectToBeAdded) {
        List<T> models = getAll();
        models.add(objectToBeAdded);
        genericFileReader.writeToFile(fileName, models);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
