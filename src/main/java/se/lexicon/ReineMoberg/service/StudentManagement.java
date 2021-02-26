package se.lexicon.ReineMoberg.service;

import se.lexicon.ReineMoberg.models.Student;

import java.util.Set;

public interface StudentManagement {

    Student create();

    Student save(Student student);

    Student find(int id);

    Student remove(int id);

    Set<Student> findAll();

    Student edit(Student student);

}
