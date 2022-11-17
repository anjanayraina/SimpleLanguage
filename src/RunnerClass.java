import java.util.HashMap;
import java.util.Scanner;

public class RunnerClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

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

                }

            }
        }
    }
}
