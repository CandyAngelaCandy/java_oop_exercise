package practice11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person{

    private Set<Klass> classes = new HashSet<>();

    public Set<Klass> getClasses() {
        return classes;
    }

    public void setClasses(Set<Klass> classes) {
        this.classes = classes;
    }


    public Teacher(int id,String name,int age,Set<Klass> classes){
        super(id,name,age);
        this.classes = classes;
        this.classes.forEach(klass -> klass.appendTeacher(this));
    }

    public Teacher(int id,String name,int age){
        super(id,name,age);
    }

    public String introduce(){
        if (this.classes.size() == 0) {
            return "My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.";
        } else {
            String allClass = "";
            for (Klass  klass: this.classes) {
                if (allClass == "") {
                    allClass = Integer.toString(klass.getNumber());
                } else {
                    allClass = allClass+", "+Integer.toString(klass.getNumber());
                }
            }
            return
                    super.introduce()+" I am a Teacher. I teach Class "+allClass+".";
        }
    }

    public boolean isTeaching(Student student){
        if (this.classes.contains(student.getKlass())) {
            return true;
        }
        return false;
    }
    public String introduceWith(Student student) {
        if(this.classes.contains(student.getKlass())){
            return "My name is Tom. I am 21 years old. I am a Teacher. I teach "+student.getName()+".";
        }else{
            return "My name is Tom. I am 21 years old. I am a Teacher. I don't teach "+student.getName()+".";
        }
    }

    public  void nodifyJoinLeader(Student leader) {
        List<Integer> classOfTeacherTeach = this.classes.stream()
                .map((klass -> (int)klass.getNumber()))
                .collect(Collectors.toList());

        if (classOfTeacherTeach.contains(leader.getKlass().getNumber())) {
            System.out.print("I am "+this.getName()+". I know "+leader.getName() +
                    " become Leader of Class "+leader.getKlass().getNumber()+".\n");
        }
    }

    public void nodifyJoinStudent(Student student) {
        List<Integer> classOfTeacherTeach = this.classes.stream()
                .map((klass -> (int)klass.getNumber()))
                .collect(Collectors.toList());

        if (classOfTeacherTeach.contains(student.getKlass().getNumber())) {
            System.out.print("I am "+this.getName()+". I know "+student.getName() +
                    " has joined Class "+student.getKlass().getNumber()+".\n");
        }
    }

}
