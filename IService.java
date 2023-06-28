package com.example.disciplinedemo.service;


import com.example.disciplinedemo.model.Discipline;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface IService {
    void create(Discipline discipline);
    Discipline read(Integer id);
    List<Discipline> readAll();
    boolean update(Discipline discipline, Integer id);
    boolean delete(Integer id);

    File getData();

    boolean setData(MultipartFile file);
    int kurtosiscoefficient();
    String infoProg();

}
