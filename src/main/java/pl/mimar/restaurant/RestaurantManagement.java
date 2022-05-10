package pl.mimar.restaurant;

import pl.mimar.restaurant.actions.*;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantManagement {

    public static String givenLine;
    private static Logger LOG = Logger.getLogger(RestaurantManagement.class.getName());
    Add add = new Add();
    ReadAll readAll = new ReadAll();
    Read read = new Read();
    DeleteAll deleteAll = new DeleteAll();
    Delete delete = new Delete();
    Sort sort = new Sort();
    Scanner scanner = new Scanner(System.in);
    String scannerInput;
//  public static String confirmation;

    public static void main(String[] args) throws IOException {
        new RestaurantManagement().start();
    }


     void start() {
        LOG.info("Application has started:");
        boolean mainLoop = true;


        System.out.println("Possible actions: ");
        System.out.println("add | delete | read | sort | exit");

        while (mainLoop) {
            try {
                scannerInput = (scanner.nextLine()).toString();
                if (scannerInput.equals(ListOfActions.ADD.getName())) {
                    add.runAction();
                    System.out.println("Order successfully added");
                    System.out.println("add | delete | read | sort | exit");
                }

                else if (scannerInput.equals(ListOfActions.READ.getName())) {
                    System.out.println("You want to read all orders or the specific one?");
                    System.out.println("read all | read specific");
                    scannerInput = (scanner.nextLine()).toString();
                    if (scannerInput.equals(ListOfActions.READ_ALL.getName())) {
                        readAll.runAction();
                        System.out.println("All orders successfully read");
                        System.out.println("add | delete | read | sort | exit");
                    }
                    if (scannerInput.equals(ListOfActions.READ_SPECIFIC.getName())) {
                        System.out.println("Put in order name:");
                        scannerInput = (scanner.nextLine()).toString();
                        givenLine = scannerInput;
                        read.runAction();
                        System.out.println("add | delete | read | sort | exit");
                    }
                }
                else if (scannerInput.equals(ListOfActions.DELETE.getName())) {
                    System.out.println("You want to delete all orders or the specific one?");
                    System.out.println("delete all | delete specific");
                    scannerInput = (scanner.nextLine()).toString();
                    if (scannerInput.equals(ListOfActions.DELETE_ALL.getName())) {
                        deleteAll.runAction();
                        System.out.println("List successfully deleted");
                        System.out.println("add | delete | read | sort | exit");
                    }
                    if (scannerInput.equals(ListOfActions.DELETE_SPECIFIC.getName())) {
                        System.out.println("Put in order name to be deleted: ");
                        scannerInput = (scanner.nextLine()).toString();
                        givenLine = scannerInput;
                        delete.runAction();
                        System.out.println("Given order was deleted (or not found :D)");
                        System.out.println("add | delete | read | sort | exit");
                    }
                }
                else if (scannerInput.equals(ListOfActions.SORT.getName())) {
                    System.out.println("Sorting all lines");
                    sort.runAction();
                    System.out.println("All lines in txt file, successfully sorted by orderTime");
                    System.out.println("add | delete | read | sort | exit");
                }

                else if (scannerInput.equals(ListOfActions.EXIT.getName())) {
                    mainLoop = false;
                    System.out.println("Successfully ended using application");
                }
                else{
                    LOG.info("Wrong command please, please use one from the list: ");
                    System.out.println("add | delete | read | sort | exit");
                }

            } catch (IllegalArgumentException e) {
                LOG.log(Level.WARNING, "Validation exception " + e.getMessage() + " Other value expected");
                System.out.println("add | delete | read | sort | exit");

            }catch (DateTimeParseException e){
                LOG.log(Level.WARNING, "Wrong date format " + e.getMessage() + " [hh:mm] format expected");
                System.out.println("add | delete | read | sort | exit");

            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Unknown error", e);
                System.out.println("add | delete | read | sort | exit");
            }
        }
    }
}
