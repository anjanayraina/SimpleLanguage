package AllClasses;

import java.util.HashMap;

public class PredefinedFunctions {
    HashMap<String , BooleanWrapper> boolMap;
    HashMap<String , IntegerWrapper> intMap;

    public HashMap<String, BooleanWrapper> getBoolMap() {
        return boolMap;
    }

    public void setBoolMap(HashMap<String, BooleanWrapper> boolMap) {
        this.boolMap = boolMap;
    }

    public HashMap<String, IntegerWrapper> getIntMap() {
        return intMap;
    }

    public void setIntMap(HashMap<String, IntegerWrapper> intMap) {
        this.intMap = intMap;
    }

    public boolean isOverflowed(int val){
        return val <-99999 || val > 99999;
    }
    PredefinedFunctions(){
        boolMap = new HashMap<>();
        intMap = new HashMap<>();
    }
}
