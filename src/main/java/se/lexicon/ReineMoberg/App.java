package se.lexicon.ReineMoberg;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.ReineMoberg.configs.ComponentScanConfig;
import se.lexicon.ReineMoberg.data_access.StudentDao;
import se.lexicon.ReineMoberg.models.Student;
import se.lexicon.ReineMoberg.util.UserInputService;

import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);

        //Test add student
        /*Student student1 = studentDao.save(new Student("Reine Moberg", "mail@server.com", "1111"));
        System.out.println("Created student = " + student1);*/

        //Test find student
        /*Student student1 = studentDao.save(new Student("Reine Moberg", "mail1@server.com", "1111"));
        Student student2 = studentDao.save(new Student("Anna Karlsson", "mail2@server.com", "2222"));
        System.out.println("Student id 1: " + studentDao.find(1));
        System.out.println("Student id 2: " + studentDao.find(2));*/

        //Test update student
        /*Student student1 = studentDao.save(new Student("Reine Moberg", "mail1@server.com", "1111"));
        student1.setEmail("mail2@server.com");
        student1 = studentDao.save(student1);
        System.out.println("Updated student: " + student1);
        System.out.println("Updated student from collection: " + studentDao.find(1));*/

        //Test find all students
        /*Student student1 = studentDao.save(new Student("Reine Moberg", "mail1@server.com", "1111"));
        Student student2 = studentDao.save(new Student("Anna Karlsson", "mail2@server.com", "2222"));
        Set<Student> studentSet = studentDao.findAll();
        studentSet.forEach(System.out::println);*/

        //Test delete student
        /*Student student1 = studentDao.save(new Student("Reine Moberg", "mail1@server.com", "1111"));
        Student student2 = studentDao.save(new Student("Anna Karlsson", "mail2@server.com", "2222"));
        studentDao.delete(1);
        studentDao.findAll().forEach(System.out::println);*/

        //Test user input scanner
        UserInputService userInputService = context.getBean(UserInputService.class);
        String testString = userInputService.getString();
        System.out.println(testString);
        int testNumber = userInputService.getInt();
        System.out.println(testNumber);
    }
}
