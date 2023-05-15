package references;

import java.lang.ref.WeakReference;


/**
 *
 */
public class WeakReferenceExample {
    public WeakReferenceExample(){

    }

    private void userData(){
        UserData userDataFromDb = new UserData("suyash", "gupta", "567");
        WeakReference<UserData> userDataWeakReference = new WeakReference(userDataFromDb);
        userDataFromDb = userDataWeakReference.get();
    }
}

class UserData {
    private String fname;
    private String lname;
    private String id;

    UserData(String fname, String lname, String id){
        this.fname = fname;
        this.lname = lname;
        this.id = id;
    }

}