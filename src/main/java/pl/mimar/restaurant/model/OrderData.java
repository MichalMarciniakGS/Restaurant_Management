package pl.mimar.restaurant.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

public class OrderData implements Serializable {

    private String orderName;
    private int tableNumber;
    private LocalTime orderTime;
    private BigDecimal orderCost;

    public OrderData() {
    }

    public OrderData(String orderName, int tableNumber, LocalTime orderTime, BigDecimal orderCost) {
        this.orderName = orderName;
        this.tableNumber = tableNumber;
        this.orderTime = orderTime;
        this.orderCost = orderCost;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "orderName='" + orderName + '\'' +
                ", tableNumber=" + tableNumber +
                ", orderTime=" + orderTime +
                ", orderCost=" + orderCost +
                '}';
    }
}
