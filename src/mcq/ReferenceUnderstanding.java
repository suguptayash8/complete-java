package mcq;

public class ReferenceUnderstanding {

    public static void main(String []args){
        Student s = new Student("abc", 96);
        methodB(s);
        System.out.println(s.getName());
        methodA(s);
        System.out.println(s.getName());
    }
    public static void methodA(Student s){
        s.setName("xyz");
        System.out.println(s.getName());
    }

    public static void methodB(Student s){
        s = new Student("cde", 88);
        System.out.println(s.getName());
    }
}


class Student {
    private String name;
    private Integer marks;

    public Student(String name, Integer marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}