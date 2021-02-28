package se.lexicon.ReineMoberg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import se.lexicon.ReineMoberg.configs.ComponentScanConfig;
import se.lexicon.ReineMoberg.data_access.StudentDao;
import se.lexicon.ReineMoberg.models.Student;
import se.lexicon.ReineMoberg.util.UserInputService;

import java.util.*;

@Component
public class StudentManagerConsoleImpl implements StudentManagement{

    @Autowired
    private UserInputService scannerService;
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student create() {
        Student student = new Student();
        System.out.println();
        System.out.println("################################");
        System.out.println("## Add new student #############");
        System.out.println("################################");
        System.out.println("Name: ");
        student.setName(scannerService.getString());
        System.out.println("Email: ");
        student.setEmail(scannerService.getString());
        System.out.println("Password: ");
        student.setPassword(scannerService.getString());
        return save(student);
    }

    @Override
    public Student save(Student student) {
        Student savedStudent = studentDao.save(student);
        if (savedStudent == null) {
            System.out.println();
            System.out.println("################################");
            System.out.println("## Something went wrong! #######");
            System.out.println("## Student was not saved #######");
            System.out.println("################################");
            System.out.println(student);
            return student;
        } else {
            System.out.println();
            System.out.println("################################");
            System.out.println("## Student was saved ###########");
            System.out.println("################################");
            System.out.println(savedStudent);
            return savedStudent;
        }
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student removedStudent = find(id);
        studentDao.delete(id);
        return removedStudent;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>(studentDao.findAll());
        studentList.sort(Comparator.comparingInt(Student::getId));
        return studentList;
    }

    @Override
    public Student edit(Student student) {
        System.out.println();
        System.out.println("################################");
        System.out.println("## Update student: #############");
        System.out.println("## 1. New name  ################");
        System.out.println("## 2. New email  ###############");
        System.out.println("## 3. New password  ############");
        System.out.println("################################");
        String operationType = scannerService.getString();
        switch (operationType.toLowerCase()) {
            case "1":
                System.out.println("Name: ");
                student.setName(scannerService.getString());
                break;
            case "2":
                System.out.println("Email: ");
                student.setEmail(scannerService.getString());
                break;
            case "3":
                System.out.println("Password: ");
                student.setPassword(scannerService.getString());
                break;
            default:
                System.out.println("Operation is not valid");
                return student;
        }
        return save(student);
    }

}
