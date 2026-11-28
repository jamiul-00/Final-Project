
package com.example.group_project_autumn_26.DeliveryOfficer.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DeliveryOfficer {

    private static ArrayList<Delivery> deliveryList = loadDeliveries();

    public DeliveryOfficer() {
    }

    public static ArrayList<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public static void addDelivery(Delivery delivery) {
        deliveryList.add(delivery);
        saveDeliveries();
    }

    public static Delivery findDeliveryById(int deliveryId) {
        for (Delivery delivery : deliveryList) {
            if (delivery.getDeliveryId() == deliveryId) {
                return delivery;
            }
        }
        return null;
    }

    public static void saveDeliveries() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("deliveries.dat"));
            output.writeObject(deliveryList);
            output.close();
        } catch (IOException e) {
            System.out.println("Could not save delivery records.");
        }
    }

    private static ArrayList<Delivery> loadDeliveries() {
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("deliveries.dat"));

            ArrayList<Delivery> savedList =
                    (ArrayList<Delivery>) input.readObject();

            input.close();
            return savedList;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void viewAssignedDeliveries() {
    }

    public void viewDeliveryDetails() {
    }

    public void updateDeliveryStatus() {
    }

    public void confirmDelivery() {
    }

    public void reportFailedDelivery() {
    }
}
