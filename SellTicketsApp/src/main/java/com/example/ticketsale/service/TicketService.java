package com.example.ticketsale.service;

import com.example.ticketsale.model.Film;
import com.example.ticketsale.model.Ticket;
import com.example.ticketsale.repository.FilmRepository;
import com.example.ticketsale.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private DataSource dataSource;

    public void buyTicket(Long filmID) {
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            connection.setAutoCommit(false);

            // проверка доступных билетов
            PreparedStatement checkStmt = connection.prepareStatement("SELECT available_tickets FROM film WHERE id = ?");
            checkStmt.setLong(1, filmID);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt("available_tickets") > 0) {
                // Обновление билетов на фильмы
                PreparedStatement updateFilmStmt = connection.prepareStatement(
                        "UPDATE film SET available_tickets = available_tickets - 1, sold_tickets = sold_tickets + 1 WHERE id = ?");
                updateFilmStmt.setLong(1, filmID);
                updateFilmStmt.executeUpdate();

                // Добавление нового билета
                PreparedStatement insertTicketStmt = connection.prepareStatement(
                        "INSERT INTO ticket (film_id, status) VALUES (?, 'продан')");
                insertTicketStmt.setLong(1, filmID);
                insertTicketStmt.executeUpdate();

                connection.commit();
            } else {
                throw new RuntimeException("No tickets available");
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                throw new RuntimeException("Rollback failed", rollbackEx);
            }
            throw new RuntimeException("Transaction failed", e);
        } finally {
            DataSourceUtils.releaseConnection(connection, dataSource);
        }
    }
    public void returnTicket(Long ticketID) {
        Connection connection = DataSourceUtils.getConnection(dataSource);
        try {
            connection.setAutoCommit(false);

            // Проверка на статус билета и ID фильма
            PreparedStatement checkStmt = connection.prepareStatement(
                    "SELECT film_id FROM ticket WHERE id = ? AND status = 'продан'");
            checkStmt.setLong(1, ticketID);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                Long filmID = rs.getLong("film_id");

                // Обновление статуса билета
                PreparedStatement updateTicketStmt = connection.prepareStatement(
                        "UPDATE ticket SET status = 'в наличии' WHERE id = ?");
                updateTicketStmt.setLong(1, ticketID);
                updateTicketStmt.executeUpdate();

                // Обновление билетов на фильм
                PreparedStatement updateFilmStmt = connection.prepareStatement(
                        "UPDATE film SET available_tickets = available_tickets + 1, sold_tickets = sold_tickets - 1 WHERE id = ?");
                updateFilmStmt.setLong(1, filmID);
                updateFilmStmt.executeUpdate();

                connection.commit();
            } else {
                throw new RuntimeException("Ticket is not sold or not found");
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                throw new RuntimeException("Rollback failed", rollbackEx);
            }
            throw new RuntimeException("Transaction failed", e);
        } finally {
            DataSourceUtils.releaseConnection(connection, dataSource);
        }
    }










    }
//прошлый метод
    /* public boolean purchaseTicket(Long filmId) {
        Film film = filmRepo.findById(filmId).orElse(null);
        if (film != null && film.getAvailableTickets() > 0) {
            // Уменьшаем количество доступных билетов и увеличиваем количество проданных
            film.setAvailableTickets(film.getAvailableTickets() - 1);
            film.setSoldTickets(film.getSoldTickets() + 1);
            filmRepo.save(film);

            // Обновляем статус билета
            Ticket ticket = ticketRepo.findFirstByFilmIdAndStatus(filmId, "available");
            if (ticket != null) {
                ticket.setStatus("sold");
                ticketRepo.save(ticket);
                return true;
            }
        }
        return false;
    }
    public boolean returnTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket != null && "sold".equals(ticket.getStatus())) {
            Film film = ticket.getFilm();
            film.setAvailableTickets(film.getAvailableTickets() + 1);
            film.setSoldTickets(film.getSoldTickets() - 1);
            filmRepository.save(film);

            ticket.setStatus("available");
            ticketRepository.save(ticket);

            return true;
        }
        return false;

    }
     */
