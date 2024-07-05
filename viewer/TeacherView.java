package viewer;

import java.util.List;

import model.Teacher;

public class TeacherView implements HumanView<Teacher> {
    @Override
    public void sendOnConsole(List<Teacher> list) {
        for (Teacher teacher : list) {
            printTeacher(teacher);
        }
    }

    public void printTeacher(Teacher teacher){
        System.out.println(teacher);
    }
}
