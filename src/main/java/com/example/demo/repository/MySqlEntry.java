package com.example.demo.repository;

import com.example.demo.Model.Cakes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MySqlEntry extends JpaRepository<Cakes, Integer> {
    List<Cakes> findByFlavourContainingIgnoreCase(String flavour);
}