import AllClasses.PredefinedFunctions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

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
                }
                else if(breaks[0].equals("b-expr")){
                    if(breaks.length != 5){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                        map.put(breaks[1] , temp);
                }
                else if(breaks[0].equals("print")){
                    if(breaks.length != 3){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                }
                else if(breaks[0].equals("skip")){
                    if(breaks.length != 2){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);
                }
                else if(breaks[0].equals("if")){
                    if(breaks.length != 5){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                        map.put(breaks[1] , temp);

                }
                else if(breaks[0].equals("assign")){
                    if(breaks.length != 4){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);

                }
                else if(breaks[0].equals("block")){
                    if(breaks.length != 4){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);

                }
                else if(breaks[0].equals("while")){
                    if(breaks.length != 4){
                        System.out.println("Please enter the right number of arguments");
                        continue;
                    }
                    map.put(breaks[1] , temp);

                }


            }
        }
    }
}
