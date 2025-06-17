package br.gov.sp.fatec.itu.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.student.entities.Student;
import br.gov.sp.fatec.itu.student.services.StudentesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    private StudentesService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.created(null)
                    .body(service.save(student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Student student){
        service.update(student, id);
        return ResponseEntity.noContent().build();
    }

}
