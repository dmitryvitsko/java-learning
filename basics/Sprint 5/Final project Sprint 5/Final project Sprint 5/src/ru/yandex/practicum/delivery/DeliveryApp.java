package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(50);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(20);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(30);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateTrackingStatus();
                    break;
                case 5:
                    System.out.println("Выберите тип коробки:");
                    System.out.println("1 — StandardParcel");
                    System.out.println("2 — PerishableParcel");
                    System.out.println("3 — FragileParcel");

                    int typeOfBox = Integer.parseInt(scanner.nextLine());

                    switch (typeOfBox) {
                        case 1:
                            standardParcelBox.getAllParcels();
                            break;
                        case 2:
                            perishableParcelBox.getAllParcels();
                            break;
                        case 3:
                            fragileParcelBox.getAllParcels();
                            break;
                        default:
                            System.out.println("Неверный выбор.");
                    }

                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус трекинга");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — StandardParcel");
        System.out.println("2 — PerishableParcel");
        System.out.println("3 — FragileParcel");

        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите название и описание посылки:");
        String parcelDescription = scanner.nextLine();

        System.out.println("Введите вес посылки:");
        int parcelWeight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес получателя посылки:");
        String parcelAddres = scanner.nextLine();

        System.out.println("Введите день отправления посылки:");
        int parcelSendDay = Integer.parseInt(scanner.nextLine());

        int parcelTimeToLive = 0;
        if (choice == 2) {
            System.out.println("Введите срок годности посылки:");
            parcelTimeToLive = Integer.parseInt(scanner.nextLine());
        }


        switch (choice) {
            case 1:
                StandardParcel parcelStandart = new StandardParcel(parcelDescription, parcelWeight, parcelAddres, parcelSendDay);
                allParcels.add(parcelStandart);
                standardParcelBox.addParcel(parcelStandart);
                break;
            case 2:
                PerishableParcel parcelPerishable = new PerishableParcel(parcelDescription, parcelWeight, parcelAddres, parcelSendDay, parcelTimeToLive);
                allParcels.add(parcelPerishable);
                perishableParcelBox.addParcel(parcelPerishable);
                break;
            case 3:
                FragileParcel parcelFragile = new FragileParcel(parcelDescription, parcelWeight, parcelAddres, parcelSendDay);
                allParcels.add(parcelFragile);
                trackableParcels.add(parcelFragile);
                fragileParcelBox.addParcel(parcelFragile);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        double totalCost = 0;

        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + totalCost);
    }

    private static void updateTrackingStatus() {
        if (trackableParcels.isEmpty()) {
            System.out.println("Список посылок с трекингом пуст");
            return;
        }
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();

        for (Trackable trackable : trackableParcels) {
            trackable.reportStatus(newLocation);
        }
    }
}
