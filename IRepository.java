package com.example.disciplinedemo.repository;

import com.example.disciplinedemo.model.Discipline;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface IRepository {
    void add(Discipline discipline);

    Discipline read(Integer id);
    List<Discipline> readAll();
    boolean update(Discipline discipline, Integer id);
    boolean delete(Integer id);

    File getData();

    boolean setData(MultipartFile file);
}

