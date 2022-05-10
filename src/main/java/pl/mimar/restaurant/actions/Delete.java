package pl.mimar.restaurant.actions;

import pl.mimar.restaurant.RestaurantManagement;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Delete implements ExemplaryAction{

    File inputFile = new File("output2.txt");
    File tempFile = new File("output2_temp.txt");



    public void runAction() {

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            )

        {
            String lineToRemove = RestaurantManagement.givenLine;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.contains(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

//            Files.delete(Paths.get("output2.txt"));

            Files.move(Paths.get("output2_temp.txt"),Paths.get("output2.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            boolean successful = tempFile.renameTo(inputFile);
//            System.out.println(successful);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
