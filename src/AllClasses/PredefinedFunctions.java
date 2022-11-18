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
    HashMap<String , ProgramWrapper> programMap;
    String intOperators = "+,-,*,/,%";
    String boolOperators = ">,>=,<,<=,==,!=,&&,||,==,!=";
    HashSet<String> boolOpMap;
    HashSet<String> intOpMap;
    HashSet<String > skipSet;

    public void invokePrint(String varname , String op){
        if(intMap.containsKey(varname))printMap.put(varname , new PrintWrapper(varname , false , intMap.get(varname),null ));
        else
            printMap.put(varname , new PrintWrapper(varname , true ,null, boolMap.get(varname) ));
    }

    public void printVal(String varname){
//        String name =
//        if(intMap.containsKey(varname)) System.out.println(printMap.get(varname).);
//        else
//
    }


    public void invokeVardef(String varname){
        String temp[] = varname.split(" ");
        if(temp[2].equals("int")){
            intMap.put(temp[1] , new IntegerWrapper(temp[3] , Integer.parseInt(temp[4])) );
        }
        else{
            boolMap.put(temp[1] , new BooleanWrapper(temp[3] , temp[4].equals("true")) );
        }

    }
    public IntegerWrapper findIntegerByName(String name){
        for(String i  : intMap.keySet()){
            if(intMap.get(i).name.equals(name))return intMap.get(i);
        }
        return null;
    }
    public BooleanWrapper findBoolWrapper(String name){
        for(String i  : boolMap.keySet()){
            if(boolMap.get(i).name.equals(name))return boolMap.get(i);
        }
        return null;
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
        IntegerWrapper temp = findIntegerByName(op1);
        if(op.equals("+")){
            intMap.put(varname , new IntegerWrapper(varname , temp.val+ Integer.parseInt(op2)));
        }
        else if(op.equals("-")){
            intMap.put(varname , new IntegerWrapper(varname , temp.val- Integer.parseInt(op2)));
        }
        else if(op.equals("*")){
            intMap.put(varname , new IntegerWrapper(varname , temp.val*Integer.parseInt(op2)));
        }
        else if(op.equals("/")){
            intMap.put(varname , new IntegerWrapper(varname , temp.val/Integer.parseInt(op2)));
        }
        else if(op.equals("%")){
            intMap.put(varname , new IntegerWrapper(varname , temp.val%Integer.parseInt(op2)));
        }

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
        BooleanWrapper temp = findBoolWrapper(op1);
        IntegerWrapper temp1 = findIntegerByName(op1);
        if(temp1!=null) {
            if (op.equals(">")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp1.val > Integer.parseInt(op2)));
            } else if (op.equals(">=")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp1.val >= Integer.parseInt(op2)));
            } else if (op.equals("<")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp1.val < Integer.parseInt(op2)));
            } else if (op.equals("<=")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp1.val <= Integer.parseInt(op2)));
            } else if (op.equals("==")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp1.val == Integer.parseInt(op2)));
            }
           else if (op.equals("!=")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp1.val != Integer.parseInt(op2)));
            }
        }
        else if(temp!=null) {
            BooleanWrapper temp2 = findBoolWrapper(op2);
            if (op.equals("&&")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp.val && temp2.val));
            } else if (op.equals("||")) {
                boolMap.put(varname, new BooleanWrapper(varname, temp.val || temp2.val));
            }
        }
        else
            System.out.println("Please enter a valid operator");
    }

    public void printAllInt(){

        for(String i : intMap.keySet()){

            System.out.println(intMap.get(i));
        }
    }
    public void printAlBool(){

        for(String i : boolMap.keySet()){

            System.out.println(boolMap.get(i));
        }
    }

// invokeIntBinary(String varname , String op1 , String op2 , String op)
    public void invokeBinaryExperssions(String str){
        String temp[] = str.split(" ");
        if(intOpMap.contains(temp[3])){

            invokeIntBinary(temp[1] , temp[2] , temp[4] , temp[3]);
        }
        else{
            invokeBoolBinary(temp[1] , temp[2] , temp[4] , temp[3]);
        }

    }
    public void invokeIf(String varname ,String first , String condition, String other){
        ifMap.put(varname , new IfWrapper(varname, first , other , condition));
    }
    public void invokeAssign(String  varname , String name , String left , String right){
        asisgnMap.put(varname , new AssignWrapper(name , left ,right));

    }

    public void createWhileLoop(String varname , String name , String condition ,  String block ){
        whileLoopMap.put(varname , new WhileLoop(name , condition , block));
    }
    public void invokeWhileLoop(String varname ){

       WhileLoop loop = whileLoopMap.get(varname);
       while(boolMap.get(loop.condition).val){
           executeBlock(loop.block);
       }

    }
    public void invokeBlock(String name , ArrayList<String> stats ){
        blockMap.put(name , new Block(name , stats));
    }

    public void addSkip(String name){
        skipSet.add(name);
    }
    public void createProgram(String name , String block){
        programMap.put(name , new ProgramWrapper(name , block));
    }

    public void executeBlock(String block){
        Block b = blockMap.get(block);
        ArrayList<String > tasks = b.getStatements();
        for(String i : tasks){

            if(printMap.containsKey(i)){
                printMap.get(i).printVal();
            }
            else if(ifMap.containsKey(i)){

            }
            else if(blockMap.containsKey(i)){

            }
            else if(whileLoopMap.containsKey(i)){

            }
            else if(skipSet.contains(i)){

            }
            else if (asisgnMap.containsKey(i)) {
                AssignWrapper assign = asisgnMap.get(i);
                if(intMap.containsKey(assign.name)){
                    assignInt(assign.name);
                }
                else{
                    assignBool(assign.name);
                }
            }

        }

    }
    public void executeProgram(String name ){
        ProgramWrapper program = programMap.get(name);
        executeBlock(program.block);

    }
    public PredefinedFunctions() {
        asisgnMap = new HashMap<>();
        boolMap = new HashMap<>();
        intMap = new HashMap<>();
        printMap  = new HashMap<>();
        ifMap = new HashMap<>();
        blockMap = new HashMap<>();
        programMap = new HashMap<>();
        whileLoopMap = new HashMap<>();
        boolOpMap = new HashSet<>();
        intOpMap  = new HashSet<>();
        skipSet = new HashSet<>();
        intOpMap.addAll(Arrays.asList(intOperators.split(",")));
        boolOpMap.addAll(Arrays.asList(boolOperators.split(",")));
    }
}
