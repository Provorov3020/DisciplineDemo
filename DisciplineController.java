package com.example.disciplinedemo.rest;

import com.example.disciplinedemo.model.Discipline;
import com.example.disciplinedemo.service.IService;
import com.example.disciplinedemo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
@RestController
@CrossOrigin
public class DisciplineController {
    private final IService service;

    @Autowired
    public DisciplineController(Service service) {
        this.service = service;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Discipline discipline) {
        service.create(discipline);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Discipline>> read() {
        final List<Discipline> disciplines = service.readAll();
        return disciplines != null && !disciplines.isEmpty()
                ? new ResponseEntity<>(disciplines, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/disciplines/{id}")
    public ResponseEntity<Discipline> read(@PathVariable(name = "id") Integer id) {
        final Discipline discipline = service.read(id);

        return discipline != null
                ? new ResponseEntity<>(discipline, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/disciplines/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Discipline discipline) {
        final boolean updated = service.update(discipline, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/disciplines/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = service.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/download")
    public ResponseEntity<?> download() {
        Resource resource = null;
        File file = service.getData();
        try {
            resource = new UrlResource(file.toURI());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"disciplines.xml\"")
                .body(resource);
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        return service.setData(file)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/kurtosiscoefficient")
    public int kurtosiscoefficient() {
        return this.service.kurtosiscoefficient();
    }

    @GetMapping(value = "/infoProg")
    public String infoProg() {
        return this.service.infoProg();
    }
    @GetMapping(value = "/getData")
    public File getData() {
        return this.service.getData();
    }

}





