package practice10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

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
        List<Klass> sortedClasses = this.classes.stream()
                .sorted(Comparator.comparingInt(Klass::getNumber))
                .collect(Collectors.toList());

        if (sortedClasses.size() == 0) {
            return "My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.";
        } else {
            String allClass = "";
            for (Klass  klass: sortedClasses) {
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

}
