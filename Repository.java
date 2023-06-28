package com.example.disciplinedemo.repository;

import com.example.disciplinedemo.model.Discipline;
import com.example.disciplinedemo.model.DisciplineMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@org.springframework.stereotype.Repository
public class Repository implements IRepository {
    private static final Map<Integer, Discipline> DISCIPLINE_REPOSITORY_MAP = new HashMap<>();
    private static final String filePath = "src/main/java/com/example/disciplinedemo/repository/disciplines.xml";

    private void MapToXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DisciplineMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        DisciplineMap disciplineMap = new DisciplineMap();
        disciplineMap.setDisciplineMap(DISCIPLINE_REPOSITORY_MAP);
        jaxbMarshaller.marshal(disciplineMap, new File(filePath));
    }

    private void XmlToMap() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DisciplineMap.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        DisciplineMap disciplineMap = (DisciplineMap) jaxbUnmarshaller.unmarshal(new File(filePath));
        DISCIPLINE_REPOSITORY_MAP.clear();
        DISCIPLINE_REPOSITORY_MAP.putAll(disciplineMap.getDisciplineMap());
    }

    @Override
    @Async
    public void add(Discipline discipline) {
        DISCIPLINE_REPOSITORY_MAP.put(discipline.getID(), discipline);
        try {
            this.MapToXml();
        } catch (JAXBException e) {
            System.out.print("XML write error:\n" + e);
        }
    }

    @Override
    @Async
    public Discipline read(Integer id) {
        if (DISCIPLINE_REPOSITORY_MAP.isEmpty()) {
            try {
                this.XmlToMap();
            } catch (JAXBException e) {
                System.out.print("XML read error:\n" + e);
            }
        }
        return DISCIPLINE_REPOSITORY_MAP.get(id);
    }

    @Override
    @Async
    public List<Discipline> readAll() {
        if (DISCIPLINE_REPOSITORY_MAP.isEmpty()) {
            try {
                this.XmlToMap();
            } catch (JAXBException e) {
                System.out.print("XML read error:\n" + e);
            }
        }
        return new ArrayList<>(DISCIPLINE_REPOSITORY_MAP.values());
    }

    @Override
    @Async
    public boolean update(Discipline discipline, Integer id) {
        if (DISCIPLINE_REPOSITORY_MAP.containsKey(id)) {
            try {
                discipline.setID(id);
                DISCIPLINE_REPOSITORY_MAP.put(id, discipline);
                this.MapToXml();
            } catch (JAXBException e) {
                System.out.print("XML write error:\n" + e);
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    @Async
    public boolean delete(Integer id) {
        boolean result = false;
        try {
            result = DISCIPLINE_REPOSITORY_MAP.remove(id) != null;
            this.MapToXml();
        } catch (JAXBException e) {
            System.out.print("XML write error:\n" + e);
        }
        return result;
    }

    @Override
    @Async
    public File getData() {
        return new File(filePath);
    }

    @Override
    @Async
    public boolean setData(MultipartFile file) {
        Path path = Paths.get(Repository.filePath);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            this.XmlToMap();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (JAXBException e) {
            return false;
        }
        return true;
    }

    public static class JaxbExample {
        public static void main(String[] args) {
            Discipline discipline = new Discipline(1, "Physics", 3, "Exam", "Kokin", 144);
            Discipline discipline1 = new Discipline(2, "Math", 3, "Exam", "Krasnova", 144);
            Discipline discipline2 = new Discipline(3, "Programmer", 2, "Exam", "Pavlov",48);
            Discipline discipline3 = new Discipline(4, "Informatics", 1, "Test", "Kulikov",48);
            Discipline discipline4 = new Discipline(5, "History", 2, "Test", "Tancevova",36);

            jaxbObjectToXML(discipline);
            jaxbObjectToXML(discipline1);
            jaxbObjectToXML(discipline2);
            jaxbObjectToXML(discipline3);
            jaxbObjectToXML(discipline4);

        }
        private static void jaxbObjectToXML(Discipline discipline) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Discipline.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                File file = new File("disciplines.xml");
                jaxbMarshaller.marshal(discipline, file);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
            String filename = "disciplines.xml";

            jaxbXMLFileToObject(filename);


        }
        private static void jaxbXMLFileToObject(String filename) {
            File xmlFile = new File(filename);
            JAXBContext jaxbContext;
            try{
                jaxbContext = JAXBContext.newInstance(Discipline.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Discipline discipline = (Discipline) jaxbUnmarshaller.unmarshal(xmlFile);
                System.out.println(discipline);



            } catch (JAXBException e)
            {
                e.printStackTrace();

            }
        }
    }
}



