package AllClasses;

import java.util.HashMap;

public class PredefinedFunctions {
    HashMap<String , Boolean> boolMap;
    HashMap<String , Integer> intMap;
    public HashMap<String, Boolean> getBoolMap() {
        return boolMap;
    }

    public void setBoolMap(HashMap<String, Boolean> boolMap) {
        this.boolMap = boolMap;
    }

    public HashMap<String, Integer> getIntMap() {
        return intMap;
    }

    public void setIntMap(HashMap<String, Integer> intMap) {
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
