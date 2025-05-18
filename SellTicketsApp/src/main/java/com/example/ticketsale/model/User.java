package com.example.ticketsale.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // Статус пользователя (гость или покупатель)

    private Long purchasedFilmId; // Уникальный id фильма, который купил пользователь

    private LocalDateTime actionTime; // сохраняем последнее действие пользователя


    // Геттеры и сеттеры...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPurchasedFilmId() {
        return purchasedFilmId;
    }

    public void setPurchasedFilmId(Long purchasedFilmId) {
        this.purchasedFilmId = purchasedFilmId;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }
}