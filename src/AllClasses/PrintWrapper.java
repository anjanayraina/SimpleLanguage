package AllClasses;


public class PrintWrapper {
    String name;
    boolean isBool;
    IntegerWrapper intVal;
    BooleanWrapper boolVal;
    PrintWrapper(String name , boolean isBool , IntegerWrapper intVal , BooleanWrapper boolVal){
        this.name = name;
        this.isBool = isBool;
        this.intVal = intVal;
        this.boolVal = boolVal;
    }
    public void printVal(){
        if(this.intVal!=null)System.out.printf("[%s]", this.intVal.val);
        else
            System.out.printf("[%s]", this.boolVal.val);

    }
}
