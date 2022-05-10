package pl.mimar.restaurant.actions;

import pl.mimar.restaurant.RestaurantManagement;
import pl.mimar.restaurant.model.OrderData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadAll implements ExemplaryAction{

    private static Logger LOG = Logger.getLogger(ReadAll.class.getName());

    public void runAction(){

        try(BufferedReader bufReader = new BufferedReader(new FileReader("output2.txt"))) {

            ArrayList<String> listOfLines = new ArrayList<>();

            String line = bufReader.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = bufReader.readLine();
            }
            if (listOfLines.size() > 0) {
                for (int i = 0; i < listOfLines.size(); i++) {
                    String current = listOfLines.get(i);
                    System.out.println(current);
                }
            } else {
                LOG.info("List is currently empty!");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
