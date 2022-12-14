import AllClasses.PredefinedFunctions;

import java.util.*;

public class RunnerClass {
    static HashMap<String , String > map;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        map = new HashMap<>();
        String operators = "+,-,*,/,>,>=,<,<=,==,!=,&&,||,!";
        HashSet<String> opMap = new HashSet<>();
        opMap.addAll(Arrays.asList(operators.split(",")));
        PredefinedFunctions functions  = new PredefinedFunctions();
        while(true){
            String temp = s.nextLine();
//            System.out.println(temp);
            if(temp.equals("quit")){
                System.out.println("Quitting the Class!!");
                break;
            }
            else{
                String breaks[]  = temp.split(" ");
                if(breaks.length <=1){
                    System.out.println("Please enter valid operations!!");
                }
                else if(breaks[0].equals("vardef")){
                    if(breaks.length != 5){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }

                    if(breaks[2].equals("int") || breaks[2].equals("bool")){
                        map.put(breaks[1] , temp);
                    }
                    else
                        System.out.println("Please enter suitable operators!");
                    functions.invokeVardef(temp);

                }
                else if(breaks[0].equals("b-expr")){
                    if(breaks.length != 5){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    functions.invokeBinaryExperssions(temp);
                        map.put(breaks[1] , temp);
                }
                else if(breaks[0].equals("print")){
                    if(breaks.length != 3){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    functions.invokePrint(breaks[1]);
                    map.put(breaks[1] , temp);
                }
                else if(breaks[0].equals("skip")){
                    if(breaks.length != 2){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                    functions.addSkip(breaks[1]);
                }
                else if(breaks[0].equals("if")){
                    if(breaks.length != 5){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                    functions.invokeIf(breaks[1] , breaks[3] ,breaks[2] , breaks[4] );


                }
                else if(breaks[0].equals("assign")){
                    if(breaks.length != 4){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                    functions.invokeAssign(breaks[1] , breaks[1] , breaks[2] , breaks[3]);


                }
                else if(breaks[0].equals("block")){
                    if(breaks.length != 4){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                    ArrayList<String> stats = new ArrayList<>();
                    for(int i=2;i<breaks.length;i++){
                        stats.add(breaks[i]);
                    }

                    functions.invokeBlock(breaks[1] , stats);

                }
                else if(breaks[0].equals("while")){
                    if(breaks.length != 4){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                    functions.createWhileLoop(breaks[1] , breaks[1] , breaks[2] , breaks[3]);

                }
                else if(breaks[0].equals("program")){
                    if(breaks.length != 3){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                    functions.createProgram(breaks[1] , breaks[2]);
                }
                else if(breaks[0].equals("execute")){
                    if(breaks.length != 2){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    functions.executeProgram(breaks[1]);


                }


            }
        }
//        functions.printAllInt();
//        functions.printAlBool();
        //vardef vardef1 int x 0
        //b-expr exp1 x % 2
        //b-expr exp2 exp1 == 0
    }
}
