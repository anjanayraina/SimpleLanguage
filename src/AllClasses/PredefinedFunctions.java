package AllClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PredefinedFunctions {
    HashMap<String , BooleanWrapper> boolMap;
    HashMap<String , IntegerWrapper> intMap;
    HashMap<String  , PrintWrapper> printMap;
    HashMap<String , IfWrapper> ifMap;
    HashMap<String , AssignWrapper> asisgnMap;
    HashMap<String , Block> blockMap ;
    HashMap<String , WhileLoop>whileLoopMap;
    String boolOperators = "+,-,*,/,%";
    String intOperators = ">,>=,<,<=,==,!=,&&,||,==,!=";
    HashSet<String> boolOpMap;
    HashSet<String> intOpMap;

    public void invokePrint(String varname , String op){
        if(intMap.containsKey(varname))printMap.put(varname , new PrintWrapper(varname , false , intMap.get(varname),null ));
        else
            printMap.put(varname , new PrintWrapper(varname , true ,null, boolMap.get(varname) ));

    }
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

    public void declareInt(String coverName , String varName , int val ){
        intMap.put(coverName , new IntegerWrapper(varName ,val ));
    }
    public void declareBool(String coverName , String  varName , boolean val){
        boolMap.put(coverName , new BooleanWrapper(varName , val));
    }
    public void assignBool(String varname){
        AssignWrapper temp  = asisgnMap.get(varname);
        boolMap.get(temp.left).val = boolMap.get(temp.right).val;
    }
    public void assignInt(String varname){
        AssignWrapper temp  = asisgnMap.get(varname);
        intMap.get(temp.left).val = intMap.get(temp.right).val;
    }

    public void invokeIntBinary(String varname , String op1 , String op2 , String op){
        if(op.equals("+")){
            intMap.put(varname , new IntegerWrapper(varname , intMap.get(op1).val+ Integer.getInteger(op2)));
        }
        else if(op.equals("-")){
            intMap.put(varname , new IntegerWrapper(varname , intMap.get(op1).val- Integer.getInteger(op2)));
        }
        else if(op.equals("*")){
            intMap.put(varname , new IntegerWrapper(varname , intMap.get(op1).val*Integer.getInteger(op2)));
        }
        else if(op.equals("/")){
            intMap.put(varname , new IntegerWrapper(varname , intMap.get(op1).val/Integer.getInteger(op2)));
        }
        else if(op.equals("%")){
            intMap.put(varname , new IntegerWrapper(varname , intMap.get(op1).val%Integer.getInteger(op2)));
        }
        else
            System.out.println("Please enter a valid operator");
    }

    public void updateIntBinary(String varname ,int val ,String op){
        if(op.equals("+")){
            intMap.get(varname).val+=val;
        }
        else if(op.equals("-")){
            intMap.get(varname).val-=val;
        }
        else if(op.equals("*")){
            intMap.get(varname).val*=val;
        }
        else if(op.equals("/")){
            intMap.get(varname).val/=val;
        }
        else if(op.equals("%")){
            intMap.get(varname).val%=val;
        }
    }



    public void invokeBoolBinary(String varname , String op1 , String op2 , String op){

        if(op.equals(">")){
            boolMap.put(varname , new BooleanWrapper(varname , intMap.get(op1).val> Integer.getInteger(op2)));
        }
        else if(op.equals(">=")){
            boolMap.put(varname , new BooleanWrapper(varname , intMap.get(op1).val>= Integer.getInteger(op2)));
        }
        else if(op.equals("<")){
            boolMap.put(varname , new BooleanWrapper(varname , intMap.get(op1).val< Integer.getInteger(op2)));
        }
        else if(op.equals("<=")){
            boolMap.put(varname , new BooleanWrapper(varname , intMap.get(op1).val<= Integer.getInteger(op2)));
        }
        else if(op.equals("==")){
            boolMap.put(varname , new BooleanWrapper(varname , intMap.get(op1).val== Integer.getInteger(op2)));
        }
        else if(op.equals("!=")){
            boolMap.put(varname , new BooleanWrapper(varname , intMap.get(op1).val!= Integer.getInteger(op2)));
        }
        else if(op.equals("&&")){
            boolMap.put(varname , new BooleanWrapper(varname , boolMap.get(op1).val && boolMap.get(op2).val));
        }
        else if(op.equals("||")){
            boolMap.put(varname , new BooleanWrapper(varname , boolMap.get(op1).val || boolMap.get(op2).val));
        }
        else
            System.out.println("Please enter a valid operator");
    }
    public void executeBlock(String varname){
        ArrayList<String> a = blockMap.get(varname).getStatements();
    }

    public void invokeBinaryExperssions(String str){
        String temp[] = str.split(" ");
        if(intOpMap.contains(temp[3])){
            invokeIntBinary(temp[1] , temp[2] , temp[4] , temp[3]);
        }
        else{
            invokeBoolBinary(temp[1] , temp[2] , temp[4] , temp[3]);
        }

    }


    public void invokeWhileLoop(String varname ){

       WhileLoop loop = whileLoopMap.get(varname);
       while(boolMap.get(loop.condition).val){
           executeBlock(loop.block);
       }

    }
    public PredefinedFunctions() {
        boolMap = new HashMap<>();
        intMap = new HashMap<>();
        printMap  = new HashMap<>();
        ifMap = new HashMap<>();
        blockMap = new HashMap<>();
        whileLoopMap = new HashMap<>();
        boolOpMap = new HashSet<>();
        intOpMap  = new HashSet<>();
        intOpMap.addAll(Arrays.asList(intOperators.split(",")));
        boolOpMap.addAll(Arrays.asList(boolOperators.split(",")));
    }
}
