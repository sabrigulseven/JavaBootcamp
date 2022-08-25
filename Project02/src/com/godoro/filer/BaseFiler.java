package com.godoro.filer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFiler<E> {

    protected String filePath;

    public final static String DELIMETER = ";";

    public BaseFiler(String filePath) {
        this.filePath = filePath;
    }

    public void store(List<E> entityList) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for (E entity : entityList) {
            String line = format(entity);
            bw.write(line);
            bw.write("\r\n");
        }
        bw.close();
    }

    public List<E> load() throws IOException {
        List<E> entityList = new ArrayList<>();
        BufferedReader bw = new BufferedReader(new FileReader(filePath));
        String line = null;

        while ((line = bw.readLine()) != null) {
            E entity = parse(line);
            entityList.add(entity);

        }
        bw.close();
        return entityList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static String getDelimeter() {
        return DELIMETER;
    }

    abstract protected String format(E entity);

    abstract protected E parse(String line);
}
