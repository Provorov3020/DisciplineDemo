package com.example.disciplinedemo.service;

import com.example.disciplinedemo.model.Discipline;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@org.springframework.stereotype.Service
public class Service implements IService{

    private static Map<Integer, Discipline> DISCIPLINE_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger DISCIPLINE_ID_HOLDER = new AtomicInteger();


    @Override
    @Async
    public void create(Discipline discipline) {
        final int disciplineID = DISCIPLINE_ID_HOLDER.incrementAndGet();
        discipline.setID(disciplineID);
        DISCIPLINE_REPOSITORY_MAP.put(disciplineID,discipline);
    }

    @Override
    @Async
    public Discipline read(Integer id) {
        return DISCIPLINE_REPOSITORY_MAP.get(id);
    }

    @Override
    @Async
    public List<Discipline> readAll() {
        return new ArrayList<>(DISCIPLINE_REPOSITORY_MAP.values());

    }

    @Override
    @Async
    public boolean update(Discipline discipline, Integer id) {
        if (DISCIPLINE_REPOSITORY_MAP.containsKey(id)) {
            discipline.setID(id);
            DISCIPLINE_REPOSITORY_MAP.put(id, discipline);
            return true;
        }
        return false;
    }

    @Override
    @Async
    public boolean delete(Integer id) {
        return DISCIPLINE_REPOSITORY_MAP.remove(id) != null;
    }

    @Override
    @Async
    public File getData() {
        return null;
    }

    @Override
    @Async
    public boolean setData(MultipartFile file) {
        return false;
    }
    public int kurtosiscoefficient() {
        Scanner sc = new Scanner(System.in);
        int Ek;
        int x1 = 144;
        int x2 = 144;
        int x3 = 48;
        int x4 = 48;
        int x5 = 36;
        int xср = (x1 + x2 + x3 + x4 + x5)/5;
        xср = 84;
        int n = (x1 + x2 + x3 + x4 + x5);
        n = 564;
        int m4 = (x1 - xср)^4 + (x2 - xср)^4 + (x3 - xср)^4 + (x4 - xср)^4 + (x5 - xср)^4/n;
        int σв = 2;
        int sqrt = 4;
        Ek = (m4 / σв ^ 4) - 3;
        System.out.println("Число 2 в 4 степени равно " + Math.pow(σв, 4));
        Ek = ((144 - 84)^4 + (144 - 84)^4 + (48 - 84)^4 + (48 - 84)^4 + (36 - 84)^4/564 /16) - 3;
        Ek = (61326 / 16) - 3;
        System.out.println("Ek = " + Ek);
        return Ek;
    }
    public String infoProg() {
        return "Программу разработал студент группы УВА-211 Проворов Александр. \nНаименование темы:" +
                "«Создание веб-сервисов REST с помощью Spring Framework» для предметной области «Учебный план».";
    }
}

