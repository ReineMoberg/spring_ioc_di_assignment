package se.lexicon.ReineMoberg.data_access;

import se.lexicon.ReineMoberg.models.Student;

import java.util.Set;

public interface StudentDao {

    Student save(Student student);

    Student find(int id);

    Set<Student> findAll();

    void delete(int id);

}
