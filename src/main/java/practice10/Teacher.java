package practice10;

import java.util.HashSet;
import java.util.Set;

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
    }

    public Teacher(int id,String name,int age){
        super(id,name,age);
    }

    public String introduce(){
        if (this.classes.size() == 0) {
            return "My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.";
        } else {
            String allClass = "";
            for (Klass klass : this.classes) {
                allClass = Integer.toString( klass.getNumber())+", "+allClass;
            }
            allClass = allClass.substring(0,allClass.length()-2);
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

}
