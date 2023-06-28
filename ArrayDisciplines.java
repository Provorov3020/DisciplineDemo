package com.example.disciplinedemo.model;

public class ArrayDisciplines {
    private int id;
    private String titleofdiscipline;
    private int numberofsemester;
    private String typeofattestation;
    private String FIOteacher;
    private int volumeinhours;

    public ArrayDisciplines(String titleofdiscipline)  {
        this.titleofdiscipline = titleofdiscipline;
    }
    public static void main(String[] args) {
        String[] disciplines = new String[5];
        disciplines[0] = String.valueOf(new Discipline(1,"Физика",3,"Экзамен","Кокин С.М.",144));
        disciplines[1] = String.valueOf(new Discipline(2,"Математика",3,"Экзамен","Краснова С.Ю.",144));
        disciplines[2] = String.valueOf(new Discipline(3,"Программирование",2,"Экзамен","Павлов А.Ю.",48));
        disciplines[3] = String.valueOf(new Discipline(4,"Информатика",1,"Зачёт", "Куликов М.А.",48));
        disciplines[4] = String.valueOf(new Discipline(5,"История",2,"Зачёт","Танцевова А.В.",36));


        int disciplinesLength = disciplines.length;
        System.out.println(disciplinesLength);

        for(int i = 0; i < disciplinesLength; i++) {
            System.out.println(disciplines[i]);


        }
    }

}

