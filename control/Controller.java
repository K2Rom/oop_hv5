package control;

import java.util.ArrayList;
import java.util.List;

import model.StudentGroup;
import model.Type;
import model.Student;
import model.Teacher;

import service.DataService;
import service.StudentGroupService;

import viewer.StudentGroupView;
import viewer.StudentView;
import viewer.TeacherView;

public class Controller {

    private final DataService dataService = new DataService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudentGroupView studentGroupView = new StudentGroupView();

    public Integer createStudent(String lastName, String firstName, String middleName) {
        return dataService.create(Type.STUDENT, lastName, firstName, middleName);
    }

    public Integer createTeacher(String lastName, String firstName, String middleName) {
        return dataService.create(Type.TEACHER, lastName, firstName, middleName);
    }

    public void printAllStudents() {
        studentView.sendOnConsole(dataService.getAllStudents());
    }

    public void printAllTeachers() {
        teacherView.sendOnConsole(dataService.getAllTeachers());
    }

    public Integer createStudentGroup(Integer teacherId, List<Integer> studentIdList) {
        Teacher teacher = null;
        try {
            teacher = dataService.getTeacherById(teacherId);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        List<Student> studentList = new ArrayList<>();
        for (Integer id : studentIdList) {

            try {
                studentList.add(dataService.getStudentById(id));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return studentGroupService.createStudentGroup(teacher, studentList);
    }

    public Teacher getTeacherByGroupId(Integer id) {
        return studentGroupService.getTeacherByGroupId(id);
    }

    public void printStudentGroupById(Integer id) {
        StudentGroup group = null;

        try {
            group = studentGroupService.getStudentGroupByGroupId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        studentGroupView.sendOnConsole(group);
    }

    public void printStudentGroups() {
        //System.out.println(studentGroupService.getAllGroups());
        //Но раз sout должно быть во View, пришлось городить вот такое
        for (StudentGroup group : studentGroupService.getAllGroups()) {
            printStudentGroupById(group.getGroupId());
        }
    }

    public void printTeacherByGroupId(Integer id) {
        teacherView.printTeacher(studentGroupService.getTeacherByGroupId(id));
    }
}
