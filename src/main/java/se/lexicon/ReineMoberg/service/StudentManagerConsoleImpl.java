package se.lexicon.ReineMoberg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.ReineMoberg.data_access.StudentDao;
import se.lexicon.ReineMoberg.models.Student;
import se.lexicon.ReineMoberg.util.UserInputService;

import java.util.Set;

@Component
public class StudentManagerConsoleImpl implements StudentManagement{

    @Autowired
    private UserInputService scannerService;
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student create() {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public Student remove(int id) {
        return null;
    }

    @Override
    public Set<Student> findAll() {
        return null;
    }

    @Override
    public Student edit(Student student) {
        return null;
    }
}
