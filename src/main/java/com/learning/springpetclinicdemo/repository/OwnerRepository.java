package com.learning.springpetclinicdemo.repository;

import com.learning.springpetclinicdemo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
     List<Owner> findOwnersByLastName(String lastName);
}
