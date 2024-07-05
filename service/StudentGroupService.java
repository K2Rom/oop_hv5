package service;

import java.util.ArrayList;
import java.util.List;

import model.StudentGroup;
import model.Student;
import model.Teacher;

public class StudentGroupService {

    private final List<StudentGroup> studentGroups = new ArrayList<>();
    private Integer maxGroupId = 0;

    public Integer createStudentGroup(Teacher teacher, List<Student> studentList) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupId(++maxGroupId);
        studentGroup.setTeacher(teacher);
        studentGroup.setStudentList(studentList);
        studentGroups.add(studentGroup);
        return studentGroup.getGroupId();
    }

    public StudentGroup getStudentGroupByGroupId(Integer id) throws Exception {
        for (StudentGroup group : studentGroups) {
            if (group.getGroupId().equals(id)) {
                return group;
            }
        }
        throw new Exception("Группа " + id + " не найдена");
    }

    public Teacher getTeacherByGroupId(Integer id) {
        StudentGroup group = null;

        try {
            group = getStudentGroupByGroupId(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return group.getTeacher();
    }

    public List<StudentGroup> getAllGroups() {
        return studentGroups;
    }
}
