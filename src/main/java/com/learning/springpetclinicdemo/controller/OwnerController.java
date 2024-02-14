package com.learning.springpetclinicdemo.controller;

import com.learning.springpetclinicdemo.entity.Owner;
import com.learning.springpetclinicdemo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;


    @GetMapping("/find")
    @PreAuthorize("hasRole('pet-admin')")
    public List<Owner> findAllOwner() {
        return ownerService.findAllOwners();
    }


}
