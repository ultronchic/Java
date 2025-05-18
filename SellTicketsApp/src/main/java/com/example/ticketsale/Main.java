package com.example.ticketsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.example.ticketsale")
public class Main {
    public static void main(String[] args) { // Исправлено на 'main'
        SpringApplication.run(Main.class, args);
    }
}
//TicketSaleApplication было
//public class TicketSaleApplication {
//    public void main(String[] args) { // Исправлено на 'main'
//        SpringApplication.run(TicketSaleApplication.class, args);