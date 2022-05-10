package pl.mimar.restaurant.actions;

import pl.mimar.restaurant.SomethingWentWrongException;
import pl.mimar.restaurant.model.OrderData;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Add implements ExemplaryAction {


    private static Logger LOG = Logger.getLogger(Add.class.getName());
    private OrderData orderData = new OrderData();
    private List<OrderData> orderDataList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void runAction() {

        try {
            System.out.println("Please provide order name: ");
            orderData.setOrderName(scanner.nextLine());
            if (orderData.getOrderName().equals("")) {
                LOG.info("Lack of order name. Order will not be added");
                throw new SomethingWentWrongException();
            }

            System.out.println("Please provide table number: ");
            orderData.setTableNumber(Integer.parseInt(scanner.nextLine()));

            System.out.println("Please provide order time [hh:mm]: ");
            orderData.setOrderTime(LocalTime.parse(scanner.nextLine()));

            System.out.println("Please provide order cost: ");
            orderData.setOrderCost(new BigDecimal(scanner.nextLine()));

            orderDataList.add(orderData);


            List<String> stringVersion = orderDataList.stream()
                    .map(object -> Objects.toString(object, null))
                    .collect(Collectors.toList());


            FileWriter writer = new FileWriter("output2.txt", true);
            for (String str : stringVersion) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
            System.out.println(stringVersion + "-was added");


            //Czyszczenie obu list (Bo dodawanie powodowalo x-dodań zmaiast 1ego)
            orderDataList.clear();
            stringVersion.clear();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}