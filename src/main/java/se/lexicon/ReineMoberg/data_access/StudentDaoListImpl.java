package se.lexicon.ReineMoberg.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.ReineMoberg.data_access.sequencers.StudentSequencer;
import se.lexicon.ReineMoberg.models.Student;

import java.util.*;

@Component
public class StudentDaoListImpl implements StudentDao{

    private Set<Student> studentSet = new HashSet<>();

    @Override
    public Student save(Student student) {
        if (student.getId() == 0) {
            student.setId(StudentSequencer.nextStudentId());
            studentSet.add(student);
        } else {
            Student studentToUpdate = find(student.getId());
            studentToUpdate.setName(student.getName());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setPassword(student.getPassword());
        }
        return student;
    }

    @Override
    public Student find(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("Id should not be zero");
        }
        /*Optional<Student> resultStudent = studentList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        if (resultStudent.isPresent()) {
            return resultStudent.get();
        } else {
            return null;
        }*/
        return studentSet.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Set<Student> findAll() {
        return studentSet;
    }

    @Override
    public void delete(int id) {
        studentSet.removeIf(p -> p.getId() == id);
    }
}
