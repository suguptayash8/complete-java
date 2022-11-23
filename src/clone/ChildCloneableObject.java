package clone;

public class ChildCloneableObject extends  CloneableObject{
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public ChildCloneableObject(){

    }

    public ChildCloneableObject(ChildCloneableObject childCloneableObject){
        this.designation = childCloneableObject.designation;
        this.setfName(childCloneableObject.getfName());
        this.setlName(childCloneableObject.getlName());
    }


    @Override
    public Object clone() {
        try {
            return (ChildCloneableObject) super.clone();
        } catch (CloneNotSupportedException e) {
            return new ChildCloneableObject(this);
        }
    }

    @Override
    public String toString() {
        return "ChildCloneableObject{" +
                "designation='" + designation + '\'' +
                "} " + super.toString();
    }

    public static  void main(String[] args){
        ChildCloneableObject childCloneableObject = new ChildCloneableObject();

        childCloneableObject.setfName("suyash");
        childCloneableObject.setlName("gupta");
        childCloneableObject.setDesignation("engineer");

        ChildCloneableObject anotherObject = new ChildCloneableObject(childCloneableObject);
        System.out.println(anotherObject.toString());


        System.out.println("cloned objects from constructor are same: " +  (anotherObject == childCloneableObject));
        System.out.println("cloned objects are  same: " +  (anotherObject.clone() == anotherObject.clone()));
    }
}
