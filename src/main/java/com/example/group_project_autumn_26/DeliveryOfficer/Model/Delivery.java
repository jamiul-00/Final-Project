
package com.example.group_project_autumn_26.DeliveryOfficer.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Delivery implements Serializable {

    private int deliveryId;
    private int orderId;
    private int userId;
    private String deliveryStatus;
    private String receiverName;
    private String failureReason;
    private LocalDate deliveryDate;

    public Delivery(int deliveryId, int orderId, int userId,
                    String deliveryStatus, String receiverName,
                    LocalDate deliveryDate) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.userId = userId;
        this.deliveryStatus = deliveryStatus;
        this.receiverName = receiverName;
        this.deliveryDate = deliveryDate;
        this.failureReason = "";
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    @Override
    public String toString() {
        return "Delivery ID: " + deliveryId +
                ", Order ID: " + orderId +
                ", User ID: " + userId +
                ", Status: " + deliveryStatus +
                ", Receiver: " + receiverName +
                ", Failure Reason: " + failureReason +
                ", Date: " + deliveryDate;
    }
}
