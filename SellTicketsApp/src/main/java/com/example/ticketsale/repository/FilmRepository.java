package com.example.ticketsale.repository;

import com.example.ticketsale.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}