package com.learning.springpetclinicdemo.repository;

import com.learning.springpetclinicdemo.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
