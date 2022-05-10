package pl.mimar.restaurant.actions.compare;

public class OrderDataSorting {
    String name;
    String tableNumber;
    String orderTime;
    String cost;

    public OrderDataSorting(String name, String tableNumber, String orderTime, String cost) {
        this.name = name;
        this.tableNumber = tableNumber;
        this.orderTime = orderTime;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getCost() {
        return cost;
    }
}
