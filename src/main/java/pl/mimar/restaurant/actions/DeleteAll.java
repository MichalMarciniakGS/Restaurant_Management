package pl.mimar.restaurant.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteAll implements ExemplaryAction{

    public void runAction() {

        try(PrintWriter writer = new PrintWriter("output2.txt")){
            writer.print("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
