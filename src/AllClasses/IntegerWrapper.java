package AllClasses;

public class IntegerWrapper {
    String name;
    int val;
    IntegerWrapper(String name , int val){
        this.name = name;
        this.val = val;
    }
    public void incrementVal(int inc){
        this.val+=inc;
    }
    public boolean checkForOverflowGreater(){
        if(val > 99999){
            return true;
        }
        return false;
    }
    public boolean checkForOverflowLesser(){
        if(val < -99999){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return String.valueOf(this.name + " " + this.val);
    }
    public static boolean checkCondition(int val){
        return val%2==0;
    }


}
