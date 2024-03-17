package com.learning.springpetclinicdemo.controller;


import com.learning.springpetclinicdemo.entity.Owner;
import com.learning.springpetclinicdemo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("")
    public List<Owner> getAllOwners() {

        return ownerService.getAllOwners();
    }

    @GetMapping("/findOwnerByLastName/{lastName}")
    public List<Owner> findOwnerByLastName(@RequestParam String lastName) {
        List<Owner> owners = ownerService.findOwnersByLastName(lastName);
        return owners;
    }

    @GetMapping("{ownerId}")
    public Owner getById(@PathVariable("ownerId") Integer id) {
        Owner owner = ownerService.getOwnerById(id);
        return owner;
    }

    @PostMapping("")
    public String saveOwner(@Validated @RequestBody Owner owner) {
        ownerService.saveOwner(owner);
        return "Owner with saved Sucssessfully";
    }


}
