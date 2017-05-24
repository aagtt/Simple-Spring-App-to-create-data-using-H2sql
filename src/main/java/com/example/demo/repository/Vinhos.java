package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long> {

}
