package pl.mimar.restaurant.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static pl.mimar.restaurant.RestaurantManagement.givenLine;

public class Read implements ExemplaryAction {

    File inputFile = new File("output2.txt");

    public void runAction() {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.contains(givenLine)) {
                    System.out.println("Showing required order: " + currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
