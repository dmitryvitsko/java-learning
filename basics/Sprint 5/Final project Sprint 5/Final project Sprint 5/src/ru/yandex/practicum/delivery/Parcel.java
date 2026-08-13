package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        printPackaged();
    }

    public void deliver() {
        printDeliveryAddress();
    }

    public int calculateDeliveryCost() {
        return (int) (getBaseCost() * getWeight());
    }

    protected void printPackaged() {
        System.out.println("Посылка " + this.getDescription() + " упакована");
    }

    protected void printDeliveryAddress() {
        System.out.println("Посылка " + this.getDescription() + " доставлена по адресу: " + this.getDeliveryAddress());
    }

    protected abstract int getBaseCost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void setSendDay(int sendDay) {
        this.sendDay = sendDay;
    }
}