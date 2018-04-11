package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Teacher> teachers = new ArrayList<>();

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return "Class " + this.number;
    }

    public void assignLeader(Student leader) {
        if (leader.getKlass().getNumber()==this.getNumber()) {
            this.leader = leader;
        } else {
            System.out.print("It is not one of us.\n");
        }
        this.teachers.forEach((teacher)->teacher.nodifyJoinLeader(leader));
    }

    public void appendMember(Student student) {
        student.setKlass(this);

        this.teachers.forEach((teacher)->teacher.nodifyJoinStudent(student));
    }

    public void appendTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

}

