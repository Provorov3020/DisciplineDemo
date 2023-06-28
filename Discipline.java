package com.example.disciplinedemo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Discipline")
@XmlAccessorType(XmlAccessType.FIELD)
public class Discipline  {
    @XmlElement(name = "ID")
    private Integer id;
    @XmlElement(name = "Titleofdiscipline")
    private String titleofdiscipline;
    @XmlElement(name = "Numberofsemester")
    private Integer numberofsemester;
    @XmlElement(name = "Typeofattestation")
    private String typeofattestation;
    @XmlElement(name = "FIOteacher")
    private String FIOteacher;
    @XmlElement(name = "Volumeinhours")
    private Integer volumeinhours;

    public Discipline(Integer id, String titleofdiscipline, Integer numberofsemester, String typeofattestation, String FIOteacher, Integer volumeinhours)
    {
        this.id = id;
        this.titleofdiscipline = titleofdiscipline;
        this.numberofsemester = numberofsemester;
        this.typeofattestation = typeofattestation;
        this.FIOteacher = FIOteacher;
        this.volumeinhours = volumeinhours;
    }
    public Discipline() {
        Integer id = 1;
        String titleofdiscipline = "Физика";
        Integer numberofsemester = 3;
        String typeofattestation = "Экзамен";
        String FIOteacher = "Кокин С.М.";
        Integer volumeinhours = 144;
    }
    public Integer getID() {
        return this.id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getTitleofdiscipline() {
        return this.titleofdiscipline;
    }

    public void setTitleofdiscipline(String titleofdiscipline) {
        this.titleofdiscipline = titleofdiscipline;
    }

    public Integer getNumberofsemester() {
        return this.numberofsemester;
    }

    public void setNumberofsemester(Integer numberofsemester) {
        this.numberofsemester = numberofsemester;
    }

    public String getTypeofattestation() {
        return this.typeofattestation;
    }

    public void setTypeofattestation(String typeofattestation) {
        this.typeofattestation = typeofattestation;
    }

    public String getFIOteacher() {
        return this.FIOteacher;
    }

    public void setFIOteacher(String FIOteacher) {
        this.FIOteacher = FIOteacher;
    }

    public Integer getVolumeinhours() {
        return this.volumeinhours;
    }

    public void setVolumeinhours(Integer volumeinhours) {
        this.volumeinhours = volumeinhours;
    }

    @Override
    public String toString() {
        return "<Discipline> \n  <ID>" +
                ((this.id == null) ? "null" : this.id.toString()) +
                "</ID> \n    <Titleofdiscipline>" +
                ((this.titleofdiscipline == null) ? "null" : this.titleofdiscipline) +
                "</Titleofdiscipline> \n    <Numberofsemester>" +
                ((this.numberofsemester == null) ? "null" : this.numberofsemester) +
                "</Numberofsemester> \n    <Typeofattestation>" +
                ((this.typeofattestation == null) ? "null" : this.typeofattestation.toString()) +
                "</Typeofattestation> \n    <FIOteacher>" +
                ((this.FIOteacher == null) ? "null" : this.FIOteacher.toString()) +
                "</FiOteacher> \n    <Volumeinhours>" +
                ((this.volumeinhours == null) ? "null" : this.volumeinhours.toString()) +
                "</Volumeinhours>  \n<Discipline>";
    }
}


