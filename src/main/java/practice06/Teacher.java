package practice06;

public class Teacher extends Person{

    private Integer klass;

    public int getKlass() {
        return klass;
    }

    public void setKlass(int klass) {
        this.klass = klass;
    }

    public Teacher(String name,int age,int klass){
        super(name,age);
        this.klass = klass;
    }

    public Teacher(String name,int age){
        super(name,age);
    }

    public String introduce(){
      return  this.klass == null?
              "My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.":
               super.introduce()+" I am a Teacher. I teach Class "+this.klass+".";
    }

}
