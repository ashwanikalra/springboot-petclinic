package com.learning.springpetclinicdemo.service;

import com.learning.springpetclinicdemo.entity.Pet;
import com.learning.springpetclinicdemo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public void savePet(Pet pet) {

        this.petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
