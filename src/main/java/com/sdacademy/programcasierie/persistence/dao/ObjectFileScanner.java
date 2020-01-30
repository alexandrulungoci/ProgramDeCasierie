package com.sdacademy.programcasierie.persistence.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileScanner<T> {

    public void writeToFile(String fileName, List<T> objectToBeWriteInFile) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectToBeWriteInFile);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception exception) {
            throw new RuntimeException("An error has apear while initialize the file");
        }
    }

    public List<T> readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
                return new ArrayList<T>();
            }
            if (file.length() == 0) {
                return new ArrayList<T>();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream outputInputStream = new ObjectInputStream(fileInputStream);
            List<T> objectToRead = (List<T>) outputInputStream.readObject();
            return objectToRead;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException();
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("An error has apear while initialize the file");
        }

    }
}
