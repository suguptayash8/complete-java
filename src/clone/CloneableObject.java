package clone;


public class CloneableObject implements Cloneable{
    private String fName;

    private String lName;

    public CloneableObject(){

    }

    public  CloneableObject(CloneableObject cloneableObject){
        this.fName = cloneableObject.fName;
        this.lName = cloneableObject.lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


    @Override
    public String toString() {
        return "CloneableObject{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            return (CloneableObject) super.clone();
        } catch (CloneNotSupportedException e) {
            if( this instanceof CloneableObject){
                return new CloneableObject(this);
            }
            throw e;
        }
    }


}
