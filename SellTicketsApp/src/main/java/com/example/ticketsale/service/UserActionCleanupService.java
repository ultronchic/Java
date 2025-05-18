package com.example.ticketsale.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

@EnableScheduling
@Service
public class UserActionCleanupService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Метод будет выполняться каждый день в полночь
    @Scheduled(cron = "0 0 0 0 7 ?")
    public void deleteOldUserActions() {
        // Получаем текущую дату и время минус два дня
        LocalDateTime twoDaysAgo = LocalDateTime.now().minusDays(2);

        // SQL запрос для удаления записей старше двух дней
        String sql = "DELETE FROM UserActions WHERE timeAction < 3";

        // Выполняем запрос
        int rowsDeleted = jdbcTemplate.update(sql, twoDaysAgo);

        System.out.println("Deleted " + rowsDeleted + " old user actions.");
    }
}
