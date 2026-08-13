package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private final List<T> parcels = new ArrayList<>();
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() > maxWeight) {
            System.out.println("В коробке нет места для этой посылки");
            return;
        }
        parcels.add(parcel);
        currentWeight += parcel.getWeight();
    }

    public void getAllParcels() {
        System.out.println("В коробке с типом " + parcels.get(0).getClass().getSimpleName() + " находятся следующие посылки: ");
        int counter = 1;
        for (T parcel : parcels) {
            System.out.println(counter + " - " + parcel.getDescription());
            counter++;
        }
    }

    public List<T> getParcels() {
        return parcels;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
}