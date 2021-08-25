package com.sthol.sfgpetclinic.services;

import com.sthol.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet Owner);

    Set<Pet> findAll();
}
