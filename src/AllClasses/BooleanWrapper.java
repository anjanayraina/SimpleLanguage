package AllClasses;

public class BooleanWrapper {
    String name;
    boolean val;
    public boolean isVal() {
        return val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }


    BooleanWrapper(String name , boolean val){
        this.name = name;
        this.val = val;
    }
}
