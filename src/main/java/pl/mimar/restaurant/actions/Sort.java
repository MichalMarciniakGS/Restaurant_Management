package pl.mimar.restaurant.actions;

import pl.mimar.restaurant.actions.compare.OrderTimeCompare;
import pl.mimar.restaurant.actions.compare.OrderDataSorting;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;

public class Sort implements ExemplaryAction {

    File inputFile = new File("output2.txt");
    File tempFile = new File("output2_temp.txt");


    public void runAction() {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        ) {

            ArrayList<OrderDataSorting> orderDataArrayList = new ArrayList<>();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] dataDetails = currentLine.split(",");
                String name = dataDetails[0];
//                System.out.println("name is: " +name);
                String tableNumber = dataDetails[1];
//                System.out.println("tableNumber is: " +tableNumber);
                String orderTime = dataDetails[2];
//                System.out.println("orderTime is: " +orderTime);
                String cost = dataDetails[3];
//                System.out.println("cost is: " + cost);
                orderDataArrayList.add(new OrderDataSorting(name, tableNumber, orderTime, cost));
                currentLine = reader.readLine();
            }

            Collections.sort(orderDataArrayList, new OrderTimeCompare());

            for (OrderDataSorting orderDataSorting : orderDataArrayList) {
                writer.write(orderDataSorting.getName() + ",");
                writer.write(orderDataSorting.getTableNumber() + ",");
                writer.write(orderDataSorting.getOrderTime() + ",");
                writer.write(orderDataSorting.getCost());
                writer.newLine();
            }
            reader.close();
            writer.close();

            Files.move(Paths.get("output2_temp.txt"), Paths.get("output2.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            boolean successful = tempFile.renameTo(inputFile);

//        {
//
//            ArrayList<String> str = new ArrayList<>();
//            String line = "";
//            while ((line=reader.readLine()) != null){
//                str.add(line);
//            }
//            Collections.sort(str);
//            for (String s : str) {
//                writer.write(s);
//                writer.write("\r\n");
//            }
//            System.out.println("done");
//        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
