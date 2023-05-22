package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
