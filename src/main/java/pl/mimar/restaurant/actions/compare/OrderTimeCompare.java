package pl.mimar.restaurant.actions.compare;

import java.util.Comparator;

public class OrderTimeCompare implements Comparator<OrderDataSorting>{

    @Override
    public int compare(OrderDataSorting o1, OrderDataSorting o2) {
        return o1.orderTime.compareTo(o2.orderTime);
    }

}

