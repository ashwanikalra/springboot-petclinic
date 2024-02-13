package com.learning.springpetclinicdemo.service;

import com.learning.springpetclinicdemo.entity.Owner;
import com.learning.springpetclinicdemo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findOwnersByLastName(String lastName) {
        return ownerRepository.findOwnersByLastName(lastName);
    }

    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Integer id) {
        Optional<Owner> optionalEmployee = ownerRepository.findById(id);
        Owner owner = null;
        if (optionalEmployee.isPresent()) {
            owner = optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee not found for id: " + id);
        }
        return owner;
    }

    public void saveOwner(Owner owner) {

        this.ownerRepository.save(owner);
    }

    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

}
