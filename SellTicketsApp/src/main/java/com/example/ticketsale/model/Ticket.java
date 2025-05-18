package com.example.ticketsale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Уникальный id пользователя

    private Long filmId; // Уникальный id фильма

    private int ticketNumber;//Номер билета

    private LocalTime moovieTime; // время билета-сеанса

    private LocalDate moovieDate; // дата билета

    private String status; // Статус билета (продан, в наличии)

@ManyToOne
@JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;
    // Геттеры и сеттеры...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

}