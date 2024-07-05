package service;

import java.util.ArrayList;
import java.util.List;

import model.Type;
import model.Student;
import model.Teacher;

public class DataService {

    private static final List<Student> studentList = new ArrayList<>();
    private static final List<Teacher> teacherList = new ArrayList<>();
    //а должна ли быть БД public? никто ж не мешает new DataService().getAllUsers()

    public Integer create(Type type, String lastName, String firstName, String middleName) {
        Integer id = 0;
        if (type == Type.STUDENT) {
            id = getStudentNewId();
            studentList.add(new Student(id, lastName, firstName, middleName));
        }
        if (type == Type.TEACHER) {
            id = getTeacherNewId();
            teacherList.add(new Teacher(id, lastName, firstName, middleName));
        }
        return id;
    }

    public Teacher getTeacherById(Integer id) throws Exception {
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId() == id) {
                return teacher;
            }
        }
        throw new Exception("Преподаватель с id " + id + " не найден");
    }

    public Student getStudentById(Integer id) throws Exception {
        for (Student student : studentList) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        throw new Exception("Студент с id " + id + " не найден");
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public List<Teacher> getAllTeachers() {
        return teacherList;
    }

    private Integer getTeacherNewId() {
        return teacherList.size() + 1;
    }

    private Integer getStudentNewId() {
        return studentList.size() + 1;
    }
}
