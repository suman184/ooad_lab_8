package com.example.packagetracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String trackingId;

    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String destinationCity;

    @Column(nullable = false)
    private String deliveryStatus;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdTime;

    // Constructors
    public Package() {
    }

    public Package(String trackingId, String senderName, String receiverName, 
                   String destinationCity, String deliveryStatus) {
        this.trackingId = trackingId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.destinationCity = destinationCity;
        this.deliveryStatus = deliveryStatus;
    }

    // Automatically set createdTime before persisting
    @PrePersist
    protected void onCreate() {
        this.createdTime = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", trackingId='" + trackingId + '\'' +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
