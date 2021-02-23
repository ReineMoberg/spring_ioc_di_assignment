package se.lexicon.ReineMoberg.data_access;

import se.lexicon.ReineMoberg.data_access.sequencers.StudentSequencer;
import se.lexicon.ReineMoberg.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoListImpl implements StudentDao{

    private List<Student> studentList = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if (student.getId() == 0) {
            student.setId(StudentSequencer.nextStudentId());
            studentList.add(student);
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
        return studentList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void delete(int id) {
        studentList.removeIf(p -> p.getId() == id);
    }
}
