package se.lexicon.ReineMoberg;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.ReineMoberg.configs.ComponentScanConfig;
import se.lexicon.ReineMoberg.service.StudentManagement;
import se.lexicon.ReineMoberg.util.UserInputService;



public class App
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        UserInputService userInputService = context.getBean(UserInputService.class);


        while (true) {
            System.out.println();
            System.out.println("################################");
            System.out.println("## STUDENT MANAGEMENT SYSTEM ###");
            System.out.println("################################");
            System.out.println("## 1. Add new student ##########");
            System.out.println("## 2. Find by ID ###############");
            System.out.println("## 3. Delete by ID #############");
            System.out.println("## 4. List all students ########");
            System.out.println("## X. Exit #####################");
            System.out.println("################################");
            String operationType = userInputService.getString();
            switch (operationType.toLowerCase()) {
                case "1":
                    studentManagement.create();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("################################");
                    System.out.println("## Enter ID: ###################");
                    int findByIdInput = userInputService.getInt();
                    if (findByIdInput == 0) {
                        System.out.println();
                        System.out.println("ID is not valid, try again.");
                    } else {
                        System.out.println();
                        System.out.println("Student found: ");
                        System.out.println(studentManagement.find(findByIdInput));
                        System.out.println();
                        System.out.println("################################");
                        System.out.println("## Edit student ? ##############");
                        System.out.println("## 1. Yes ######################");
                        System.out.println("## X. Exit #####################");
                        System.out.println("################################");
                        String editType = userInputService.getString();
                        if (editType.equals("1")) {
                            studentManagement.edit(studentManagement.find(findByIdInput));
                        }
                    }
                    break;
                case "3":
                    System.out.println();
                    System.out.println("################################");
                    System.out.println("## Enter ID to delete: #########");
                    int deleteByIdInput = userInputService.getInt();
                    if (deleteByIdInput == 0) {
                        System.out.println();
                        System.out.println("ID is not valid, try again.");
                    } else {
                        System.out.println();
                        System.out.println("Student removed :");
                        System.out.println(studentManagement.remove(deleteByIdInput));
                    }
                    break;
                case "4":
                    System.out.println();
                    System.out.println("################################");
                    System.out.println("## All students ################");
                    System.out.println("################################");
                    studentManagement.findAll().forEach(System.out::println);
                    break;
                case "x":
                    System.out.println();
                    System.out.println("################################");
                    System.out.println("## Goodbye #####################");
                    System.out.println("################################");
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.println("Operation is not valid, try again.");
            }
        }








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
        /*UserInputService userInputService = context.getBean(UserInputService.class);
        String testString = userInputService.getString();
        System.out.println(testString);
        int testNumber = userInputService.getInt();
        System.out.println(testNumber);*/
    }
}
