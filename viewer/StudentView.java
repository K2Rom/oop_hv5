package viewer;

import java.util.List;

import control.Controller;
import model.Student;

public class StudentView implements HumanView<Student> {

    @Override
    public void sendOnConsole(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void start() {
        Controller controller = new Controller();
        controller.createStudent("Сидоров", "Сергей", "Сергеевич");
        controller.createStudent("Иванов", "Иван", "Петрович");
        controller.createStudent("Кузнецов", "Петр", "Иванович");
        controller.createStudent("Абрикосов", "Георгий", "Алексеевич");
        controller.createTeacher("Власов", "Василий", "Васильевич");
        controller.createTeacher("Иванов", "Георгий", "Алексеевич");
        // controller.printAllStudents();
        // controller.printAllTeachers();
        controller.createStudentGroup(1, List.of(1, 3));
        controller.createStudentGroup(2, List.of(2, 4));
        System.out.println("Все группы:");
        controller.printStudentGroups();
        System.out.println("Группа с id = 2");
        controller.printStudentGroupById(2);
        
        System.out.println("Преподаватель группы id = 2:");
        controller.printTeacherByGroupId(2);
    }
}
