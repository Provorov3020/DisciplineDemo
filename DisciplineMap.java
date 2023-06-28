package com.example.disciplinedemo.model;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@XmlRootElement(name = "Disciplines")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisciplineMap {
    private Map<Integer, Discipline> disciplineMap;

    public DisciplineMap() {
        disciplineMap = new HashMap<>();
    }

    public Map<Integer, Discipline> getDisciplineMap() {
        return disciplineMap;

    }
    public void setDisciplineMap(Map<Integer, Discipline> disciplineMap) {
        this.disciplineMap = disciplineMap;
    }
}

