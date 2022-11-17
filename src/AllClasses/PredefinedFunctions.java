package AllClasses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PredefinedFunctions {
    HashMap<String , BooleanWrapper> boolMap;
    HashMap<String , IntegerWrapper> intMap;
    String boolOperators = "+,-,*,/";
    String intOperators = ">,>=,<,<=,==,!=,&&,||,==,!=";
    HashSet<String> boolOpMap;
    HashSet<String> intOpMap;


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

    public void invokeVardef(String varname){
        String temp[] = varname.split(" ");
        if(temp[2].equals("int")){
            intMap.put(temp[2] , new IntegerWrapper(temp[2] , Integer.getInteger(temp[3])) );
        }
        else{
            boolMap.put(temp[2] , new BooleanWrapper(temp[2] , temp[3].equals("true")) );
        }

    }

    public void invokeBinaryExperssions(String str){
        String temp[] = str.split(" ");


    }


    public PredefinedFunctions() {
        boolMap = new HashMap<>();
        intMap = new HashMap<>();
        boolOpMap = new HashSet<>();
        intOpMap  = new HashSet<>();
        intOpMap.addAll(Arrays.asList(intOperators.split(",")));
        boolOpMap.addAll(Arrays.asList(boolOperators.split(",")));
    }
}
