package practice10;

public class Student extends Person{
    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Student(int id,String name,int age,Klass klass){
        super(id,name,age);
        this.klass=klass;
    }
    public String introduce(){
        if( this.klass.getLeader()!=null && this.getId() == this.klass.getLeader().getId()){
            return "My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.";
        }
        return super.introduce()+" I am a Student. I am at Class "+this.klass.getNumber()+".";
    }
}


