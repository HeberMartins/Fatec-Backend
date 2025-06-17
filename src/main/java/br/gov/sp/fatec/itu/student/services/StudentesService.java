package br.gov.sp.fatec.itu.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.student.entities.Student;
import br.gov.sp.fatec.itu.student.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentesService {
    
    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student save(Student student){
        return repository.save(student);
    }

    public void update(Student student, long id){
        Student aux = repository.getReferenceById(id);
        aux.setCourse(student.getCourse());
        aux.setName(student.getName());
        repository.save(aux);
    }

    public void delete(long id){
        if(repository.existsById(id))
        {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Aluno não Cadastrado");
        }
    }
}
