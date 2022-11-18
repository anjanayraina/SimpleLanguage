package AllClasses;

import java.util.ArrayList;

public class Block {
    String blockName;
    ArrayList<String> statements;
    Block(String blockName , ArrayList<String> statements){
        this.blockName = blockName;
        this.statements  = statements;
    }
    public ArrayList<String> getStatements(){
        return this.statements;
    }
}
