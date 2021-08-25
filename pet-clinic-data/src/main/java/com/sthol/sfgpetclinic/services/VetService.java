package com.sthol.sfgpetclinic.services;

import com.sthol.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet Owner);

    Set<Vet> findAll();
}
